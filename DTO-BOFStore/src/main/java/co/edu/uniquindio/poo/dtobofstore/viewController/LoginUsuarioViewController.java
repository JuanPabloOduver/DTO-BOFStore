package co.edu.uniquindio.poo.dtobofstore.viewController;

import co.edu.uniquindio.poo.dtobofstore.App;
import co.edu.uniquindio.poo.dtobofstore.model.Tienda;
import co.edu.uniquindio.poo.dtobofstore.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class LoginUsuarioViewController {

    @FXML
    private Text lbl_Usuario;

    @FXML
    private Text lbl_ingrese_sus_datos;

    @FXML
    private TextField txt_Contrasenia;

    @FXML
    private Button btn_regresar;

    @FXML
    private Button btn_ingresar;

    @FXML
    private AnchorPane ap_LoginUsuario;

    @FXML
    private TextField txt_nombre;

    private App app;
    private Tienda tienda;

    public void setApp(App app, Tienda tienda) {
        this.app = app;
        this.tienda = tienda;
    }

    @FXML
    void onRegresar(ActionEvent event) {
        app.volver();
    }

    @FXML
    void onIngresar(ActionEvent event) {
        verificarUsuario();

    }


    public void verificarUsuario() {
        String nombreIngresado = txt_nombre.getText().trim();
        String contraseniaIngresada = txt_Contrasenia.getText().trim();

        if (nombreIngresado.isEmpty() || contraseniaIngresada.isEmpty()) {
            mostrarAlerta("Los datos no pueden estar vacíos.");
            return;
        }

        boolean usuarioEncontrado = false;
        for (Usuario usuario : tienda.getListaUsuarios()) {
            if (usuario.getNombre().equals(nombreIngresado) && usuario.getId().equals(contraseniaIngresada)) {
                usuarioEncontrado = true;
                app.openUsuario();
                break;
            }
        }

        if (!usuarioEncontrado) {
            mostrarAlerta("Nombre o contraseña incorrectos.");
            limpiarCampos();
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        txt_Contrasenia.clear();
        txt_nombre.clear();
    }
}