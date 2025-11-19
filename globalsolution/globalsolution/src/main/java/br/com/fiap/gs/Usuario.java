package br.com.fiap.gs;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do usuário é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Formato de email inválido")
    @Size(max = 150, message = "O email deve ter no máximo 150 caracteres")
    private String email;

    @Size(max = 100, message = "A área de atuação deve ter no máximo 100 caracteres")
    @Column(name = "area_atuacao")
    private String areaAtuacao;

    @Size(max = 50, message = "O nível de carreira deve ter no máximo 50 caracteres")
    @Column(name = "nivel_carreira")
    private String nivelCarreira;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getNivelCarreira() {
        return nivelCarreira;
    }

    public void setNivelCarreira(String nivelCarreira) {
        this.nivelCarreira = nivelCarreira;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}