package backend.provarecuperacao.Repository;

import backend.provarecuperacao.Model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivrosRepository extends JpaRepository<Livros, Long> {
}
