package backend.provarecuperacao.Services;

import backend.provarecuperacao.Model.Autores;
import backend.provarecuperacao.Repository.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoresService {

    @Autowired
    AutoresRepository autoresrep;

    public List<Autores> listaAutores() {
        return autoresrep.findAll();
    }

    public Autores ListaAutorByid(Long autorId) {
        Optional<Autores> obj = autoresrep.findById(autorId);
        return obj.get();
    }

    public Autores CadastraAutor(Autores autores){
        return autoresrep.save(autores);
    }

    public void DeletaAutor(Long autorId) {
        autoresrep.deleteById(autorId);
    }

    public Autores AlteraAutores(Long autorId, Autores obj) {
        Autores entity = autoresrep.findById(autorId).get();
        UpdateData(entity, obj);
        return autoresrep.save(entity);
    }

    private void UpdateData(Autores entity, Autores obj) {
        entity.setAutorNome(obj.getAutorNome());
    }
}
