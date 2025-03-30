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

    public LinkedList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }


// Usuarios
    public boolean agregarUsuario(Usuario usuario) {
        boolean centinela = false;
        if (!verificarUsuario(usuario.getId())) {
            listaUsuarios.add(usuario);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarUsuario(String id) {
        boolean centinela = false;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId().equals(id)) {
                listaUsuarios.remove(usuario);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarUsuario(String id, Usuario actualizado) {
        boolean centinela = false;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId().equals(id)) {
                usuario.setId(actualizado.getId());
                usuario.setNombre(actualizado.getNombre());
                usuario.setCorreo(actualizado.getCorreo());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarUsuario(String id) {
        boolean centinela = false;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId().equals(id)) {
                centinela = true;
            }
        }
        return centinela;
    }
}