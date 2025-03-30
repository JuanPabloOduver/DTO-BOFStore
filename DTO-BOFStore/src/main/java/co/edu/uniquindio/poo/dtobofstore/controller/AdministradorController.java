package co.edu.uniquindio.poo.dtobofstore.controller;
import java.util.Collection;

import co.edu.uniquindio.poo.dtobofstore.model.Juego;
import co.edu.uniquindio.poo.dtobofstore.model.Tienda;

public class AdministradorController {
    private static AdministradorController instance;
    Tienda tienda;

    public AdministradorController(Tienda tienda) {
        this.tienda = tienda;
    }

    public Collection<Juego> obtenerListaJuegos() {
        return tienda.getListaJuegos();
    }

    public static AdministradorController getInstance() {
        if (instance == null) {
            // instance = new AdministradorController();
        }
        return instance;
    }
}
