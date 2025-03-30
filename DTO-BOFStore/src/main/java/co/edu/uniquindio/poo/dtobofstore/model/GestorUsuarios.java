package co.edu.uniquindio.poo.dtobofstore.model;

import java.util.LinkedList;

/**
 * Clase para gestionar usuarios en la plataforma.
 */
public class GestorUsuarios {

    private LinkedList<Usuario> listaUsuarios;

    public GestorUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = new LinkedList<>();
    }

    /**
     * Registra un nuevo usuario si el nombre no está en uso.
     */
    public Usuario registrarUsuario(String idUsuario, String nombre, String correo, LinkedList<Juego> biblioteca) {
        if (existeNombre(nombre)) {
            System.out.println("El nombre de usuario ya está en uso");
            return null;
        }
        Usuario usuario = new Usuario(idUsuario, nombre, correo, biblioteca);
        listaUsuarios.add(usuario);
        return usuario;
    }

    /**
     * Busca un usuario por nombre.
     */
    public Usuario buscarUsuario(String nombre) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Verifica si un nombre de usuario ya existe.
     */
    public boolean existeNombre(String nombre) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
}