package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Usuario;
import com.example.SistemaReservaSalas.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Exibição da página HTML para gerenciamento de usuários
    @GetMapping
    public ModelAndView usuarios(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usuarios"); // Nome da página Thymeleaf
        modelAndView.addObject("usuarios", usuarioService.listarUsuarios());  // Passando a lista de usuários
        modelAndView.addObject("usuario", new Usuario()); // Adicionando um objeto Usuario vazio para o modal
        return modelAndView;
    }

    // Listar todos os usuários
    @GetMapping("/listar")
    @ResponseBody
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    // Buscar um usuário específico pelo ID (usado para editar ou detalhes)
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    // Salvar um novo usuário
    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.salvarUsuario(usuario); // Chama o serviço para salvar o usuário
        return "redirect:/usuarios"; // Redireciona para a página de usuários após salvar
    }

    // Excluir um usuário pelo ID
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        if (usuarioService.buscarUsuarioPorId(id).isPresent()) {
            usuarioService.excluirUsuario(id);
            return ResponseEntity.noContent().build();  // 204 - No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 - Not Found
        }
    }
}
