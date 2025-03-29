package co.edu.uniquindio.poo.dtobofstore.model;

public class UsuarioDTO {
    private String nombre;
    private String correo;

    public UsuarioDTO(Usuario usuario) {
        this.nombre = usuario.getNombre();
        this.correo = usuario.getCorreo();
    }
}