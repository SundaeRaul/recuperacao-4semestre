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
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Livros> livros_autores = new ArrayList<>();

    public Autores() {
    }

    public Autores(Long autorId, String autorNome) {
        this.autorId = autorId;
        this.autorNome = autorNome;
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
