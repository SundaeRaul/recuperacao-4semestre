package backend.provarecuperacao.Services;

import backend.provarecuperacao.Model.Usuarios;
import backend.provarecuperacao.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    UsuariosRepository urep;

    public List<Usuarios> listarUsuarios() {
        return urep.findAll();
    }

    public Usuarios ListUsuarioById(Long usuarioId) {
        Optional<Usuarios> obj = urep.findById(usuarioId);
        return obj.get();
    }

    public Usuarios CadastraUsuarios(Usuarios usuarios) {
        return urep.save(usuarios);
    }

    public void DeletaUsuario(Long usuarioId) {
        urep.deleteById(usuarioId);
    }

    public Usuarios AlteraUsuarios(Long usuarioId, Usuarios obj) {
        Usuarios entity = urep.findById(usuarioId).get();
        UpdateData(entity, obj);
        return urep.save(entity);
    }

    private void UpdateData(Usuarios entity, Usuarios obj){
        entity.setUsuarioNome(obj.getUsuarioNome());
        entity.setEmail(obj.getEmail());
        entity.setRg(obj.getRg());
        entity.setCpf(obj.getCpf());
        entity.setEndereco_url(obj.getEndereco_url());
        entity.setComplemento(obj.getComplemento());
        entity.setNum(obj.getNum());
    }
}
