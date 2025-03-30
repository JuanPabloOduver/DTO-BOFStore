package co.edu.uniquindio.poo.dtobofstore.model;

import java.util.LinkedList;

public class Usuario extends Persona{

    private LinkedList<Juego> biblioteca;

    public Usuario(String id, String nombre, String correo, LinkedList<Juego> biblioteca) {
        super(id, nombre, correo);
        this.biblioteca = biblioteca;
    }

    public void comprarJuego(Juego juego){
        biblioteca.add(juego);
    }

    public LinkedList<Juego> getBiblioteca(){
        return biblioteca;
    }
    public void setBiblioteca(LinkedList<Juego> biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "biblioteca=" + biblioteca +
                '}';
    }
}