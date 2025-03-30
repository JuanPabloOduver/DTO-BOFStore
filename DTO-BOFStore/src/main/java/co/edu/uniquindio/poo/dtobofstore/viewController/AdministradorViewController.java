package co.edu.uniquindio.poo.dtobofstore.viewController;
import co.edu.uniquindio.poo.dtobofstore.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class AdministradorViewController {
    @FXML
    private TableColumn<?, ?> tbc_id;

    @FXML
    private ImageView img_carro;

    @FXML
    private Text txt_queDeseaHacer;

    @FXML
    private TableColumn<?, ?> tb_genero;

    @FXML
    private Button btn_volver;

    @FXML
    private Button btn_crudUsuario;

    @FXML
    private Button btn_crudJuegos;

    @FXML
    private TableView<?> tb_listJuegos;

    @FXML
    private Text txt_bienvenido;

    @FXML
    private TableColumn<?, ?> tbc_titulo;

    @FXML
    private TableColumn<?, ?> tb_precio;

    @FXML
    private TableColumn<?, ?> tbc_desarrollador;

    @FXML
    private Text txt_reservas;

    @FXML
    private Text txt_nombreAdministrador;

    @FXML
    private Text txt_tucarro;

    @FXML
    private AnchorPane ap_administrador;

    @FXML
    void onVolver(ActionEvent event) {

    }

    @FXML
    void onGestionUsuarios(ActionEvent event) {

    }

    @FXML
    void onGestionJuegos(ActionEvent event) {

    }

    App app;

    public void setApp(App app) {
        this.app = app;
    }
}