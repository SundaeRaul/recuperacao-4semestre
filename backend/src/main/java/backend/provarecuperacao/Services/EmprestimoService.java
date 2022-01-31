package backend.provarecuperacao.Services;

import backend.provarecuperacao.Model.Emprestimos;
import backend.provarecuperacao.Model.Livros;
import backend.provarecuperacao.Repository.EmprestimosRepository;
import backend.provarecuperacao.Repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        diminuiQtt(emprestimos.getLivro().getLivroId());
        return emprep.save(emprestimos);
    }

    public Livros diminuiQtt(Long livroId) {
      Livros livro = livrosRepository.getById(livroId);
      livro.setExemplares(livrosService.diminuiQtdLivro(livro));
      livrosRepository.save(livro);
      return livro;
    }

    public void DeletaEmprestimo(Long emprestimoId) {
        emprep.deleteById(emprestimoId);
    }

}
