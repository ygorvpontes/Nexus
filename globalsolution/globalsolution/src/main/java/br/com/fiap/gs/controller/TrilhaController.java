package br.com.fiap.gs.controller;

import br.com.fiap.gs.Trilha;
import br.com.fiap.gs.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trilhas")
public class TrilhaController {

    private final TrilhaService trilhaService;

    @Autowired
    public TrilhaController(TrilhaService trilhaService) {
        this.trilhaService = trilhaService;
    }

    @GetMapping
    public List<Trilha> listarTodasTrilhas() {
        return trilhaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Trilha buscarTrilhaPorId(@PathVariable Long id) {
        return trilhaService.buscarPorId(id);
    }

    @PostMapping
    public Trilha criarTrilha(@Valid @RequestBody Trilha novaTrilha) {
        return trilhaService.criarTrilha(novaTrilha);
    }

    @PutMapping("/{id}")
    public Trilha atualizarTrilha(@PathVariable Long id, @Valid @RequestBody Trilha trilhaAtualizada) {
        return trilhaService.atualizarTrilha(id, trilhaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarTrilha(@PathVariable Long id) {
        trilhaService.deletarTrilha(id);
    }
}