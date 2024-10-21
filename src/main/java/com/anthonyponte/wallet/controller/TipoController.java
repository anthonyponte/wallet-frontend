package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.entity.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.anthonyponte.wallet.service.ITipoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Controller
public class TipoController {
  @Autowired
  private ITipoService<Tipo> service;

  @GetMapping("/tipos")
  public String consultar(Model model, Pageable pageable) {
    Page<Tipo> listTipos = service.getAll(pageable);
    model.addAttribute("listTipos", listTipos);
    return "consultarTipos";
  }

  @RequestMapping("/tipo/nuevo")
  public String registrar(Model model) {
    model.addAttribute("tipo", new Tipo());
    return "registrarTipo";
  }

  @PostMapping("/tipo/guardar")
  public String guardar(Tipo tipo, BindingResult result, RedirectAttributes attributes) {
    if (result.hasErrors()) {
      return "registrarTipo";
    }
    service.create(tipo);
    attributes.addFlashAttribute(
        "textAlertSuccess", "Se guardo el tipo '" + tipo.getIdTipo() + "'");
    return "redirect:/tipos";
  }

  @GetMapping("/tipo/editar/{idTipo}")
  public String editar(@PathVariable("idTipo") Long idTipo, Model model) {
    Tipo tipo = service.getById(idTipo);
    model.addAttribute("tipo", tipo);
    return "registrarTipo";
  }

  @GetMapping("/tipo/eliminar/{idTipo}")
  public String eliminar(@PathVariable("idTipo") Long idTipo, RedirectAttributes attr) {
    service.delete(idTipo);
    attr.addFlashAttribute("textAlertSuccess", "Se elimino el tipo " + idTipo);
    return "redirect:/tipos";
  }
}
