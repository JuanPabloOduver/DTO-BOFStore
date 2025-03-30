package co.edu.uniquindio.poo.dtobofstore.viewController;
import co.edu.uniquindio.poo.dtobofstore.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

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

    }

    @FXML
    void onVolver(ActionEvent event) {

    }

    App app;

    public void setApp(App app) {
        this.app = app;
    }
}
