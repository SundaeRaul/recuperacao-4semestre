package backend.provarecuperacao.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livros implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long livroId;
    private String livroNome;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categorias categoria;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autores autor;

    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editoras editora;

    @JsonIgnore
    @OneToMany(mappedBy = "livros", cascade = CascadeType.ALL)
    private List<Exemplares> exemplares_livros = new ArrayList<>();

    public Livros() {
    }

    public Livros(Long livroId, String livroNome, Categorias categoria, Autores autor, Editoras editora, List<Exemplares> exemplares_livros) {
        this.livroId = livroId;
        this.livroNome = livroNome;
        this.categoria = categoria;
        this.autor = autor;
        this.editora = editora;
        this.exemplares_livros = exemplares_livros;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public String getLivroNome() {
        return livroNome;
    }

    public void setLivroNome(String livroNome) {
        this.livroNome = livroNome;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public Editoras getEditora() {
        return editora;
    }

    public void setEditora(Editoras editora) {
        this.editora = editora;
    }

    public List<Exemplares> getExemplares_livros() {
        return exemplares_livros;
    }
}
