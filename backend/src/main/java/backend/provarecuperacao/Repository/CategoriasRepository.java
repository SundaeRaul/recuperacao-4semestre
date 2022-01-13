package backend.provarecuperacao.Repository;

import backend.provarecuperacao.Model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
}
