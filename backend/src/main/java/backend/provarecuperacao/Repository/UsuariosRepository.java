package backend.provarecuperacao.Repository;

import backend.provarecuperacao.Model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
}
