package co.edu.uniquindio.poo.dtobofstore.model;

public class Juego {
    private String idJuego;
    private String titulo;
    private String desarollador;
    private Double precio;
    private String genero;

    public Juego(String idJuego, String titulo, String desarollador, Double precio, String genero) {
        this.idJuego = idJuego;
        this.titulo = titulo;
        this.desarollador = desarollador;
        this.precio = precio;
        this.genero = genero;
    }

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

    public String getDesarollador() {
        return desarollador;
    }
    public void setDesarollador(String desarollador) {
        this.desarollador = desarollador;
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

    @Override
    public String toString() {
        return "Juego{" +
                "idJuego='" + idJuego + '\'' +
                ", titulo='" + titulo + '\'' +
                ", desarollador='" + desarollador + '\'' +
                ", precio=" + precio +
                ", genero='" + genero + '\'' +
                '}';
    }
}