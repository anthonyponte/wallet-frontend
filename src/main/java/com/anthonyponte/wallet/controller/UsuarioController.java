package com.anthonyponte.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anthonyponte.wallet.entity.Perfil;
import com.anthonyponte.wallet.entity.Usuario;
import com.anthonyponte.wallet.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cuentas")
public class UsuarioController {
    @Autowired
    private UsuarioService<Usuario> usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String index(Authentication auth, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            String username = auth.getName();
            Usuario usuario = usuarioService.getByUsername(username);
            session.setAttribute("username", usuario);
        }
        return "redirect:/cuentas";
    }

    @GetMapping("/login")
    public String login() {
        return "ingresarUsuario";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        SecurityContextLogoutHandler handler = new SecurityContextLogoutHandler();
        handler.logout(request, null, null);
        return "redirect:/login";
    }

    @RequestMapping("/nuevo")
    public String registrar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registrarUsuario";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "registrarUsuario";
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setEstado(1);
        usuario.getPerfiles().add(new Perfil(2L, "USUARIO"));

        usuarioService.create(usuario);

        attributes.addFlashAttribute(
                "textAlertSuccess", "Se guardo el usuario '" + usuario.getIdUsuario() + "'");
        return "redirect:/";
    }
}
