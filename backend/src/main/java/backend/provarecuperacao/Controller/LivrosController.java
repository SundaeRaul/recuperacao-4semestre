package backend.provarecuperacao.Controller;

import backend.provarecuperacao.Model.Livros;
import backend.provarecuperacao.Services.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    LivrosService livrosService;

    @GetMapping
    public List<Livros> listaLivros() {
        return livrosService.listarLivros();
    }

    @GetMapping(value = "/{livroId}")
    public ResponseEntity<Livros> buscaLivroById(@PathVariable Long livroId) {
        Livros obj = livrosService.ListaLivroById(livroId);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Livros> cadastraLivro(@RequestBody Livros livro) {
        livro = livrosService.CadastraLivro(livro);
        return ResponseEntity.ok().body(livro);
    }

    @PutMapping(value = "/{livroId}")
    public ResponseEntity<Livros> alteraLivro(@RequestBody Livros livro, @PathVariable Long livroId){
        livro = livrosService.AlteraLivros(livroId, livro);
        return ResponseEntity.ok().body(livro);
    }

    @DeleteMapping(value = "/{livroId}")
    public ResponseEntity<Void> deletaLivro(@PathVariable Long livroId){
        livrosService.DeletaLivro(livroId);
        return ResponseEntity.noContent().build();
    }
}
