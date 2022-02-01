package backend.provarecuperacao.util;

import backend.provarecuperacao.Model.Categorias;

public class CategoriaCreator {

    public static Categorias createCategoria() {
        Categorias categoria = new Categorias(1L, "CAtegoriaTest", 2);

        return categoria;
    }
}
