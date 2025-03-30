package co.edu.uniquindio.poo.dtobofstore.model;
import java.util.List;

/**
 * Clase Record.
 */
public record CarritoRecord(String idCarrito, String usuario, List<JuegoRecord> juegos) {
    public CarritoRecord(Carrito carrito) {
        this(carrito.getIdCarrito(), carrito.getUsuario().getNombre(),
                carrito.getListaJuegos().stream().map(JuegoRecord::new).toList());
    }
}
