package backend.provarecuperacao.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "emprestimos")
public class Emprestimos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emprestimoId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    private Date data;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

}
