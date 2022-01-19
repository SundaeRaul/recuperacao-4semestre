package backend.provarecuperacao.Services;

import backend.provarecuperacao.Model.Livros;
import backend.provarecuperacao.Repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

    @Autowired
    LivrosRepository lrep;

    public List<Livros> listarLivros() {
        return lrep.findAll();
    }

    public Livros ListaLivroById(Long livroId) {
        Optional<Livros> obj = lrep.findById(livroId);
        return obj.get();
    }

    public Livros CadastraLivro(Livros livro) {
        return lrep.save(livro);
    }

    public void DeletaLivro(Long livroId) {
        lrep.deleteById(livroId);
    }

    public Livros AlteraLivros(Long livroId, Livros obj) {
        Livros entity = lrep.findById(livroId).get();
        UpdateData(entity, obj);
        return lrep.save(entity);
    }

    private void UpdateData(Livros entity, Livros obj) {
        entity.setAutor(obj.getAutor());
        entity.setCategoria(obj.getCategoria());
        entity.setEditora(obj.getEditora());
        entity.setLivroNome(obj.getLivroNome());
    }
}
