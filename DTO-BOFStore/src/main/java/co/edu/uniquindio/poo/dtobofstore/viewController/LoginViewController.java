package co.edu.uniquindio.poo.dtobofstore.viewController;
import co.edu.uniquindio.poo.dtobofstore.App;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class LoginViewController {
    @FXML
    private Button btn_cliente;

    @FXML
    private Button btn_registrarse;

    @FXML
    private Text lbl_bienvenido1;

    @FXML
    private Text lbl_bienvenido;

    @FXML
    private AnchorPane ap_login;

    @FXML
    private Text lbl_iniciarComo;

    @FXML
    private Button btn_administrador;

    @FXML
    void onCliente(ActionEvent event) {
        //app.openLoginUsuario();
        app.openLoginAdministrador();
    }

    @FXML
    void onAdministrador(ActionEvent event) {
        app.openLoginAdministrador();
    }

    @FXML
    void onRegistrarse(ActionEvent event) {
        app.openLoginAdministrador();
    }

    App app;

    public void setApp(App app) {
        this.app = app;
    }
}
