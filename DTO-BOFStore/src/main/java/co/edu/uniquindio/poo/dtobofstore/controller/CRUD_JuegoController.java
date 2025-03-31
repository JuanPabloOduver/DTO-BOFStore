package co.edu.uniquindio.poo.dtobofstore.controller;
import java.util.Collection;

import co.edu.uniquindio.poo.dtobofstore.model.Juego;
import co.edu.uniquindio.poo.dtobofstore.model.Tienda;

// Clase controller del crud de juegos.
public class CRUD_JuegoController {
    private static CRUD_JuegoController instance;
    Tienda tienda;

    public CRUD_JuegoController(Tienda tienda) {
        this.tienda = tienda;
    }

    public boolean crearJuego(Juego juego) {
        return tienda.agregarJuego(juego);
    }

    public Collection<Juego> obtenerListaJuegos() {
        return tienda.getListaJuegos();
    }

    public boolean eliminarJuego(String idJuego) {
        return tienda.eliminarJuego(idJuego);
    }

    public boolean actualizarJuego(String idJuego, Juego juego) {
        return tienda.actualizarJuego(idJuego, juego);
    }

    //Metodo para generar una instancia de crud juegos.
    public static CRUD_JuegoController getInstance() {
        if (instance == null) {
            // instance = new UsuarioController();
        }
        return instance;
    }
}