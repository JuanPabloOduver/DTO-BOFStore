package co.edu.uniquindio.poo.dtobofstore.viewController;

import co.edu.uniquindio.poo.dtobofstore.App;
import co.edu.uniquindio.poo.dtobofstore.controller.UsuarioController;
import co.edu.uniquindio.poo.dtobofstore.model.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class UsuarioViewController {

    @FXML
    private Text lbl_panelUsuario;

    @FXML
    private TableColumn<Juego, String> tb_Titulo;

    @FXML
    private Button btn_Tienda;

    @FXML
    private TableColumn<Juego, String> tb_Desarrollador;

    @FXML
    private TableColumn<Juego, String> tb_Genero;

    @FXML
    private AnchorPane ap_usuario;

    @FXML
    private Button btn_CerrarSesion;

    @FXML
    private TableColumn<Juego, String> tb_IdJuego;

    @FXML
    private TableColumn<Juego, Double> tb_Precio;

    @FXML
    private TableView<Juego> tbl_panel_usuario;

    private App app;
    private UsuarioController usuarioController;

    @FXML
    void onCerrarSesion(ActionEvent event) {
        app.volver();
    }

    @FXML
    void onTienda(ActionEvent event) {
        app.openTienda();
    }

    public void setApp(App app, UsuarioController usuarioController) {
        this.app = app;
        this.usuarioController = usuarioController;
        inicializarTabla();
    }


    private void inicializarTabla() {
        tb_IdJuego.setCellValueFactory(new PropertyValueFactory<>("id"));
        tb_Titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        tb_Desarrollador.setCellValueFactory(new PropertyValueFactory<>("desarrollador"));
        tb_Precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tb_Genero.setCellValueFactory(new PropertyValueFactory<>("genero"));

        tbl_panel_usuario.getItems().setAll(usuarioController.obtenerBiblioteca());
    }
}
