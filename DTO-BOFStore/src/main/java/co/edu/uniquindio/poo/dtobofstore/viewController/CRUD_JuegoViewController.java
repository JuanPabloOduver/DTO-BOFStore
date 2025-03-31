package co.edu.uniquindio.poo.dtobofstore.viewController;

import co.edu.uniquindio.poo.dtobofstore.App;
import co.edu.uniquindio.poo.dtobofstore.model.Juego;
import co.edu.uniquindio.poo.dtobofstore.controller.CRUD_JuegoController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class CRUD_JuegoViewController {
    @FXML
    private TableColumn<Juego, String> tbc_id;
    @FXML
    private TableColumn<Juego, String> tbc_titulo;
    @FXML
    private TableColumn<Juego, String> tbc_desarrollador;
    @FXML
    private TableColumn<Juego, String> tbc_precio;
    @FXML
    private TableColumn<Juego, String> tbc_genero;

    @FXML
    private TableView<Juego> tb_listJuegos;

    @FXML
    private Button btn_agregarUsuario, btn_volver, btn_eliminar, btn_ActualizarJuego;

    @FXML
    private TextField txf_id, txf_titulo, txf_desarrollador, txf_genero, txf_precio;

    @FXML
    private AnchorPane ap_crud_juego;

    @FXML
    void onVolver(ActionEvent event) {
        app.volver();
    }

    @FXML
    void onEliminar(ActionEvent event) {
        eliminarJuego();
    }

    @FXML
    void onAgregar(ActionEvent event) {
        agregarJuego();
    }

    @FXML
    void onActualizar(ActionEvent event) {
        actualizarJuego();
    }

    App app;
    public void setApp(App app) {
        this.app = app;
    }

    CRUD_JuegoController crudJuegoController;
    ObservableList<Juego> listJuegos = FXCollections.observableArrayList();
    Juego selectedJuego;

    @SuppressWarnings("static-access")
    @FXML
    void initialize() {
        crudJuegoController = new CRUD_JuegoController(app.tienda);
        initView();
    }

    private void initView() {
        // Traer los datos a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerJuegos();

        // Agregar los elementos a la tabla
        tb_listJuegos.setItems(listJuegos);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbc_id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdJuego()));
        tbc_titulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        tbc_desarrollador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDesarrollador()));
        tbc_precio.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrecio())));
        tbc_genero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerJuegos() {
        listJuegos.addAll(crudJuegoController.obtenerListaJuegos());
    }

    private void listenerSelection() {
        tb_listJuegos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedJuego = newSelection;
            mostrarInformacionJuego(selectedJuego);
        });
    }

    private void mostrarInformacionJuego(Juego juego) {
        if (juego != null) {
            txf_id.setText(juego.getIdJuego());
            txf_titulo.setText(juego.getTitulo());
            txf_desarrollador.setText(juego.getDesarrollador());
            txf_precio.setText(String.format("%.2f", juego.getPrecio()));
            txf_genero.setText(juego.getGenero());
        }
    }

    private void agregarJuego() {
        Juego juego = buildJuego();
        if (crudJuegoController.crearJuego(juego)) {
            listJuegos.add(juego);
            limpiarCamposJuego();
        }
    }

    private Juego buildJuego() {
        double precio = Double.parseDouble(txf_precio.getText());
        Juego juego = new Juego(txf_id.getText(), txf_titulo.getText(), txf_desarrollador.getText(), precio, txf_genero.getText());
        return juego;
    }

    private void eliminarJuego() {
        if (selectedJuego != null && crudJuegoController.eliminarJuego(selectedJuego.getIdJuego())) {
            listJuegos.remove(selectedJuego);
            limpiarSeleccion();
        }
    }

    private void actualizarJuego() {
        if (selectedJuego != null && crudJuegoController.actualizarJuego(selectedJuego.getIdJuego(), buildJuego())) {
            int index = listJuegos.indexOf(selectedJuego);
            if (index >= 0) {
                listJuegos.set(index, buildJuego());
            }
            tb_listJuegos.refresh();
            limpiarSeleccion();
            limpiarCamposJuego();
        }
    }

    private void limpiarSeleccion() {
        tb_listJuegos.getSelectionModel().clearSelection();
        limpiarCamposJuego();
    }

    private void limpiarCamposJuego() {
        txf_id.clear();
        txf_titulo.clear();
        txf_desarrollador.clear();
        txf_genero.clear();
        txf_precio.clear();
    }
}