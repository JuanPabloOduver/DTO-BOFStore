package co.edu.uniquindio.poo.dtobofstore.model;

import java.util.LinkedList;

public class Tienda {
    private static Tienda instancia;
    private String nombre;
    private LinkedList<Juego> listaJuegos;
    private LinkedList<Usuario> listaUsuarios;

    private Tienda (String nombre){
        this.nombre = nombre;
        this.listaJuegos = new LinkedList<>();
        this.listaUsuarios = new LinkedList<>();
    }

    public static Tienda getInstancia(String nombre){
        if (instancia == null){
            instancia = new Tienda(nombre);
        }
        return instancia;
    }

    public LinkedList<Juego> getListaJuegos(){
        return listaJuegos;
    }

    public LinkedList<Usuario> getListaUsuarios(){
        return listaUsuarios;
    }

    public void agregarJuego (Juego juego){
        listaJuegos.add(juego);
    }
    public void venderJuego(Usuario usuario, Juego juego){
        if (listaJuegos.contains(juego)){
            usuario.comprarJuego(juego);
        }
    }
}