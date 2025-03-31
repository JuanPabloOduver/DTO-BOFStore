package co.edu.uniquindio.poo.dtobofstore.controller;

import co.edu.uniquindio.poo.dtobofstore.model.Juego;
import co.edu.uniquindio.poo.dtobofstore.model.Tienda;
import co.edu.uniquindio.poo.dtobofstore.model.Usuario;
import java.util.LinkedList;

public class TiendaController {
    private static TiendaController instance;
    public Tienda tienda;
    private Usuario usuario;

    // Constructor recibe la tienda
    public TiendaController(Tienda tienda) {
        this.tienda = tienda;
    }

    public static TiendaController getInstance(Tienda tienda) {
        if (instance == null) {
            instance = new TiendaController(tienda);
        }
        return instance;
    }

    public LinkedList<Juego> obtenerBiblioteca() {
        return usuario != null ? usuario.getBiblioteca() : new LinkedList<>();
    }

    public void comprarJuego(Juego juego){
        if (usuario != null) {
            usuario.agregarJuegoABiblioteca(juego);
        } else {
            System.out.println("No hay un usuario activo.");
        }
    }
}
