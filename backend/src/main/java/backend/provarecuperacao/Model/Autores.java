package backend.provarecuperacao.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autores implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autorId;
    private String autorNome;

    @JsonIgnore
    @OneToMany(mappedBy = "autores", cascade = CascadeType.ALL)
    private List<Livros> livros_autores = new ArrayList<>();

    public Autores() {
    }

    public Autores(Long autorId, String autorNome, List<Livros> livros_autores) {
        this.autorId = autorId;
        this.autorNome = autorNome;
        this.livros_autores = livros_autores;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public String getAutorNome() {
        return autorNome;
    }

    public void setAutorNome(String autorNome) {
        this.autorNome = autorNome;
    }

    public List<Livros> getLivros_autores() {
        return livros_autores;
    }
}
