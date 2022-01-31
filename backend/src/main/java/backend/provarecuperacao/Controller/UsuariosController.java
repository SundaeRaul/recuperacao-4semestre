package backend.provarecuperacao.Controller;

import backend.provarecuperacao.Model.Usuarios;
import backend.provarecuperacao.Services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;

    @GetMapping
    public List<Usuarios> listaUsuarios() {
        return usuariosService.listarUsuarios();
    }

    @GetMapping(value = "/{usuarioId}")
    public ResponseEntity<Usuarios> listaUsuarioById(@PathVariable Long usuarioId) {
        Usuarios obj = usuariosService.ListUsuarioById(usuarioId);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Usuarios> cadastraUsuario (@RequestBody Usuarios usuario){
        usuario = usuariosService.CadastraUsuarios(usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @PutMapping(value = "/{usuarioId}")
    public ResponseEntity<Usuarios> alteraUsuarios(@PathVariable Long usuarioId, @RequestBody Usuarios usuario){
        usuario = usuariosService.AlteraUsuarios(usuarioId, usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping(value = "/{usuarioId}")
    public ResponseEntity<Void> deletaUsuario(@PathVariable Long usuarioId) {
        usuariosService.DeletaUsuario(usuarioId);
        return ResponseEntity.noContent().build();
    }
}
