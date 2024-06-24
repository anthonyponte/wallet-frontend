package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.model.Cuenta;
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
public class CuentaController {
  @Autowired private CuentaService service;

  @GetMapping("/")
  public String consultar(Model model) {
    List<Cuenta> listCuentas = service.readAll();
    model.addAttribute("listCuentas", listCuentas);
    return "consultarCuentas";
  }

  @RequestMapping("/cuenta/nuevo")
  public String registrar(Model model) {
    model.addAttribute("cuenta", new Cuenta());
    return "registrarCuenta";
  }

  @PostMapping("/cuenta/guardar")
  public String guardar(Cuenta cuenta, BindingResult result, RedirectAttributes attributes) {
    if (result.hasErrors()) {
      return "consultarCuentas";
    }
    System.out.println("com.anthonyponte.wallet.controller.CuentaController.guardar() " + cuenta);
    service.save(cuenta);
    attributes.addFlashAttribute("textAlertSuccess", "Se guardo la cuenta " + cuenta.getIdCuenta());
    return "redirect:/";
  }

  @RequestMapping("/cuenta/editar")
  public String editar(Integer idCuenta, Model model) {
    Cuenta cuenta = service.read(idCuenta);
    System.out.println("com.anthonyponte.wallet.controller.CuentaController.editar() " + cuenta);
    model.addAttribute("cuenta", cuenta);
    return "registrarCuenta";
  }

  @RequestMapping("/cuenta/eliminar")
  public String eliminar(Integer idCuenta) {
    service.delete(idCuenta);
    return "redirect:/";
  }
}
