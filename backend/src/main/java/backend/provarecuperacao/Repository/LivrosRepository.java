package backend.provarecuperacao.Repository;

import backend.provarecuperacao.Model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livros, Long> {
}
