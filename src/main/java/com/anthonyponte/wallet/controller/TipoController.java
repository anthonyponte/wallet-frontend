package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.model.Tipo;
import com.anthonyponte.wallet.service.TipoService;
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
public class TipoController {
  @Autowired private TipoService service;

  @GetMapping("/tipos")
  public String consultar(Model model) {
    List<Tipo> listTipos = service.readAll();
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
    service.save(tipo);
    attributes.addFlashAttribute(
        "textAlertSuccess", "Se guardo el tipo '" + tipo.getIdTipo()+ "'");
    return "redirect:/tipos";
  }

  @RequestMapping("/tipo/editar")
  public String editar(int idTipo, Model model) {
    Tipo tipo = service.read(idTipo);
    model.addAttribute("tipo", tipo);
    return "registrarTipo";
  }

  @RequestMapping("/tipo/eliminar")
  public String eliminar(int idTipo, Model model) {
    service.delete(idTipo);
    return "redirect:/tipos";
  }
}
