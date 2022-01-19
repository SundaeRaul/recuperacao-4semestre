package backend.provarecuperacao.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exemplares")
public class Exemplares implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exemplaresId;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livros livro;

    public Exemplares() {
    }

    public Exemplares(Long exemplaresId, int quantidade, boolean disponibilidade, Livros livro) {
        this.exemplaresId = exemplaresId;
        this.quantidade = quantidade;
        this.livro = livro;
    }

    public Long getExemplaresId() {
        return exemplaresId;
    }

    public void setExemplaresId(Long exemplaresId) {
        this.exemplaresId = exemplaresId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public Livros getLivro() {
        return livro;
    }

}
