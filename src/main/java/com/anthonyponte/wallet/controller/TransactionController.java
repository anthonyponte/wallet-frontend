package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.model.Categoria;
import com.anthonyponte.wallet.model.Cuenta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anthonyponte.wallet.model.Transaccion;
import com.anthonyponte.wallet.service.AccountService;
import com.anthonyponte.wallet.service.TransactionService;

@Controller
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @Autowired
  private AccountService accountService;

  @RequestMapping("/transactions")
  public String showTransactions(int cuentaId, Model model) {
    List<Transaccion> transacciones = transactionService.readAll(cuentaId);
    Cuenta cuenta = accountService.read(cuentaId);
    model.addAttribute("transacciones", transacciones);
    model.addAttribute("cuenta", cuenta);
    return "transactions";
  }

  @RequestMapping("/transaction/new")
  public String newAccount(Model model) {
    List<Categoria> categorias = transactionService.readCategories();
    model.addAttribute("categorias", categorias);
    model.addAttribute("transaccion", new Transaccion());
    return "transaction";
  }

  @PostMapping("/transaction/save")
  public String saveAccount(Transaccion transaccion) {
    transactionService.save(transaccion);
    return "redirect:/";
  }
}
