package backend.provarecuperacao.Services;

import backend.provarecuperacao.Model.Editoras;
import backend.provarecuperacao.Repository.EditorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorasService {

    @Autowired
    EditorasRepository editorarep;

    public List<Editoras> ListaEditoras() {
        return editorarep.findAll();
    }

    public Editoras ListaEditoraById(Long editoraId) {
        Optional<Editoras> obj = editorarep.findById(editoraId);
        return obj.get();
    }

    public Editoras CadastraEditora(Editoras editoras) {
        return editorarep.save(editoras);
    }

    public void DeletaEditora(Long editoraId) {
        editorarep.deleteById(editoraId);
    }

    public Editoras AlteraEditoras(Long editoraId, Editoras obj) {
        Editoras entity = editorarep.findById(editoraId).get();
        UpdateData(entity, obj);
        return editorarep.save(entity);
    }

    private void UpdateData(Editoras entity, Editoras obj) {
        entity.setEditoraNome(obj.getEditoraNome());
    }
}
