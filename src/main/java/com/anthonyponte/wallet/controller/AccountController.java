package com.anthonyponte.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anthonyponte.wallet.model.Cuenta;
import com.anthonyponte.wallet.service.AccountService;
import org.springframework.validation.BindingResult;

@Controller
public class AccountController {

  @Autowired
  private AccountService service;

  @GetMapping("/")
  public String showAccounts(Model model) {
    List<Cuenta> cuentas = service.readAll();
    model.addAttribute("cuentas", cuentas);
    return "accounts";
  }

  @RequestMapping("/account/new")
  public String newAccount(Model model) {
    model.addAttribute("cuenta", new Cuenta());
    return "account";
  }

  @PostMapping("/account/save")
  public String saveAccount(Cuenta cuenta, BindingResult result, RedirectAttributes attributes) {
    if (result.hasErrors()) {
      return "account";
    }
    service.save(cuenta);
    attributes.addFlashAttribute("textAlertSuccess", "Se guardo la cuenta '" + cuenta.getNombre() + "'");
    return "redirect:/";
  }

  @RequestMapping("/account/edit")
  public String editAccount(int id, Model model) {
    Cuenta cuenta = service.read(id);
    model.addAttribute("cuenta", cuenta);
    return "account";
  }

  @RequestMapping("/account/delete")
  public String deleteAccount(int id, Model model) {
    service.delete(id);
    return "redirect:/";
  }
}
