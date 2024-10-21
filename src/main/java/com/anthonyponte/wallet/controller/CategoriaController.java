package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.entity.Categoria;
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
import com.anthonyponte.wallet.service.ICategoriaService;

@Controller
public class CategoriaController {
  @Autowired
  private ICategoriaService<Categoria> service;

  @GetMapping("/categorias")
  public String consultar(Model model, Pageable pageable) {
    Page<Categoria> listCategorias = service.getAll(pageable);
    model.addAttribute("listCategorias", listCategorias);
    return "consultarCategorias";
  }

  @RequestMapping("/categoria/nuevo")
  public String registrar(Model model) {
    model.addAttribute("categoria", new Categoria());
    return "registrarCategoria";
  }

  @PostMapping("/categoria/guardar")
  public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attr) {
    if (result.hasErrors()) {
      return "registrarCategoria";
    }
    service.create(categoria);
    attr.addFlashAttribute(
        "textAlertSuccess", "Se guardo la categoria " + categoria.getIdCategoria());
    return "redirect:/categorias";
  }

  @RequestMapping("/categoria/editar/{idCategoria}")
  public String editar(@PathVariable("idCategoria") Long idCategoria, Model model) {
    Categoria categoria = service.getById(idCategoria);
    model.addAttribute("categoria", categoria);
    return "registrarCategoria";
  }

  @GetMapping("/categoria/eliminar/{idCategoria}")
  public String eliminar(
      @PathVariable("idCategoria") Long idCategoria, RedirectAttributes attr) {
    service.delete(idCategoria);
    attr.addFlashAttribute("textAlertSuccess", "Se elimino la categoria " + idCategoria);
    return "redirect:/categorias";
  }
}
