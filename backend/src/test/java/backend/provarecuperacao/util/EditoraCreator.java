package backend.provarecuperacao.util;

import backend.provarecuperacao.Model.Editoras;

public class EditoraCreator {

    public static Editoras createEditore() {
        Editoras editora = new Editoras(1L, "EditoraTest");

        return editora;
    }
}
