package backend.provarecuperacao.util;

import backend.provarecuperacao.Model.Usuarios;

public class UsuarioCreator {

    public static Usuarios criaUsuario() {
        Usuarios usuario = new Usuarios(1L, "Usuario1", "11111111", "1111111111", "email1", "exemplourl1", "exemploComplemento", "123");

        return usuario;
    }
}
