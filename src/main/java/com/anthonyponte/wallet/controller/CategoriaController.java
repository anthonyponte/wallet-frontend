package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.entity.Categoria;
import com.anthonyponte.wallet.service.ICategoriaService;
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
public class CategoriaController {

  @Autowired private ICategoriaService<Categoria> service;

  @GetMapping("/categorias")
  public String consultar(Model model) {
    List<Categoria> listCategorias = Lists.newArrayList(service.getAll());
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
  public String editar(@PathVariable("idCategoria") Integer idCategoria, Model model) {
    Categoria categoria = service.getById(idCategoria);
    model.addAttribute("categoria", categoria);
    return "registrarCategoria";
  }

  @GetMapping("/categoria/eliminar/{idCategoria}")
  public String eliminar(@PathVariable("idCategoria") Integer idCategoria, RedirectAttributes attr) {
    service.delete(idCategoria);
    attr.addFlashAttribute("textAlertSuccess", "Se elimino la categoria " + idCategoria);
    return "redirect:/categorias";
  }
}
