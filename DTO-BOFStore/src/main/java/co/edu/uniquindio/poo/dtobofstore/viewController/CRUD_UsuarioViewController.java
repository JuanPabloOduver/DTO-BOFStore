package co.edu.uniquindio.poo.dtobofstore.viewController;
import co.edu.uniquindio.poo.dtobofstore.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CRUD_UsuarioViewController {
    @FXML
    private TableView<?> tb_listUsuarios;

    @FXML
    private TableColumn<?, ?> tbc_nombre;

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
    private Button btn_eliminar;

    @FXML
    private Button btn_actualizarUsuario;

    @FXML
    private AnchorPane ap_crud_usuario;

    @FXML
    private TableColumn<?, ?> tbc_cedula;

    @FXML
    private TableColumn<?, ?> tbc_correo;


    @FXML
    void onVolver(ActionEvent event) {

    }

    @FXML
    void onEliminar(ActionEvent event) {

    }

    @FXML
    void onAgregar(ActionEvent event) {

    }

    @FXML
    void onActualizar(ActionEvent event) {

    }

    App app;

    public void setApp(App app) {
        this.app = app;
    }
}

