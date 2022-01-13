package backend.provarecuperacao.Repository;

import backend.provarecuperacao.Model.Emprestimos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimosRepository extends JpaRepository<Emprestimos, Long> {
}
