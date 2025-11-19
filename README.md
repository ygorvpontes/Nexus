# 🌍 Global Solution 2025 - O Futuro do Trabalho
### Plataforma de Upskilling / Reskilling

API RESTful desenvolvida para a Global Solution da FIAP. O objetivo é gerenciar uma plataforma de educação focada em preparar profissionais para as competências de 2030+ (IA, Soft Skills, Dados).

---

## 👨‍💻 Integrantes do Grupo

* **Gabriel Barros Mazzariol** - RM: 555410
* **Ygor Vieira Pontes** - RM: 555686

---

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA**
* **H2 Database** (Banco em memória)
* **Bean Validation**

---

## 🚀 Como Executar o Projeto

1.  **Pré-requisitos:** Ter o JDK 17 e o Maven instalados.
2.  **Clone o repositório:**
    ```bash
    git clone [URL_DO_SEU_GIT]
    ```
3.  **Execute a aplicação:**
    No terminal (na pasta raiz), rode:
    ```bash
    mvn spring-boot:run
    ```
4.  **Acesse a API:** A aplicação subirá em `http://localhost:8080`.

---

## 🗄️ Banco de Dados (H2 Console)

O projeto utiliza banco em memória H2 e carrega dados iniciais (seeds) automaticamente.

* **URL do Console:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:globalsolutiondb`
* **User:** `sa`
* **Password:** *(deixe em branco)*

---

## 📡 Endpoints da API

### 📚 Trilhas (`/trilhas`)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/trilhas` | Lista todas as trilhas cadastradas. |
| `GET` | `/trilhas/{id}` | Busca detalhes de uma trilha específica. |
| `POST` | `/trilhas` | Cria uma nova trilha (JSON Obrigatório). |
| `PUT` | `/trilhas/{id}` | Atualiza os dados de uma trilha. |
| `DELETE` | `/trilhas/{id}` | Remove uma trilha do sistema. |

#### Exemplo de JSON (POST/PUT Trilha)
```json
{
  "nome": "Engenharia de Prompt para Devs",
  "descricao": "Domine a arte de conversar com LLMs.",
  "nivel": "AVANCADO",
  "cargaHoraria": 40,
  "focoPrincipal": "IA Generativa"
}
