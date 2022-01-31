package backend.provarecuperacao.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livros implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long livroId;
    private String livroNome;
    private int exemplares;

    @ManyToOne
    private Categorias categoria;

    @ManyToOne
    @JoinColumn(name = "autor")
    private Autores autor;

    @ManyToOne
    @JoinColumn(name = "editora")
    private Editoras editora;

    @JsonIgnore
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    private List<Emprestimos> emprestimos_livro;



    public Livros() {
    }

    public Livros(Long livroId, String livroNome, int exemplares, Categorias categoria, Autores autor, Editoras editora) {
        this.livroId = livroId;
        this.livroNome = livroNome;
        this.exemplares = exemplares;
        this.categoria = categoria;
        this.autor = autor;
        this.editora = editora;
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

    public int getExemplares() {
        return exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
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

    public List<Emprestimos> getEmprestimos_livro() {
        return emprestimos_livro;
    }

}
