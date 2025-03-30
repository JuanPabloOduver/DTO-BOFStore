package co.edu.uniquindio.poo.dtobofstore.viewController;
import co.edu.uniquindio.poo.dtobofstore.App;
import co.edu.uniquindio.poo.dtobofstore.controller.AdministradorController;
import co.edu.uniquindio.poo.dtobofstore.model.Juego;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.beans.property.SimpleStringProperty;

public class AdministradorViewController {
    @FXML
    private TableColumn<Juego, String> tbc_id;

    @FXML
    private ImageView img_carro;

    @FXML
    private Text txt_queDeseaHacer;

    @FXML
    private TableColumn<Juego, String> tbc_genero;

    @FXML
    private Button btn_volver;

    @FXML
    private Button btn_crudUsuario;

    @FXML
    private Button btn_crudJuegos;

    @FXML
    private TableView<Juego> tb_listJuegos;

    @FXML
    private Text txt_bienvenido;

    @FXML
    private TableColumn<Juego, String> tbc_titulo;

    @FXML
    private TableColumn<Juego, String> tbc_precio;

    @FXML
    private TableColumn<Juego, String> tbc_desarrollador;

    @FXML
    private Text txt_reservas;

    @FXML
    private Text txt_nombreAdministrador;

    @FXML
    private AnchorPane ap_administrador;

    @FXML
    void onVolver(ActionEvent event) {
        app.volver();
    }

    @FXML
    void onGestionUsuarios(ActionEvent event) {
        app.openCRUD_Usuario();
    }

    @FXML
    void onGestionJuegos(ActionEvent event) {
        app.openCRUD_Juego();
    }

    App app;

    public void setApp(App app) {
        this.app = app;
    }


    AdministradorController administradorController;
    ObservableList<Juego> listJuegos = FXCollections.observableArrayList();

    @SuppressWarnings("static-access")
    @FXML
    void initialize() {
        administradorController = new AdministradorController(app.tienda);
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerJuegos();
    }

    private void initDataBinding() {
        tbc_id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdJuego()));
        tbc_titulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        tbc_desarrollador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDesarrollador()));
        tbc_genero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
        tbc_precio.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrecio())));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerJuegos() {
        listJuegos.addAll(administradorController.obtenerListaJuegos());
    }

}