package backend.provarecuperacao.Services;

import backend.provarecuperacao.Model.Emprestimos;
import backend.provarecuperacao.Repository.EmprestimosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimosRepository emprep;

    public List<Emprestimos> listaEmprestims() {
        return emprep.findAll();
    }

    public Emprestimos ListaEmprestimoByid(Long emprestimoId) {
        Optional<Emprestimos> obj = emprep.findById(emprestimoId);
        return obj.get();
    }

    public Emprestimos CadastraEmprestimo(Emprestimos emprestimos) {
        return emprep.save(emprestimos);
    }

    public void DeletaEmprestimo(Long emprestimoId) {
        emprep.deleteById(emprestimoId);
    }

    public Emprestimos AlteraEmprestimos(Long emprestimoId, Emprestimos obj) {
        Emprestimos entity = emprep.findById(emprestimoId).get();
        UpdateData(entity, obj);
        return emprep.save(entity);
    }

    private void UpdateData(Emprestimos entity, Emprestimos obj) {
        entity.setData(obj.getData());
    }
}
