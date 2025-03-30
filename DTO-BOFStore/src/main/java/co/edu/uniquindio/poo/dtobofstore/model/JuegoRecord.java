package co.edu.uniquindio.poo.dtobofstore.model;

/**
 * Clase Record.
 */
public record JuegoRecord(String titulo, String desarrollador, Double precio, String genero) {
    public JuegoRecord(Juego juego) {
        this(juego.getTitulo(), juego.getDesarrollador(), juego.getPrecio(), juego.getGenero());
    }
}