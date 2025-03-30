package co.edu.uniquindio.poo.dtobofstore.viewController;
import co.edu.uniquindio.poo.dtobofstore.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

public class RegistrarseViewController {
    @FXML
    private TextField txf_nombre;

    @FXML
    private Button btn_agregarUsuario;

    @FXML
    private TextField txf_cedula;

    @FXML
    private TextField txf_correo;

    @FXML
    private Button btn_volver;

    @FXML
    private Button btn_limpiar;

    @FXML
    private AnchorPane ap_registrarse;

    @FXML
    void onVolver(ActionEvent event) {

    }

    @FXML
    void onLimpiar(ActionEvent event) {

    }

    @FXML
    void onCrearUsuario(ActionEvent event) {

    }

    App app;

    public void setApp(App app) {
        this.app = app;
    }
}
