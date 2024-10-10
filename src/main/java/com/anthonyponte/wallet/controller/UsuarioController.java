package com.anthonyponte.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.anthonyponte.wallet.entity.Usuario;
import com.anthonyponte.wallet.service.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

    @Autowired
    private IUsuarioService<Usuario> service;

    @GetMapping("/index")
    public String index(Authentication auth, HttpSession session) {
        String username = auth.getName();

        if (session.getAttribute("usuario") == null) {
            Usuario usuario = service.getByUsername(username);
            System.out.println(usuario);
            session.setAttribute("usuario", usuario);
        }
        return "redirect:/";
    }
}
