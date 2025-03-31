package co.edu.uniquindio.poo.dtobofstore.controller;
import java.util.Collection;

import co.edu.uniquindio.poo.dtobofstore.model.Usuario;
import co.edu.uniquindio.poo.dtobofstore.model.Tienda;

// Clase Controller del crud del usuario.
public class CRUD_UsuarioController {
    private static CRUD_UsuarioController instance;
    Tienda tienda;

    public CRUD_UsuarioController(Tienda tienda) {
        this.tienda = tienda;
    }

    public boolean crearUsuario(Usuario usuario) {
        return tienda.agregarUsuario(usuario);
    }

    public Collection<Usuario> obtenerListaUsuarios() {
        return tienda.getListaUsuarios();
    }

    public boolean eliminarUsuario(String id) {
        return tienda.eliminarUsuario(id);
    }

    public boolean actualizarUsuario(String id, Usuario usuario) {
        return tienda.actualizarUsuario(id, usuario);
    }

    // Metodo para generar una instancia de usuario controller.
    public static CRUD_UsuarioController getInstance() {
        if (instance == null) {
            // instance = new UsuarioController();
        }
        return instance;
    }
}