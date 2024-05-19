package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.model.Categoria;
import com.anthonyponte.wallet.service.CategoryService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

  @Autowired
  private CategoryService service;

  @RequestMapping("/categories")
  public String showCategories(Model model) {
    List<Categoria> categorias = service.readAll();
    model.addAttribute("categorias", categorias);
    return "categories";
  }

  @RequestMapping("/category/new")
  public String newAccount(Model model) {
    model.addAttribute("categoria", new Categoria());
    return "category";
  }

  @PostMapping("/category/save")
  public String saveAccount(Categoria categoria) {
    service.save(categoria);
    return "redirect:/";
  }
}
