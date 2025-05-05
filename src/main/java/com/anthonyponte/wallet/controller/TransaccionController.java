package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.entity.Transaccion;
import com.anthonyponte.wallet.entity.Cuenta;
import com.anthonyponte.wallet.entity.Tipo;
import com.anthonyponte.wallet.entity.Categoria;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.anthonyponte.wallet.service.TransaccionService;
import com.anthonyponte.wallet.service.TipoService;
import com.anthonyponte.wallet.service.CuentaService;
import com.anthonyponte.wallet.service.CategoriaService;

@Controller
@RequestMapping("/transacciones")
public class TransaccionController {
  @Autowired
  private TransaccionService<Transaccion> transaccionService;
  @Autowired
  private CuentaService<Cuenta> cuentaService;
  @Autowired
  private TipoService<Tipo> tipoService;
  @Autowired
  private CategoriaService<Categoria> categoriaService;

  @GetMapping("/{idCuenta}")
  public String consultar(@PathVariable("idCuenta") Long idCuenta, Model model) {
    List<Transaccion> listTransacciones = Lists.newArrayList(transaccionService.getAll(idCuenta));
    Cuenta cuenta = cuentaService.getById(idCuenta);
    model.addAttribute("listTransacciones", listTransacciones);
    model.addAttribute("cuenta", cuenta);
    return "consultarTransacciones";
  }

  @GetMapping("/nuevo/{idCuenta}")
  public String registrar(@PathVariable("idCuenta") Long idCuenta, Model model) {
    Cuenta cuenta = cuentaService.getById(idCuenta);
    model.addAttribute("cuenta", cuenta);
    model.addAttribute("transaccion", new Transaccion());
    return "registrarTransaccion";
  }

  @PostMapping("/guardar")
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
