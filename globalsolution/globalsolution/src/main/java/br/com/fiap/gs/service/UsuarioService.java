package br.com.fiap.gs.service;

import br.com.fiap.gs.Usuario;
import br.com.fiap.gs.exception.UsuarioNaoEncontradoException;
import br.com.fiap.gs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // ... (métodos listarTodos, buscarPorId, criarUsuario) ...
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        // Agora, se não achar, ele "estoura" a exceção 404
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }
    public Usuario criarUsuario(Usuario usuario) {
        usuario.setDataCadastro(LocalDate.now());
        return usuarioRepository.save(usuario);
    }

    // --- NOVO MÉTODO (ATUALIZAR) ---

    /**
     * Método para atualizar um usuário existente (PUT /usuarios/{id})
     */
    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        // 1. Tenta buscar o usuário no banco pelo ID
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);

        // 2. Se encontrou o usuário...
        if (usuarioExistente != null) {
            // 3. Atualiza os campos do usuário existente com os dados do 'usuarioAtualizado'
            usuarioExistente.setNome(usuarioAtualizado.getNome());
            usuarioExistente.setEmail(usuarioAtualizado.getEmail());
            usuarioExistente.setAreaAtuacao(usuarioAtualizado.getAreaAtuacao());
            usuarioExistente.setNivelCarreira(usuarioAtualizado.getNivelCarreira());
            // Nota: A data de cadastro não é alterada, ela é histórica.

            // 4. Salva o usuário ATUALIZADO no banco (o 'save' funciona como 'update' se o ID existir)
            return usuarioRepository.save(usuarioExistente);
        } else {
            // 5. Se não encontrou (ID não existe), retorna nulo.
            // (Vamos tratar isso como Erro 404 no Controller depois)
            return null;
        }
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}