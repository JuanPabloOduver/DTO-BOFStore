package co.edu.uniquindio.poo.dtobofstore.model;

import java.util.LinkedList;

/**
 * Clase carrito.
 */
public class Carrito {

    // Id Del Carrito.
    private String idCarrito;

    // Usuario del Carrito.
    private Usuario usuario;

    // Lista de Juegos.
    private LinkedList<Juego> listaJuegos;

    /**
     * Constructor de la clase Carrito.
     *
     * @param idCarrito
     * @param usuario
     * @param listaJuegos
     */
    public Carrito(String idCarrito, Usuario usuario, LinkedList<Juego> listaJuegos) {
        this.idCarrito = idCarrito;
        this.usuario = usuario;
        this.listaJuegos = new LinkedList<>(); // Se inicializa como una lista vacía
    }

    public String getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(String idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LinkedList<Juego> getListaJuegos() {
        return listaJuegos;
    }

    public void setListaJuegos(LinkedList<Juego> listaJuegos) {
        this.listaJuegos = listaJuegos;
    }

    // -------------------- Métodos CRUD del Carrito --------------------

    /**
     * Agrega un juego al carrito.
     *
     * @param juego
     */
    public void agregarJuego(Juego juego) {
        listaJuegos.add(juego);
    }

    /**
     * Elimina un juego del carrito.
     *
     * @param juego
     */
    public void eliminarJuego(Juego juego) {
        listaJuegos.remove(juego);
    }

    /**
     * Realiza la compra de todos los juegos en el carrito.
     */
    public void realizarCompra() {
        for (Juego juego : listaJuegos) {
            usuario.comprarJuego(juego);
        }
        listaJuegos.clear();
    }
}
