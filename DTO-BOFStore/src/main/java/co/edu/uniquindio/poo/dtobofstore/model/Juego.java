package co.edu.uniquindio.poo.dtobofstore.model;

/**
 * Clase que representa un juego en la tienda.
 */
public class Juego {
    private String idJuego;       // Identificador único del juego
    private String titulo;        // Título del juego
    private String desarrollador;  // Nombre del desarrollador
    private Double precio;        // Precio del juego
    private String genero;        // Género del juego

    /**
     * Constructor para inicializar un juego.
     */
    public Juego(String idJuego, String titulo, String desarrollador, Double precio, String genero) {
        this.idJuego = idJuego;
        this.titulo = titulo;
        this.desarrollador = desarrollador;
        this.precio = precio;
        this.genero = genero;
    }

    // Métodos getter y setter para acceder y modificar los atributos

    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    /**
     * Método toString.
     */
    @Override
    public String toString() {
        return "Juego{" +
                "idJuego='" + idJuego + '\'' +
                ", titulo='" + titulo + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", precio=" + precio +
                ", genero='" + genero + '\'' +
                '}';
    }
}