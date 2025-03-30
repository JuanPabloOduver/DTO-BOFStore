package co.edu.uniquindio.poo.dtobofstore.viewController;
import co.edu.uniquindio.poo.dtobofstore.App;
import co.edu.uniquindio.poo.dtobofstore.controller.CRUD_UsuarioController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import co.edu.uniquindio.poo.dtobofstore.model.Usuario;

public class CRUD_UsuarioViewController {
    @FXML
    private TableView<Usuario> tb_listUsuarios;

    @FXML
    private TableColumn<Usuario, String> tbc_nombre;

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
    private TableColumn<Usuario, String> tbc_cedula;

    @FXML
    private TableColumn<Usuario, String> tbc_correo;


    @FXML
    void onVolver(ActionEvent event) {
        app.volver();
    }

    @FXML
    void onEliminar(ActionEvent event) {
        eliminarUsuario();
    }

    @FXML
    void onAgregar(ActionEvent event) {
        agregarUsuario();
    }

    @FXML
    void onActualizar(ActionEvent event) {
        actualizarUsuario();
    }

    App app;

    public void setApp(App app) {
        this.app = app;
    }


    CRUD_UsuarioController crudUsuarioController;
    ObservableList<Usuario> listUsuarios = FXCollections.observableArrayList();
    Usuario selectedUsuario;

    @SuppressWarnings("static-access")
    @FXML
    void initialize() {
        crudUsuarioController = new CRUD_UsuarioController(app.tienda);
        initView();
    }

    private void initView() {
        // Traer los datos a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerUsuarios();

        // Agregar los elementos a la tabla
        tb_listUsuarios.setItems(listUsuarios);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbc_nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_cedula.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));
        tbc_correo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerUsuarios() {
        listUsuarios.addAll(crudUsuarioController.obtenerListaUsuarios());
    }

    private void listenerSelection() {
        tb_listUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedUsuario = newSelection;
            mostrarInformacionUsuario(selectedUsuario);
        });
    }

    private void mostrarInformacionUsuario(Usuario usuario) {
        if (usuario != null) {
            txf_cedula.setText(usuario.getId());
            txf_nombre.setText(usuario.getNombre());
            txf_correo.setText(usuario.getCorreo());
        }
    }


    private void agregarUsuario() {
        Usuario usuario = buildUsuario();
        if (crudUsuarioController.crearUsuario(usuario)) {
            listUsuarios.add(usuario);
            limpiarCamposUsuario();
        }
    }

    private Usuario buildUsuario() {
        Usuario usuario = new Usuario(txf_nombre.getText(), txf_cedula.getId(), txf_correo.getText(),null);
        return usuario;
    }

    private void eliminarUsuario() {
        String id = txf_cedula.getText(); // Convierte el texto a entero
        if (crudUsuarioController.eliminarUsuario(id)) { // Pasa el entero como argumento
            listUsuarios.remove(selectedUsuario);
            limpiarCamposUsuario();
            limpiarSeleccion();
        }
    }


    private void actualizarUsuario() {
        if (selectedUsuario != null && crudUsuarioController.actualizarUsuario(selectedUsuario.getId(), buildUsuario())) {
            int index = listUsuarios.indexOf(selectedUsuario);
            if (index >= 0) {
                listUsuarios.set(index, buildUsuario());
            }
            tb_listUsuarios.refresh();
            limpiarSeleccion();
            limpiarCamposUsuario();
        }
    }

    private void limpiarSeleccion() {
        tb_listUsuarios.getSelectionModel().clearSelection();
        limpiarCamposUsuario();
    }

    private void limpiarCamposUsuario() {
        txf_cedula.clear();
        txf_nombre.clear();
        txf_correo.clear();
    }
}

