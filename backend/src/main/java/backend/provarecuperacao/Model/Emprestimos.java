package backend.provarecuperacao.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "emprestimos")
public class Emprestimos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emprestimoId;

    private LocalDate data;

    private LocalDate dataLimite;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livros livro;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Emprestimos() {
    }

    public Emprestimos(Long emprestimoId, Livros livro, Usuarios usuario) {
        this.emprestimoId = emprestimoId;
        this.livro = livro;
        this.usuario = usuario;
    }

    public Emprestimos(Long emprestimoId, LocalDate data, LocalDate dataLimite, Livros livro, Usuarios usuario) {
        this.emprestimoId = emprestimoId;
        this.data = data;
        this.dataLimite = dataLimite;
        this.livro = livro;
        this.usuario = usuario;
    }

    public Long getEmprestimoId() {
        return emprestimoId;
    }

    public void setEmprestimoId(Long emprestimoId) {
        this.emprestimoId = emprestimoId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

}
