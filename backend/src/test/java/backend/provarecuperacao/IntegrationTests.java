package backend.provarecuperacao;

import backend.provarecuperacao.Model.*;
import backend.provarecuperacao.Repository.*;
import backend.provarecuperacao.util.*;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log4j2
class IntegrationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

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


    @BeforeEach
    void setup() {
        livrosRepository.saveAll(LivroCreator.criaListaDeLivros());
        livrosRepository.save(LivroCreator.criaUnidadeLivro());

        autoresRepository.save(AutorCreator.createAutor());

        editorasRepository.save(EditoraCreator.createEditore());

        categoriasRepository.save(CategoriaCreator.createCategoria());

        usuariosRepository.save(UsuarioCreator.criaUsuario());

        emprestimosRepository.save(EmprestimoCreator.criaUnidadeEmprestimo());
    }

    //LIVROS

    @Test
    void RetornaListaLivros_DeveRetornarSucesso() {

        ResponseEntity<Livros[]> resp =
                this.testRestTemplate.getForEntity("http://localhost:" + port + "/livros", Livros[].class);

        Livros[] livros = resp.getBody();

        System.out.print("Teste " + livros);

        assertAll(() -> assertNotNull(livros), () -> assertEquals(2, livros.length));
    }

    //EMPRESTIMOS

    @Test
    void DataDeDevolucao_DeveSerMaiorQueDataDeEmprestimo_DeveRetornarSucesso() {
        ResponseEntity<Emprestimos> resp =
                this.testRestTemplate.getForEntity("http://localhost:" + port + "/emprestimos/1", Emprestimos.class);

        Emprestimos emprestimoResp = resp.getBody();

        System.out.print("Teste " + emprestimoResp);

        Assertions.assertThat(emprestimoResp).isNotNull();
        Assertions.assertThat(emprestimoResp.getDataLimite()).isEqualTo(LocalDate.now().plusDays(2));

    }

    //CATEGORIAS

    @Test
    void BuscaCategoria_DeveRetornarSucesso() {
        ResponseEntity<Categorias> resp =
                this.testRestTemplate.getForEntity("http://localhost:" + port + "/categorias/1", Categorias.class);

        Categorias categoriaResp = resp.getBody();

        System.out.print("Teste: " + categoriaResp);

        Assertions.assertThat(categoriaResp).isNotNull();
    }

    //AUTORES

    @Test
    void DeletaAutor_DeveRetornarSucesso() {
        Long id = 1L;
        this.testRestTemplate.delete("http://localhost:" + port + "/autores/", id);
    }

    //USUARIOS

    @Test
    void CriaUsuario_DeveRetornarSucesso() {

        Usuarios usuario1 = new Usuarios(null, "Usuario1", "11111111", "1111111111", "email1", "exemplourl1", "exemploComplemento", "123");

        ResponseEntity<Usuarios> resp =
                this.testRestTemplate.postForEntity("http://localhost:" + port + "/autores/", usuario1, Usuarios.class);

        Assertions.assertThat(resp.getBody()).isNotNull();
        Assertions.assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    //EDITORAS

    @Test
    void AlteraEditora_DeveRetornarSucesso() {
        Optional<Editoras> editoraAntiga = editorasRepository.findById(1L);

        Editoras editoraNova = new Editoras(1L, "EditoraTest222");

        this.testRestTemplate.put("http://localhost:" + port + "/editoras/" + 1L, editoraNova);

        Assertions.assertThat(editoraAntiga.get().getEditoraNome()).isNotEqualTo(editoraNova.getEditoraNome());
    }
}
