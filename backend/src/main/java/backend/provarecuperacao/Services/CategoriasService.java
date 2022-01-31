package backend.provarecuperacao.Services;

import backend.provarecuperacao.Model.Categorias;
import backend.provarecuperacao.Repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {

    @Autowired
    CategoriasRepository crep;

    public List<Categorias> listaCategorias() {
        return crep.findAll();
    }

    public Categorias ListaCategoriaByid(Long categoriaId) {
        Optional<Categorias> obj = crep.findById(categoriaId);
        return obj.get();
    }

    public Categorias CadastraCategoria(Categorias categorias) {
        return crep.save(categorias);
    }

    public void DeletaCategoria(Long categoriaId) {
        crep.deleteById(categoriaId);
    }

    public Categorias AlteraCategorias(Long categoriaId, Categorias obj) {
        Categorias entity = crep.findById(categoriaId).get();
        UpdateData(entity, obj);
        return crep.save(entity);
    }

    private void UpdateData(Categorias entity, Categorias obj) {
        entity.setCategoriaNome(obj.getCategoriaNome());
        entity.setLimiteEmprestimo(obj.getLimiteEmprestimo());

    }
}
