package co.edu.uniquindio.poo.dtobofstore.model;

/**
 * Clase DTO.
 */
public class JuegoDTO {
    private String titulo;        // Título del juego
    private String desarrollador;  // Nombre del desarrollador
    private Double precio;        // Precio del juego
    private String genero;        // Género del juego

    /**
     * Constructor que convierte un objeto Juego en un JuegoDTO.
     */
    public JuegoDTO(Juego juego) {
        this.titulo = juego.getTitulo();
        this.desarrollador = juego.getDesarrollador();
        this.precio = juego.getPrecio();
        this.genero = juego.getGenero();
    }
}
