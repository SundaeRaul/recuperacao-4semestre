package backend.provarecuperacao.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "emprestimos")
public class Emprestimos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emprestimoId;

    @ManyToOne
    @JoinColumn(name = "exemplar_id")
    private Exemplares exemplar;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Emprestimos() {
    }

    public Emprestimos(Long emprestimoId, Exemplares exemplar, Usuarios usuario) {
        this.emprestimoId = emprestimoId;
        this.exemplar = exemplar;
        this.usuario = usuario;
    }

    public Long getEmprestimoId() {
        return emprestimoId;
    }

    public void setEmprestimoId(Long emprestimoId) {
        this.emprestimoId = emprestimoId;
    }

    public Exemplares getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplares exemplar) {
        this.exemplar = exemplar;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
