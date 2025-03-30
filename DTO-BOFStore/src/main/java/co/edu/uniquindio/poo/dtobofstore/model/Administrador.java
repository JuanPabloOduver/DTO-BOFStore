package co.edu.uniquindio.poo.dtobofstore.model;

public class Administrador extends Persona{
    public Administrador(String id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    @Override
    public String toString() {
        return "Administrador{}";
    }
}
