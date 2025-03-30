package co.edu.uniquindio.poo.dtobofstore.model;

/**
 * Clase DTO.
 */
public class UsuarioDTO {
    private String nombre;  // Nombre del usuario
    private String correo;  // Correo electrónico del usuario

    /**
     * Constructor que convierte un objeto Usuario en un UsuarioDTO.
     */
    public UsuarioDTO(Usuario usuario) {
        this.nombre = usuario.getNombre();
        this.correo = usuario.getCorreo();
    }
}
