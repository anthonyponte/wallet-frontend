package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.model.Transaccion;
import com.anthonyponte.wallet.model.Cuenta;
import com.anthonyponte.wallet.model.Tipo;
import com.anthonyponte.wallet.model.Categoria;
import com.anthonyponte.wallet.service.TransaccionService;
import com.anthonyponte.wallet.service.CuentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TransaccionController {
  @Autowired private TransaccionService transaccionService;
  @Autowired private CuentaService cuentaService;

  @GetMapping("/transacciones")
  public String consultar(int idCuenta, Model model) {
    List<Transaccion> listTransacciones = transaccionService.readAll(idCuenta);
    Cuenta cuenta = cuentaService.read(idCuenta);
    model.addAttribute("listTransacciones", listTransacciones);
    model.addAttribute("cuenta", cuenta);
    return "consultarTransacciones";
  }

  @RequestMapping("/transaccion/nuevo")
  public String registrar(Model model) {
    List<Tipo> listTipos = transaccionService.readTypes();
    List<Categoria> listCategorias = transaccionService.readCategories();
    model.addAttribute("listTipos", listTipos);
    model.addAttribute("listCategorias", listCategorias);
    model.addAttribute("transaccion", new Transaccion());
    return "registrarTransaccion";
  }

  @PostMapping("/transaccion/guardar")
  public String guardar(
      Transaccion transaccion, BindingResult result, RedirectAttributes attributes) {
    if (result.hasErrors()) {
      return "registrarTransaccion";
    }
    transaccionService.save(transaccion);
    attributes.addFlashAttribute(
        "textAlertSuccess", "Se guardo la transaccion " + transaccion.getIdTransaccion());
    return "redirect:/transacciones";
  }
}
