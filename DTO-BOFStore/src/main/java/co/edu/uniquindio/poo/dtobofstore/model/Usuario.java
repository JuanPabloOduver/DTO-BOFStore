package co.edu.uniquindio.poo.dtobofstore.model;

import java.util.LinkedList;

/**
 * Clase que representa a un usuario en la tienda de videojuegos.
 */
public class Usuario {
    private String idUsuario;        // Id Usuario
    private String nombre;           // Nombre del usuario
    private String correo;           // Correo electrónico del usuario
    private LinkedList<Juego> biblioteca; // Lista de juegos comprados por el usuario

    /**
     * Constructor que inicializa un usuario con sus datos y su biblioteca de juegos.
     */
    public Usuario(String idUsuario, String nombre, String correo, LinkedList<Juego> biblioteca) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.biblioteca = biblioteca;
    }

    /**
     * Método para comprar un juego y agregarlo a la biblioteca del usuario.
     */
    public void comprarJuego(Juego juego) {
        biblioteca.add(juego);
    }

    // Métodos getter y setter para acceder y modificar los atributos

    public LinkedList<Juego> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(LinkedList<Juego> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Método toString para representar un usuario en formato de texto.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario='" + idUsuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", biblioteca=" + biblioteca +
                '}';
    }
}