package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.entity.Cuenta;
import com.anthonyponte.wallet.service.ICuentaService;
import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Anthony Ponte <anthonyponte.com>
 */
@Controller
public class CuentaController {

  @Autowired private ICuentaService<Cuenta> service;

  @GetMapping("/")
  public String consultar(Model model) {
    List<Cuenta> listCuentas = Lists.newArrayList(service.getAll());
    model.addAttribute("listCuentas", listCuentas);
    return "consultarCuentas";
  }

  @RequestMapping("/cuenta/nuevo")
  public String registrar(Model model) {
    model.addAttribute("cuenta", new Cuenta());
    return "registrarCuenta";
  }

  @PostMapping("/cuenta/guardar")
  public String guardar(Cuenta cuenta, BindingResult result, RedirectAttributes attr) {
    if (result.hasErrors()) {
      return "consultarCuentas";
    }
    service.create(cuenta);
    attr.addFlashAttribute("textAlertSuccess", "Se guardo la cuenta " + cuenta.getIdCuenta());
    return "redirect:/";
  }

  @GetMapping("/cuenta/editar/{idCuenta}")
  public String editar(@PathVariable("idCuenta") Integer idCuenta, Model model) {
    Cuenta cuenta = service.getById(idCuenta);
    model.addAttribute("cuenta", cuenta);
    return "registrarCuenta";
  }

  @GetMapping("/cuenta/eliminar/{idCuenta}")
  public String eliminar(@PathVariable("idCuenta") Integer idCuenta, RedirectAttributes attr) {
    service.delete(idCuenta);
    attr.addFlashAttribute("textAlertSuccess", "Se elimino la cuenta " + idCuenta);
    return "redirect:/";
  }
}
