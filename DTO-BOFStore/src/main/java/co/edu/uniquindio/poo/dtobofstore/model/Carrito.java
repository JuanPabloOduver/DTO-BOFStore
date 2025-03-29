package co.edu.uniquindio.poo.dtobofstore.model;

import java.util.LinkedList;

public class Carrito {
    private String idCarrito;
    private Usuario usuario;
    private LinkedList<Juego> listaJuegos;

    public Carrito(String idCarrito, Usuario usuario, LinkedList<Juego> listaJuegos) {
        this.idCarrito = idCarrito;
        this.usuario = usuario;
        this.listaJuegos = new LinkedList<>();
    }

    public void agregarJuego(Juego juego){
        listaJuegos.add(juego);
    }

    public void eliminarJuego(Juego juego){
        listaJuegos.remove(juego);
    }

    public void realizarCompra(){
        for (Juego juego : listaJuegos){
            usuario.comprarJuego(juego);
        }
        listaJuegos.clear();
    }
}