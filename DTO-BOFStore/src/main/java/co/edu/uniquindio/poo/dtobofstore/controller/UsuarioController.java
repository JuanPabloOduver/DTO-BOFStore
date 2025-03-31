package co.edu.uniquindio.poo.dtobofstore.controller;

import co.edu.uniquindio.poo.dtobofstore.model.Juego;
import co.edu.uniquindio.poo.dtobofstore.model.Usuario;
import co.edu.uniquindio.poo.dtobofstore.model.Tienda;

import java.util.LinkedList;
import java.util.List;

public class UsuarioController {
    private final Tienda tienda;
    private final Usuario usuario;

    // Constructor que recibe usuario y tienda
    public UsuarioController(Usuario usuario, Tienda tienda) {
        this.usuario = usuario;
        this.tienda = tienda;
    }

    public List<Juego> obtenerBiblioteca() {
        return usuario != null ? usuario.getBiblioteca() : new LinkedList<>();
    }

    public void comprarJuego(Juego juego) {
        if (usuario != null && tienda != null) {
            usuario.agregarJuegoABiblioteca(juego);
        }
    }
}
