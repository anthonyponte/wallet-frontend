package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.model.Categoria;
import com.anthonyponte.wallet.service.CategoriaService;
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
public class CategoriaController {
  @Autowired private CategoriaService service;

  @GetMapping("/categorias")
  public String consultar(Model model) {
    List<Categoria> listCategorias = service.readAll();
    model.addAttribute("listCategorias", listCategorias);
    return "consultarCategorias";
  }

  @RequestMapping("/categoria/nuevo")
  public String registrar(Model model) {
    model.addAttribute("categoria", new Categoria());
    return "registrarCategoria";
  }

  @PostMapping("/categoria/guardar")
  public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
    if (result.hasErrors()) {
      return "registrarCategoria";
    }
    service.save(categoria);
    attributes.addFlashAttribute(
        "textAlertSuccess", "Se guardo la categoria " + categoria.getIdCategoria());
    return "redirect:/categorias";
  }

  @RequestMapping("/categoria/editar")
  public String editar(Integer idCategoria, Model model) {
    Categoria categoria = service.read(idCategoria);
    model.addAttribute("categoria", categoria);
    return "registrarCategoria";
  }

  @RequestMapping("/categoria/eliminar")
  public String eliminar(Integer idCategoria) {
    service.delete(idCategoria);
    return "redirect:/categorias";
  }
}
