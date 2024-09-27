package es.jeremy.demofxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase HelloApplication es la clase principal de la aplicación JavaFX.
 * Esta clase extiende la clase Application y es responsable de inicializar
 * la aplicación y mostrar la interfaz de usuario.
 */
public class HelloApplication extends Application {

    /**
     * Método que se llama al inicio de la aplicación.
     * Este método carga el archivo FXML y configura la escena de la aplicación.
     *
     * @param stage El escenario principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Cargar el archivo FXML que define la interfaz de usuario
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxml/hello-view.fxml"));

        // Crear una nueva escena con el contenido del FXML y dimensiones específicas
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // Establecer el título de la ventana principal
        stage.setTitle("Calculadora");

        // Asignar la escena al escenario
        stage.setScene(scene);

        // Mostrar la ventana de la aplicación
        stage.show();
    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Los argumentos de línea de comandos pasados a la aplicación.
     */
    public static void main(String[] args) {
        // Llamar al método launch para iniciar la aplicación JavaFX
        launch();
    }
}
