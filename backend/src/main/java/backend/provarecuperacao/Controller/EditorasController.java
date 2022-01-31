package backend.provarecuperacao.Controller;

import backend.provarecuperacao.Model.Editoras;
import backend.provarecuperacao.Services.EditorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/editoras")
public class EditorasController {

    @Autowired
    EditorasService editorasService;

    @GetMapping
    public List<Editoras> listaEditoras() {
        return editorasService.ListaEditoras();
    }

    @GetMapping(value = "/{editorasId}")
    public ResponseEntity<Editoras> listaEditorasById(@PathVariable Long editoraId) {
        Editoras obj = editorasService.ListaEditoraById(editoraId);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Editoras> cadastraEditora(@RequestBody Editoras editoras) {
        editoras = editorasService.CadastraEditora(editoras);
        return ResponseEntity.ok().body(editoras);
    }

    @PutMapping(value = "/{editorasId}")
    public ResponseEntity<Editoras> alteraEditoras(@PathVariable Long editorasId, @RequestBody Editoras editoras) {
        editoras = editorasService.AlteraEditoras(editorasId, editoras);
        return ResponseEntity.ok().body(editoras);
    }

    @DeleteMapping(value = "/{editorasId}")
    public ResponseEntity<Void> deletaEditoras(@PathVariable Long editorasId) {
        editorasService.DeletaEditora(editorasId);
        return ResponseEntity.noContent().build();
    }
}
