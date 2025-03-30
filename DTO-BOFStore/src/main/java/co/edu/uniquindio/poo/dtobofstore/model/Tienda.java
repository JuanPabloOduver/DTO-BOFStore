package co.edu.uniquindio.poo.dtobofstore.model;

import java.util.LinkedList;

/**
 * Clase Singleton que representa la tienda de videojuegos.
 */
public class Tienda {
    private static Tienda instancia;
    private String nombre;
    private LinkedList<Juego> listaJuegos;
    private LinkedList<Usuario> listaUsuarios;
    private LinkedList<Administrador> listaAdministradores;

    /**
     * Constructor privado para garantizar que solo haya una instancia.
     */
    private Tienda(String nombre) {
        this.nombre = nombre;
        this.listaJuegos = new LinkedList<>();
        this.listaUsuarios = new LinkedList<>();
        this.listaAdministradores = new LinkedList<>();
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

    public static Tienda getInstancia() {
        return instancia;
    }

    public static void setInstancia(Tienda instancia) {
        Tienda.instancia = instancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Juego> getListaJuegos() {
        return listaJuegos;
    }

    public void setListaJuegos(LinkedList<Juego> listaJuegos) {
        this.listaJuegos = listaJuegos;
    }

    public LinkedList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public LinkedList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(LinkedList<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    /**
     * Agrega un juego a la lista de juegos de la tienda.
     */
    public void agregarJuego(Juego juego) {
        listaJuegos.add(juego);
    }

    /**
     * Agrega un administrador a la lista.
     */
    public void agregarAdministrador(Administrador administrador) {
        listaAdministradores.add(administrador);
    }

    /**
     * Vende un juego a un usuario si está disponible en la tienda.
     */
    public void venderJuego(Usuario usuario, Juego juego) {
        if (listaJuegos.contains(juego)) {
            usuario.comprarJuego(juego);
        }
    }

    /**
     * Agrega un usuario a la tienda si no existe.
     */
    public boolean agregarUsuario(Usuario usuario) {
        if (!verificarUsuario(usuario.getIdUsuario())) {
            listaUsuarios.add(usuario);
            return true;
        }
        return false;
    }

    /**
     * Elimina un usuario por su ID.
     */
    public boolean eliminarUsuario(String id) {
        return listaUsuarios.removeIf(usuario -> usuario.getIdUsuario().equals(id));
    }

    /**
     * Actualiza los datos de un usuario.
     */
    public boolean actualizarUsuario(String id, Usuario actualizado) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario().equals(id)) {
                usuario.setIdUsuario(actualizado.getIdUsuario());
                usuario.setNombre(actualizado.getNombre());
                usuario.setCorreo(actualizado.getCorreo());
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si un usuario ya existe en la tienda.
     */
    public boolean verificarUsuario(String id) {
        return listaUsuarios.stream().anyMatch(usuario -> usuario.getIdUsuario().equals(id));
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", listaJuegos=" + listaJuegos +
                ", listaUsuarios=" + listaUsuarios +
                ", listaAdministradores=" + listaAdministradores +
                '}';
    }
}
