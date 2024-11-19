package com.example.SistemaReservaSalas.controllers;

import com.example.SistemaReservaSalas.models.Usuario;
import com.example.SistemaReservaSalas.services.UsuarioService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
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
        modelAndView.addObject("usuarios", listarUsuarios());
        return modelAndView;
    }

    // Listar todos os usuários como JSON
    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    // Buscar um usuário específico pelo ID
    @GetMapping("/{id}")
    public Optional<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    // Salvar um novo usuário com o tipo de usuário
    @PostMapping("/salvar")
    public Usuario salvarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String tipoUsuario) {
        // Criação do objeto Usuario
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        
        // Definindo o tipo de usuário a partir da string recebida
        try {
            usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(tipoUsuario.toUpperCase()));
        } catch (IllegalArgumentException e) {
            // Caso o tipo de usuário não seja válido
            throw new RuntimeException("Tipo de usuário inválido");
        }
        
        return usuarioService.salvarUsuario(usuario);
    }

    // Excluir um usuário pelo ID
    @DeleteMapping("/excluir/{id}")
    public void excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
    }
}
