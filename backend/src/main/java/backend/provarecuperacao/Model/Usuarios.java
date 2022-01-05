package backend.provarecuperacao.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;
    private String usuarioNome;
    private String rg;
    private String cpf;
    private String email;
    private String endereco_url;
    private String complemento;
    private String num;

    @JsonIgnore
    @OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
    private List<Emprestimos> emprestimos = new ArrayList<>();

    public Usuarios() {
    }

    public Usuarios(Long usuarioId, String usuarioNome, String rg, String cpf, String email, String endereco_url, String complemento, String num, List<Emprestimos> emprestimos) {
        this.usuarioId = usuarioId;
        this.usuarioNome = usuarioNome;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.endereco_url = endereco_url;
        this.complemento = complemento;
        this.num = num;
        this.emprestimos = emprestimos;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco_url() {
        return endereco_url;
    }

    public void setEndereco_url(String endereco_url) {
        this.endereco_url = endereco_url;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public List<Emprestimos> getEmprestimos() {
        return emprestimos;
    }
}
