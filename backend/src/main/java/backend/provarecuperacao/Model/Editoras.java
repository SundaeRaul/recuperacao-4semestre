package backend.provarecuperacao.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "editoras")
public class Editoras implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long editoraId;
    private String editoraNome;

    @JsonIgnore
    @OneToMany(mappedBy = "editoras", cascade = CascadeType.ALL)
    private List<Livros> livros_editoras = new ArrayList<>();

    public Editoras() {
    }

    public Editoras(Long editoraId, String editoraNome, List<Livros> livros_editoras) {
        this.editoraId = editoraId;
        this.editoraNome = editoraNome;
        this.livros_editoras = livros_editoras;
    }

    public Long getEditoraId() {
        return editoraId;
    }

    public void setEditoraId(Long editoraId) {
        this.editoraId = editoraId;
    }

    public String getEditoraNome() {
        return editoraNome;
    }

    public void setEditoraNome(String editoraNome) {
        this.editoraNome = editoraNome;
    }

    public List<Livros> getLivros_editoras() {
        return livros_editoras;
    }
}
