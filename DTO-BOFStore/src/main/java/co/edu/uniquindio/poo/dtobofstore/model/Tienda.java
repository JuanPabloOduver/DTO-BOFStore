package co.edu.uniquindio.poo.dtobofstore.model;

import java.util.LinkedList;

/**
 * Clase Singleton que representa la tienda de videojuegos.
 */
public class Tienda {
    private static Tienda instancia;  // Única instancia de la tienda
    private String nombre;            // Nombre de la tienda
    private LinkedList<Juego> listaJuegos;   // Lista de juegos disponibles
    private LinkedList<Usuario> listaUsuarios; // Lista de usuarios registrados

    /**
     * Constructor privado para garantizar que solo haya una instancia.
     */
    private Tienda(String nombre) {
        this.nombre = nombre;
        this.listaJuegos = new LinkedList<>();
        this.listaUsuarios = new LinkedList<>();
    }

    /**
     * Método para obtener la única instancia de la tienda.
     */
    public static Tienda getInstancia(String nombre) {
        if (instancia == null) {
            instancia = new Tienda(nombre);
        }
        return instancia;
    }

    // Getters para obtener las listas de juegos y usuarios

    public LinkedList<Juego> getListaJuegos() {
        return listaJuegos;
    }

    public LinkedList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * Agrega un juego a la lista de juegos de la tienda.
     */
    public void agregarJuego(Juego juego) {
        listaJuegos.add(juego);
    }

    /**
     * Vende un juego a un usuario si está disponible en la tienda.
     */
    public void venderJuego(Usuario usuario, Juego juego) {
        if (listaJuegos.contains(juego)) {
            usuario.comprarJuego(juego);
        }
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", listaJuegos=" + listaJuegos +
                ", listaUsuarios=" + listaUsuarios +
                '}';
    }
}