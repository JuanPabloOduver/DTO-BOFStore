package co.edu.uniquindio.poo.dtobofstore;

import co.edu.uniquindio.poo.dtobofstore.model.Administrador;
import co.edu.uniquindio.poo.dtobofstore.model.Juego;
import co.edu.uniquindio.poo.dtobofstore.model.Tienda;
import co.edu.uniquindio.poo.dtobofstore.model.Usuario;
import co.edu.uniquindio.poo.dtobofstore.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import co.edu.uniquindio.poo.dtobofstore.controller.*;


public class App extends Application {
    private Stage primaryStage;
    @SuppressWarnings("exports")
    public static Tienda tienda = new Tienda("Bof Store");
    public static Usuario usuario = null;

    private Stack<Scene> sceneHistory = new Stack<>();

    @SuppressWarnings("exports")
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Bof Store");
        openLogin();
    }

    public static void main(String[] args) {
        launch();
    }



    public void openLogin() {
        inicializarData();
        try {
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(App.class.getResource("Login.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader1.load(); // Cambiado de VBox a AnchorPane
            LoginViewController loginViewController = loader1.getController();
            loginViewController.setApp(this);

            Scene scene1 = new Scene(rootLayout);
            primaryStage.setScene(scene1);
            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Error al cargar usuarios.fxml");
            e.printStackTrace();
        }
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void cambiarEscena(Scene nuevaEscena) {
        if (primaryStage.getScene() != null) {
            sceneHistory.push(primaryStage.getScene()); // Guarda la escena actual en la pila
        }
        primaryStage.setScene(nuevaEscena); // Cambia a la nueva escena
        primaryStage.show(); // Muestra la nueva escena
    }

    public void volver() {
        if (!sceneHistory.isEmpty()) {
            Scene previousScene = sceneHistory.pop(); // Recupera la última escena de la pila
            primaryStage.setScene(previousScene); // Cambia a la escena previa
            primaryStage.show(); // Muestra la escena anterior
        } else {
            System.out.println("No hay escenas previas en el historial."); // Mensaje cuando la pila está vacía
        }
    }

    public void openLoginAdministrador() {

        try {
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(App.class.getResource("LoginAdministrador.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader2.load();
            LoginAdministradorViewController loginAdministradorViewController = loader2.getController();
            loginAdministradorViewController.setApp(this);

            Scene newScene = new Scene(rootLayout);

            if (primaryStage.getScene() != null) {
                sceneHistory.push(primaryStage.getScene());
            }

            primaryStage.setScene(newScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openLoginUsuario() {

        try {
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(App.class.getResource("LoginUsuario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader2.load();
            LoginUsuarioViewController loginUsuarioViewController = loader2.getController();
            loginUsuarioViewController.setApp(this, tienda);

            Scene newScene = new Scene(rootLayout);

            if (primaryStage.getScene() != null) {
                sceneHistory.push(primaryStage.getScene());
            }

            primaryStage.setScene(newScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openAdministrador() {

        try {
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(App.class.getResource("Administrador.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader2.load();
            AdministradorViewController administradorViewController = loader2.getController();
            administradorViewController.setApp(this);

            Scene newScene = new Scene(rootLayout);

            if (primaryStage.getScene() != null) {
                sceneHistory.push(primaryStage.getScene());
            }

            primaryStage.setScene(newScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCRUD_Juego() {
        try {
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(App.class.getResource("CRUD_Juego.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader2.load();
            CRUD_JuegoViewController crudJuegoViewController = loader2.getController();
            crudJuegoViewController.setApp(this);

            Scene newScene = new Scene(rootLayout);

            if (primaryStage.getScene() != null) {
                sceneHistory.push(primaryStage.getScene());
            }

            primaryStage.setScene(newScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCRUD_Usuario() {
        try {
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(App.class.getResource("CRUD_Usuario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader2.load();
            CRUD_UsuarioViewController crudUsuarioViewController = loader2.getController();
            crudUsuarioViewController.setApp(this);

            Scene newScene = new Scene(rootLayout);

            if (primaryStage.getScene() != null) {
                sceneHistory.push(primaryStage.getScene());
            }

            primaryStage.setScene(newScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openUsuario() {
        try {
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(App.class.getResource("Usuario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader2.load();

            UsuarioViewController usuarioViewController = loader2.getController();

            UsuarioController usuarioController = new UsuarioController(usuario, tienda);

            usuarioViewController.setApp(this, usuarioController);

            Scene newScene = new Scene(rootLayout);

            if (primaryStage.getScene() != null) {
                sceneHistory.push(primaryStage.getScene());
            }

            primaryStage.setScene(newScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openTienda() {
        try {
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(App.class.getResource("Tienda.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader2.load();

            TiendaViewController tiendaViewController = loader2.getController();
            tiendaViewController.setApp(this, tienda);

            Scene newScene = new Scene(rootLayout);

            if (primaryStage.getScene() != null) {
                sceneHistory.push(primaryStage.getScene());
            }

            primaryStage.setScene(newScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inicializarData() {

        List<Juego> juegos = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();

        Juego juego1 = new Juego("123","Undertale","Sprekk",200.0,"Aventura");
        tienda.agregarJuego(juego1);
        Juego juego2 = new Juego("134","Roblox","Sprekk",50.0,"Plataformas");
        tienda.agregarJuego(juego2);

                Usuario usuario1 = new Usuario("1095","Raul","@Raul",null);
        tienda.agregarUsuario(usuario1);
        Usuario usuario2= new Usuario("1043","Fernequi","@Nequi",null);
        tienda.agregarUsuario(usuario2);

        Administrador administrador1 = new Administrador("321","Andres","Sprekk");
        tienda.agregarAdministrador(administrador1);
    }
}