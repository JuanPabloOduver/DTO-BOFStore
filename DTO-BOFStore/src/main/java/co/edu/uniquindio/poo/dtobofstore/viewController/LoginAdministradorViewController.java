package co.edu.uniquindio.poo.dtobofstore.viewController;
import co.edu.uniquindio.poo.dtobofstore.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import co.edu.uniquindio.poo.dtobofstore.model.Administrador;
import co.edu.uniquindio.poo.dtobofstore.model.Tienda;
import co.edu.uniquindio.poo.dtobofstore.model.Usuario;

public class LoginAdministradorViewController {
    @FXML
    private TextField txf_nombreAd;

    @FXML
    private Button btn_volver;

    @FXML
    private AnchorPane ap_LoginAdministrador;

    @FXML
    private Text txt_iniciarSesion;

    @FXML
    private Button btn_ingresar;

    @FXML
    private TextField txf_contraseña;

    @FXML
    private Text txt_administrador;

    @FXML
    void onIngresar(ActionEvent event) {
        verificarAdministrador();
    }

    @FXML
    void onVolver(ActionEvent event) {
        app.volver();
    }

    App app;

    public void setApp(App app) {
        this.app = app;
    }


    static Administrador administradorIniciado;


    public void verificarAdministrador() {
        String nombreIngresado = txf_nombreAd.getText().trim();
        String cedulaIngresada = txf_contraseña.getText().trim();
        if (cedulaIngresada.isEmpty() || nombreIngresado.isEmpty()) {
            mostrarAlerta("Los datos no pueden estar vacíos.");
            return;
        }
        boolean administradorEncontrado = false;
        Tienda tienda = app.tienda;
        for (Administrador administrador : tienda.getListaAdministradores()) {
            if (administrador.getNombre().equals(nombreIngresado) && administrador.getId().equals(cedulaIngresada)) {
                administradorIniciado = administrador;
                app.openAdministrador();
                administradorEncontrado = true;
                break;
            }
        }
        if (!administradorEncontrado) {
            mostrarAlerta("Contraseña o nombre incorrectos.");
            limpiarCampos();
        }
    }

    private void mostrarAlerta(String mensaje) {
        // Crear y mostrar una alerta de error o advertencia
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        txf_contraseña.clear();
        txf_nombreAd.clear();
    }

}
