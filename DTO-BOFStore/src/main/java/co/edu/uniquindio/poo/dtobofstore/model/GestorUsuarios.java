package co.edu.uniquindio.poo.dtobofstore.model;

import java.util.LinkedList;

public class GestorUsuarios {
    private LinkedList<Usuario> listaUsuarios;

    public GestorUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = new LinkedList<>();
    }

    public Usuario registrarUsuario(String idUsuario, String nombre, String correo, LinkedList<Juego> biblioteca){
        if (existeNombre(nombre)){
            System.out.println("El nombre de usuario ya se encuentra en uso");
            return null;
        }
        Usuario usuario = new Usuario(idUsuario, nombre, correo, biblioteca);
        listaUsuarios.add(usuario);
        return usuario;
    }

    public Usuario buscarUsuario(String nombre){
        for (Usuario usuario : listaUsuarios){
            if (usuario.getNombre().equals(nombre)){
                return usuario;
            }
        }
        return null;
    }

    public boolean existeNombre(String nombre){
        for (Usuario usuario : listaUsuarios){
            if (usuario.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }
}