package br.com.fiap.gs;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "trilhas")
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da trilha é obrigatório")
    @Size(min = 3, max = 150, message = "O nome deve ter entre 3 e 150 caracteres")
    private String nome;

    private String descricao;

    @NotBlank(message = "O nível é obrigatório")
    @Size(max = 50, message = "O nível deve ter no máximo 50 caracteres")
    private String nivel;

    @Min(value = 1, message = "A carga horária deve ser de no mínimo 1 hora")
    @Column(name = "carga_horaria")
    private int cargaHoraria;

    @Size(max = 100, message = "O foco principal deve ter no máximo 100 caracteres")
    @Column(name = "foco_principal")
    private String focoPrincipal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getFocoPrincipal() {
        return focoPrincipal;
    }

    public void setFocoPrincipal(String focoPrincipal) {
        this.focoPrincipal = focoPrincipal;
    }
}