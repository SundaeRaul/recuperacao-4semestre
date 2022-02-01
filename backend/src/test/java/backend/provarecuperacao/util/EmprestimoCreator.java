package backend.provarecuperacao.util;

import backend.provarecuperacao.Model.Emprestimos;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmprestimoCreator {

    public static Emprestimos criaUnidadeEmprestimo() {
        Emprestimos emprestimo = new Emprestimos(1L, LocalDate.now(), LocalDate.now().plusDays(LivroCreator.criaUnidadeLivro().getCategoria().getLimiteEmprestimo()), LivroCreator.criaUnidadeLivro(), UsuarioCreator.criaUsuario());

        return emprestimo;
    }
}
