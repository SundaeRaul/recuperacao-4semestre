package backend.provarecuperacao.util;

import backend.provarecuperacao.Model.Autores;

public class AutorCreator {

    public static Autores createAutor() {
        Autores autor = new Autores(1L, "AutorTeste");

        return autor;
    }
}
