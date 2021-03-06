package backend.provarecuperacao.Services;

import backend.provarecuperacao.Model.Emprestimos;
import backend.provarecuperacao.Model.Livros;
import backend.provarecuperacao.Repository.EmprestimosRepository;
import backend.provarecuperacao.Repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimosRepository emprep;

    @Autowired
    LivrosService livrosService;

    @Autowired
    LivrosRepository livrosRepository;

    public List<Emprestimos> listaEmprestims() {
        return emprep.findAll();
    }

    public Emprestimos ListaEmprestimoByid(Long emprestimoId) {
        Optional<Emprestimos> obj = emprep.findById(emprestimoId);
        return obj.get();
    }

    public Emprestimos CadastraEmprestimo(Emprestimos emprestimos) {
        Livros livro = livrosRepository.getById(emprestimos.getLivro().getLivroId());
        if(livro.getExemplares() <= 0){
            throw new RuntimeException("Este livro não está disponível");
        }
        diminuiQtt(emprestimos.getLivro().getLivroId());
        Livros livroemprestimo = livrosRepository.getById(emprestimos.getLivro().getLivroId());
        emprestimos.setData(LocalDate.now());
        emprestimos.setDataLimite(LocalDate.now().plusDays(livroemprestimo.getCategoria().getLimiteEmprestimo()));
        return emprep.save(emprestimos);
    }

    public void DeletaEmprestimo(Long emprestimoId) {
        Emprestimos emprestimo = emprep.getById(emprestimoId);
        aumentaQtt(emprestimo.getLivro().getLivroId());
        emprep.deleteById(emprestimoId);
    }

    public Livros diminuiQtt(Long livroId) {
      Livros livro = livrosRepository.getById(livroId);
      livro.setExemplares(livrosService.diminuiQtdLivro(livro));
      livrosRepository.save(livro);
      return livro;
    }

    public Livros aumentaQtt(Long livroId) {
        Livros livro = livrosRepository.getById(livroId);
        livro.setExemplares(livrosService.aumentaQttLivro(livro));
        livrosRepository.save(livro);
        return livro;
    }

}
