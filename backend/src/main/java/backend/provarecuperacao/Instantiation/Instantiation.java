package backend.provarecuperacao.Instantiation;

import backend.provarecuperacao.Model.*;
import backend.provarecuperacao.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    AutoresRepository autoresRepository;

    @Autowired
    CategoriasRepository categoriasRepository;

    @Autowired
    EditorasRepository editorasRepository;

    @Autowired
    EmprestimosRepository emprestimosRepository;


    @Autowired
    LivrosRepository livrosRepository;

    @Autowired
    UsuariosRepository usuariosRepository;

    @Override
    public void run (String... args) throws Exception {


        Autores autor1 = new Autores(null, "Alan Moore");
        Autores autor2 = new Autores(null, "Machado de Assis");
        autoresRepository.saveAll(Arrays.asList(autor1, autor2));

        Categorias categoria1 = new Categorias(null, "Historias em quadrinhos", 5);
        Categorias categoria2 = new Categorias(null, "Literatura Clássica Brasileira", 3);
        categoriasRepository.saveAll(Arrays.asList(categoria1, categoria2));

        Editoras editora1 = new Editoras(null, "Panini Books");
        Editoras editora2 = new Editoras(null, "Egéia Literatura");
        editorasRepository.saveAll(Arrays.asList(editora1, editora2));

        Livros livro1 = new Livros(null, "Batman: Piada Mortal", 4, categoria1, autor1, editora1);
        Livros livro2 = new Livros(null, "Dom Casmurro", 6, categoria2, autor2, editora2);
        livrosRepository.saveAll(Arrays.asList(livro1, livro2));

        Usuarios usuario1 = new Usuarios(null, "Raul Rios", "11111111", "1111111111", "raul@email.com", "exemplourl1", "exemploComplemento", "123");
        Usuarios usuario2 = new Usuarios(null, "Luisa Ghellere", "222222222", "22222222", "luisa@email.com", "exemploUrl2", "exemploComplemento2", "444");
        usuariosRepository.saveAll(Arrays.asList(usuario1, usuario2));

        Emprestimos emprestimo1 = new Emprestimos(null, LocalDate.now(), LocalDate.now().plusDays(livro1.getCategoria().getLimiteEmprestimo()), livro1, usuario2);
        emprestimosRepository.saveAll(Arrays.asList(emprestimo1));
    }

}
