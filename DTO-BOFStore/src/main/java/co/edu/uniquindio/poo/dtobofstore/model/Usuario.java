package co.edu.uniquindio.poo.dtobofstore.model;

import java.util.LinkedList;

/**
 * Clase que representa a un usuario en la tienda de videojuegos.
 */
public class Usuario extends Persona {

    private LinkedList<Juego> biblioteca;

    /**
     * Constructor que inicializa un usuario con sus datos y su biblioteca de juegos.
     */
    public Usuario(String id, String nombre, String correo, LinkedList<Juego> biblioteca) {
        super(id, nombre, correo);
        this.biblioteca = biblioteca;
    }

    /**
     * Método para comprar un juego y agregarlo a la biblioteca del usuario.
     */
    public void comprarJuego(Juego juego) {
        biblioteca.add(juego);
    }

    // Métodos getter y setter para acceder y modificar la biblioteca

    public LinkedList<Juego> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(LinkedList<Juego> biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + getId() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", biblioteca=" + biblioteca +
                '}';
    }
}
