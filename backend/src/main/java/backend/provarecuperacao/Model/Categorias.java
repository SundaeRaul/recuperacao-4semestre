package backend.provarecuperacao.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categorias implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaId;
    private String categoriaNome;
    private Long limiteEmprestimo;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Livros> livros_categorias = new ArrayList<>();

    public Categorias() {
    }

    public Categorias(Long categoriaId, String categoriaNome, long limiteEmprestimo) {
        this.categoriaId = categoriaId;
        this.categoriaNome = categoriaNome;
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public Long getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(Long limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public List<Livros> getLivros() {
        return livros_categorias;
    }
}
