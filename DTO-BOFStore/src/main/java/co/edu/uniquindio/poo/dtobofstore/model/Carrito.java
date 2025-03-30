package co.edu.uniquindio.poo.dtobofstore.model;

import java.util.LinkedList;

/**
 * Clase carrito.
 */
public class Carrito {

    // Id Del Carrito.
    private String idCarrito;

    // Usuario al que pertenece el carrito
    private Usuario usuario;

    // Lista de juegos añadidos al carrito antes de realizar la compra
    private LinkedList<Juego> listaJuegos;

    /**
     * Constructor de la clase Carrito.
     *
     * @param idCarrito  Identificador único del carrito.
     * @param usuario    Usuario propietario del carrito.
     * @param listaJuegos Lista inicial de juegos en el carrito (por defecto, será una lista vacía).
     */
    public Carrito(String idCarrito, Usuario usuario, LinkedList<Juego> listaJuegos) {
        this.idCarrito = idCarrito;
        this.usuario = usuario;
        this.listaJuegos = new LinkedList<>(); // Se inicializa como una lista vacía
    }

    // -------------------- Métodos CRUD del Carrito --------------------

    /**
     * Agrega un juego al carrito.
     *
     * @param juego Juego que se desea añadir.
     */
    public void agregarJuego(Juego juego) {
        listaJuegos.add(juego);
    }

    /**
     * Elimina un juego del carrito si está presente en la lista.
     *
     * @param juego Juego que se desea eliminar.
     */
    public void eliminarJuego(Juego juego) {
        listaJuegos.remove(juego);
    }

    /**
     * Realiza la compra de todos los juegos en el carrito.
     * - Agrega cada juego a la biblioteca del usuario.
     * - Limpia el carrito después de la compra.
     */
    public void realizarCompra() {
        for (Juego juego : listaJuegos) {
            usuario.comprarJuego(juego); // Se transfiere el juego a la biblioteca del usuario
        }
        listaJuegos.clear(); // Se vacía el carrito después de la compra
    }
}
