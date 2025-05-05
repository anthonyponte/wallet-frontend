package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.entity.Cuenta;
import com.anthonyponte.wallet.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import com.anthonyponte.wallet.service.CuentaService;
import com.anthonyponte.wallet.service.UsuarioService;

@Controller
@RequestMapping("/cuentas")
public class CuentaController {
  @Autowired
  private CuentaService<Cuenta> service;

  @Autowired
  private UsuarioService<Usuario> usuarioService;

  @GetMapping
  public String consultar(Model model, Pageable pageable) {
    Page<Cuenta> listCuentas = service.getAll(pageable);
    model.addAttribute("listCuentas", listCuentas);
    return "consultarCuentas";
  }

  @RequestMapping("/nuevo")
  public String registrar(Model model) {
    model.addAttribute("cuenta", new Cuenta());
    return "registrarCuenta";
  }

  @PostMapping("/guardar")
  public String guardar(Cuenta cuenta, BindingResult result, RedirectAttributes attr, Authentication auth) {
    if (result.hasErrors()) {
      return "consultarCuentas";
    }
    
    String username = auth.getName();
    Usuario usuario = usuarioService.getByUsername(username);
    cuenta.setUsuario(usuario);

    service.create(cuenta);
    attr.addFlashAttribute("textAlertSuccess", "Se guardo la cuenta " + cuenta.getIdCuenta());
    return "redirect:/";
  }

  @GetMapping("/editar/{idCuenta}")
  public String editar(@PathVariable("idCuenta") Long idCuenta, Model model) {
    Cuenta cuenta = service.getById(idCuenta);
    model.addAttribute("cuenta", cuenta);
    return "registrarCuenta";
  }

  @GetMapping("/eliminar/{idCuenta}")
  public String eliminar(@PathVariable("idCuenta") Long idCuenta, RedirectAttributes attr) {
    service.delete(idCuenta);
    attr.addFlashAttribute("textAlertSuccess", "Se elimino la cuenta " + idCuenta);
    return "redirect:/";
  }
}
