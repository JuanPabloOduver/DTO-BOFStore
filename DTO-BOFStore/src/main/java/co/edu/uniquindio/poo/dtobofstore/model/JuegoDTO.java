package co.edu.uniquindio.poo.dtobofstore.model;

public class JuegoDTO {
    private String titulo;
    private String desarollador;
    private Double precio;
    private String genero;

    public JuegoDTO(Juego juego) {
        this.titulo = juego.getTitulo();
        this.desarollador = juego.getDesarollador();
        this.precio = juego.getPrecio();
        this.genero = juego.getGenero();
    }
}