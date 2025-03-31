package co.edu.uniquindio.poo.dtobofstore.controller;
import java.util.Collection;

import co.edu.uniquindio.poo.dtobofstore.model.Juego;
import co.edu.uniquindio.poo.dtobofstore.model.Tienda;

public class AdministradorController {
    private static AdministradorController instance;
    Tienda tienda;

    //Clase Controller de Administrador
    public AdministradorController(Tienda tienda) {
        this.tienda = tienda;
    }

    public Collection<Juego> obtenerListaJuegos() {
        return tienda.getListaJuegos();
    }

    //Metodo para generar una instancia del controller
    public static AdministradorController getInstance() {
        if (instance == null) {
            // instance = new AdministradorController();
        }
        return instance;
    }
}
