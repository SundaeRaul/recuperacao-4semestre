package backend.provarecuperacao.Controller;

import backend.provarecuperacao.Model.Emprestimos;
import backend.provarecuperacao.Model.Livros;
import backend.provarecuperacao.Services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimos> listaEmprestimos() {
        return emprestimoService.listaEmprestims();
    }

    @GetMapping(value = "/{emprestimoId}")
    public ResponseEntity<Emprestimos> BuscaEmprestimoById(@PathVariable Long emprestimoId) {
        Emprestimos obj = emprestimoService.ListaEmprestimoByid(emprestimoId);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Emprestimos> cadastraEmprestimo(@RequestBody Emprestimos emprestimo) {
        emprestimo = emprestimoService.CadastraEmprestimo(emprestimo);
        return ResponseEntity.ok().body(emprestimo);
    }

    @DeleteMapping(value = "/{emprestimoId}")
    public ResponseEntity<Void> deletaEmprestimo(@PathVariable Long emprestimoId) {
        emprestimoService.DeletaEmprestimo(emprestimoId);
        return ResponseEntity.noContent().build();
    }
}
