package backend.provarecuperacao.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categorias implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaId;
    private String categoriaNome;

    @JsonIgnore
    @OneToMany(mappedBy = "categorias", cascade = CascadeType.ALL)
    private List<Livros> livros_categorias = new ArrayList<>();

    public Categorias() {
    }

    public Categorias(Long categoriaId, String categoriaNome, List<Livros> livros_categorias) {
        this.categoriaId = categoriaId;
        this.categoriaNome = categoriaNome;
        this.livros_categorias = livros_categorias;
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

    public List<Livros> getLivros() {
        return livros_categorias;
    }
}
