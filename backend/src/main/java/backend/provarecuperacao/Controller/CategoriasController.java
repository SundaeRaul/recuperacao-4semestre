package backend.provarecuperacao.Controller;

import backend.provarecuperacao.Model.Categorias;
import backend.provarecuperacao.Services.CategoriasService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    CategoriasService categoriasService;

    @GetMapping
    public List<Categorias> listaCategoias() {
        return categoriasService.listaCategorias();
    }

    @GetMapping(value = "/{categoriasId}")
    public ResponseEntity<Categorias> buscaCategoriaPorId(@PathVariable Long categoriasId) {
        Categorias obj = categoriasService.ListaCategoriaByid(categoriasId);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Categorias> cadastraCategorias(@RequestBody Categorias categorias) {
        categorias = categoriasService.CadastraCategoria(categorias);
        return ResponseEntity.ok().body(categorias);
    }

    @PutMapping(value = "/{categoriasId}")
    public ResponseEntity<Categorias> alteraCategorias(@RequestBody Categorias categorias, @PathVariable Long categoriasId) {
        categorias = categoriasService.AlteraCategorias(categoriasId, categorias);
        return ResponseEntity.ok().body(categorias);
    }

    @DeleteMapping(value = "/{categoriasId}")
    public ResponseEntity<Void> deletaCategorias(@PathVariable Long categoriasId) {
        categoriasService.DeletaCategoria(categoriasId);
        return ResponseEntity.noContent().build();
    }
}
