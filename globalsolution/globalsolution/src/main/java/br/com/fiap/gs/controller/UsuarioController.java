package br.com.fiap.gs.controller;

import br.com.fiap.gs.Usuario;
import br.com.fiap.gs.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarTodosUsuarios() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public Usuario criarUsuario(@Valid @RequestBody Usuario novoUsuario) {
        return usuarioService.criarUsuario(novoUsuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuarioAtualizado) {
        return usuarioService.atualizarUsuario(id, usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }
}