package backend.provarecuperacao.util;

import backend.provarecuperacao.Model.Livros;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LivroCreator {


    public static List<Livros> criaListaDeLivros(){

        List<Livros> livrosToBeSaved = new ArrayList<>();

        Livros livro1 = new Livros(1L, "Test1", 4, CategoriaCreator.createCategoria(), AutorCreator.createAutor(), EditoraCreator.createEditore());
        Livros livro2 = new Livros(2L, "Test2", 6, CategoriaCreator.createCategoria(), AutorCreator.createAutor(), EditoraCreator.createEditore());

        livrosToBeSaved.add(livro1);
        livrosToBeSaved.add(livro2);

        return livrosToBeSaved;
    }

    public static Livros criaUnidadeLivro() {
        Livros livro = new Livros(1L, "Test1", 4, CategoriaCreator.createCategoria(), AutorCreator.createAutor(), EditoraCreator.createEditore());

        return livro;
    }
}
