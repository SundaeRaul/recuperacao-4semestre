package backend.provarecuperacao.Services;

import backend.provarecuperacao.Model.Exemplares;
import backend.provarecuperacao.Repository.ExemplaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExemplaresService {

    @Autowired
    ExemplaresRepository exemrep;

    public List<Exemplares> ListaExemplares() {
        return exemrep.findAll();
    }

    public Exemplares ListaExemplarById(Long exemplarId) {
        Optional<Exemplares> obj = exemrep.findById(exemplarId);
        return obj.get();
    }

    public Exemplares CadastraExemplar(Exemplares exemplares) {
        return exemrep.save(exemplares);
    }

    public void DeletaExemplar(Long exemplarId) {
        exemrep.deleteById(exemplarId);
    }

    public Exemplares AlteraExemplares(Long exemplarId, Exemplares obj) {
        Exemplares entity = exemrep.findById(exemplarId).get();
        UpdateData(entity, obj);
        return exemrep.save(entity);
    }

    private void UpdateData(Exemplares entity, Exemplares obj) {
        entity.setQuantidade(obj.getQuantidade());
    }
}
