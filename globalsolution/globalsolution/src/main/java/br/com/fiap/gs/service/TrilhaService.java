package br.com.fiap.gs.service;

import br.com.fiap.gs.Trilha;
import br.com.fiap.gs.exception.TrilhaNaoEncontradaException;
import br.com.fiap.gs.repository.TrilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhaService {

    private final TrilhaRepository trilhaRepository;

    @Autowired
    public TrilhaService(TrilhaRepository trilhaRepository) {
        this.trilhaRepository = trilhaRepository;
    }

    public List<Trilha> listarTodas() {
        return trilhaRepository.findAll();
    }

    public Trilha buscarPorId(Long id) {
        return trilhaRepository.findById(id)
                .orElseThrow(() -> new TrilhaNaoEncontradaException(id));
    }

    public Trilha criarTrilha(Trilha trilha) {
        return trilhaRepository.save(trilha);
    }

    // --- MÉTODO QUE FALTAVA (PASSO 16) ---

    /**
     * Método para atualizar uma trilha existente (PUT /trilhas/{id})
     */
    public Trilha atualizarTrilha(Long id, Trilha trilhaAtualizada) {
        // 1. Tenta buscar a trilha no banco pelo ID
        Trilha trilhaExistente = trilhaRepository.findById(id).orElse(null);

        // 2. Se encontrou a trilha...
        if (trilhaExistente != null) {
            // 3. Atualiza os campos da trilha existente com os novos dados
            trilhaExistente.setNome(trilhaAtualizada.getNome());
            trilhaExistente.setDescricao(trilhaAtualizada.getDescricao());
            trilhaExistente.setNivel(trilhaAtualizada.getNivel());
            trilhaExistente.setCargaHoraria(trilhaAtualizada.getCargaHoraria());
            trilhaExistente.setFocoPrincipal(trilhaAtualizada.getFocoPrincipal());

            // 4. Salva a trilha ATUALIZADA (JPA entende que é um UPDATE)
            return trilhaRepository.save(trilhaExistente);
        } else {
            // 5. Se não encontrou (ID não existe), retorna nulo.
            return null;
        }
    }

    public void deletarTrilha(Long id) {
        // O JpaRepository já tem um método 'deleteById' prontinho
        trilhaRepository.deleteById(id);
    }

}