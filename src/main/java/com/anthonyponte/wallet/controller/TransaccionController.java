package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.entity.Transaccion;
import com.anthonyponte.wallet.entity.Cuenta;
import com.anthonyponte.wallet.entity.Tipo;
import com.anthonyponte.wallet.entity.Categoria;
import com.anthonyponte.wallet.service.ICategoriaService;
import com.anthonyponte.wallet.service.ICuentaService;
import com.anthonyponte.wallet.service.ITipoService;
import com.anthonyponte.wallet.service.ITransaccionService;
import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Anthony Ponte <anthonyponte.com>
 */
@Controller
public class TransaccionController {

  @Autowired private ITransaccionService<Transaccion> transaccionService;
  @Autowired private ICuentaService<Cuenta> cuentaService;
  @Autowired private ITipoService<Tipo> tipoService;
  @Autowired private ICategoriaService<Categoria> categoriaService;

  @GetMapping("/transacciones/{idCuenta}")
  public String consultar(@PathVariable("idCuenta") Integer idCuenta, Model model) {
    List<Transaccion> listTransacciones = Lists.newArrayList(transaccionService.getAll(idCuenta));
    Cuenta cuenta = cuentaService.getById(idCuenta);
    model.addAttribute("listTransacciones", listTransacciones);
    model.addAttribute("cuenta", cuenta);
    return "consultarTransacciones";
  }

  @GetMapping("/transaccion/nuevo/{idCuenta}")
  public String registrar(@PathVariable("idCuenta") Integer idCuenta, Model model) {
    System.out.println("com.anthonyponte.wallet.controller.TransaccionController.registrar() "+idCuenta);
    model.addAttribute("idCuenta", idCuenta);
    model.addAttribute("transaccion", new Transaccion());
    return "registrarTransaccion";
  }

  @PostMapping("/transaccion/guardar")
  public String guardar(
      Transaccion transaccion, BindingResult result, RedirectAttributes attributes) {
    if (result.hasErrors()) {
      return "registrarTransaccion";
    }
    transaccionService.create(transaccion);
    attributes.addFlashAttribute(
        "textAlertSuccess", "Se guardo la transaccion " + transaccion.getIdTransaccion());
    return "redirect:/transacciones";
  }

  @ModelAttribute
  public void cargar(Model model) {
    List<Tipo> listTipos = Lists.newArrayList(tipoService.getAll());
    List<Categoria> listCategorias = Lists.newArrayList(categoriaService.getAll());
    model.addAttribute("listTipos", listTipos);
    model.addAttribute("listCategorias", listCategorias);
  }
}
