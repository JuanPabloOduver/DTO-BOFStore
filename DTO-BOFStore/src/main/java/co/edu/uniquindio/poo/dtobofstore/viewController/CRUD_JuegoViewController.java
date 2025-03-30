package co.edu.uniquindio.poo.dtobofstore.viewController;
import co.edu.uniquindio.poo.dtobofstore.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CRUD_JuegoViewController {
    @FXML
    private TableColumn<?, ?> tbc_id;

    @FXML
    private Button btn_agregarUsuario;

    @FXML
    private TextField txf_id;

    @FXML
    private TextField txf_titulo;

    @FXML
    private TextField txf_genero;

    @FXML
    private Button btn_volver;

    @FXML
    private Button btn_eliminar;

    @FXML
    private TableColumn<?, ?> tb_genero;

    @FXML
    private AnchorPane ap_crud_juego;

    @FXML
    private TableView<?> tb_listJuegos;

    @FXML
    private TableColumn<?, ?> tbc_titulo;

    @FXML
    private TableColumn<?, ?> tb_precio;

    @FXML
    private Button btn_ActualizarUsuario;

    @FXML
    private TextField txf_precio;

    @FXML
    private TableColumn<?, ?> tbc_desarrollador;

    @FXML
    private TextField txf_desarrolador;

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
