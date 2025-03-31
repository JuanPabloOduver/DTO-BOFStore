package co.edu.uniquindio.poo.dtobofstore.viewController;

import co.edu.uniquindio.poo.dtobofstore.model.Tienda;
import co.edu.uniquindio.poo.dtobofstore.model.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import co.edu.uniquindio.poo.dtobofstore.App;
import co.edu.uniquindio.poo.dtobofstore.controller.TiendaController;
import co.edu.uniquindio.poo.dtobofstore.model.Juego;

public class TiendaViewController {
    @FXML
    private AnchorPane ap_tienda;

    @FXML
    private TableView<Juego> tbl_tabladetienda;

    @FXML
    private TableColumn<Juego, String> tb_IdJuego;

    @FXML
    private TableColumn<Juego, String> tb_Titulo;

    @FXML
    private TableColumn<Juego, String> tb_Desarrollador;

    @FXML
    private TableColumn<Juego, String> tb_Genero;

    @FXML
    private TableColumn<Juego, String> tb_Precio;

    @FXML
    private Button btn_regresar;

    @FXML
    private Button btn_Comprar;

    @FXML
    private Text lbl_Tienda;
    private Usuario usuario;
    private App app;
    private TiendaController tiendaController;
    private ObservableList<Juego> listaJuegos = FXCollections.observableArrayList();

    public void setApp(App app) {
        this.app = app;
        tiendaController = new TiendaController(app.tienda);
        cargarJuegos();
    }

    @FXML
    void initialize() {
        configurarTabla();
    }

    private void configurarTabla() {
        tb_IdJuego.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdJuego()));
        tb_Titulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        tb_Desarrollador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDesarrollador()));
        tb_Genero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
        tb_Precio.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrecio())));

        tbl_tabladetienda.setItems(listaJuegos);
    }

    private void cargarJuegos() {
        listaJuegos.addAll(tiendaController.tienda.getListaJuegos());
    }

    @FXML
    void onRegresar(ActionEvent event) {
        app.volver();
    }

    @FXML
    void onComprar(ActionEvent event) {
        Juego juegoSeleccionado = tbl_tabladetienda.getSelectionModel().getSelectedItem();
        if (juegoSeleccionado != null) {
            tiendaController.comprarJuego(juegoSeleccionado);
            usuario.agregarJuegoABiblioteca(juegoSeleccionado);
        }
    }
    public void setApp(App app, Tienda tienda) {
        this.app = app;
        this.tiendaController = new TiendaController(tienda); // Se inicializa correctamente
        cargarJuegos(); // Cargamos los juegos en la tabla
    }
}