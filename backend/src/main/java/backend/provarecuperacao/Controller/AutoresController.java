package backend.provarecuperacao.Controller;

import backend.provarecuperacao.Model.Autores;
import backend.provarecuperacao.Services.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/autores")
public class AutoresController {

    @Autowired
    AutoresService autoresService;

    @GetMapping
    public List<Autores> listaAutores() {
        return autoresService.listaAutores();
    }

    @GetMapping(value = "/{autorId}")
    public ResponseEntity<Autores> buscaAutorPorId(@PathVariable Long autorId) {
        Autores obj = autoresService.ListaAutorByid(autorId);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Autores> cadastrarAutor(@RequestBody Autores autor) {
        autor = autoresService.CadastraAutor(autor);
        return ResponseEntity.ok().body(autor);
    }

    @PutMapping(value = "/{autorId}")
    public ResponseEntity<Autores> alteraAutor(@RequestBody Autores autor, @PathVariable Long autorId) {
        autor = autoresService.AlteraAutores(autorId, autor);
        return ResponseEntity.ok().body(autor);
    }

    @DeleteMapping(value = "/{autorId}")
    public ResponseEntity<Void> deletaAutor(@PathVariable Long autorId){
        autoresService.DeletaAutor(autorId);
        return ResponseEntity.noContent().build();
    }
}
