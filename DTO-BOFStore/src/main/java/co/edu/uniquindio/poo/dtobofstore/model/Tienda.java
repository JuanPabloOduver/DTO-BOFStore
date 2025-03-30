package co.edu.uniquindio.poo.dtobofstore.model;

import java.util.LinkedList;

public class Tienda {
    private static Tienda instancia;
    private String nombre;
    private LinkedList<Juego> listaJuegos;
    private LinkedList<Usuario> listaUsuarios;
    private LinkedList<Administrador> listaAdministradores;

    public Tienda (String nombre){
        this.nombre = nombre;
        this.listaJuegos = new LinkedList<>();
        this.listaUsuarios = new LinkedList<>();
        this.listaAdministradores = new LinkedList<>();
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
    public void agregarUsuario (Usuario usuario){
        listaUsuarios.add(usuario);
    }

    public void agregarAdministrador (Administrador administrador){
        listaAdministradores.add(administrador);
    }
    public void venderJuego(Usuario usuario, Juego juego){
        if (listaJuegos.contains(juego)){
            usuario.comprarJuego(juego);
        }
    }

    public static Tienda getInstancia() {
        return instancia;
    }

    public static void setInstancia(Tienda instancia) {
        Tienda.instancia = instancia;
    }

    public String getNombre() {
        return nombre;
    }

    public Tienda setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Tienda setListaJuegos(LinkedList<Juego> listaJuegos) {
        this.listaJuegos = listaJuegos;
        return this;
    }

    public Tienda setListaUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
        return this;
    }

    public Tienda setListaAdministradores(LinkedList<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
        return this;
    }
}