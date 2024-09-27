package es.jeremy.demofxml; // Asegúrate de que este paquete sea correcto

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * Controlador de la vista de la calculadora.
 * Este controlador maneja la lógica de la calculadora, permitiendo al usuario
 * realizar operaciones matemáticas básicas como sumar, restar, multiplicar y dividir.
 */
public class ControladorParaHelloView {

    @FXML
    private TextField firstNumber;   // Campo de texto para ingresar el primer número
    @FXML
    private TextField secondNumber;  // Campo de texto para ingresar el segundo número
    @FXML
    private TextField resultField;   // Campo de texto para mostrar el resultado

    @FXML
    private RadioButton sumRadio;        // Botón de opción para sumar
    @FXML
    private RadioButton subtractRadio;   // Botón de opción para restar
    @FXML
    private RadioButton multiplyRadio;   // Botón de opción para multiplicar
    @FXML
    private RadioButton divideRadio;     // Botón de opción para dividir

    /**
     * Método que realiza el cálculo basado en la operación seleccionada por el usuario.
     * Este método verifica que ambos números estén ingresados y maneja las excepciones
     * de conversión de texto a número. Luego, realiza la operación matemática seleccionada.
     */
    @FXML
    public void calculate() {
        // Obtener texto de los campos
        String firstNum = firstNumber.getText();
        String secondNum = secondNumber.getText();

        // Verificar si ambos números están ingresados
        if (firstNum.isEmpty() || secondNum.isEmpty()) {
            showError("Por favor, introduce ambos números.");
            return; // Salir del método si hay un error
        }

        double num1;
        double num2;

        // Intentar convertir los textos a números
        try {
            num1 = Double.parseDouble(firstNum);
            num2 = Double.parseDouble(secondNum);
        } catch (NumberFormatException e) {
            showError("Por favor, introduce números válidos.");
            return; // Salir si hay un error de conversión
        }

        double result = 0;

        // Realizar la operación basada en la selección del usuario
        if (sumRadio.isSelected()) {
            result = num1 + num2; // Sumar
        } else if (subtractRadio.isSelected()) {
            result = num1 - num2; // Restar
        } else if (multiplyRadio.isSelected()) {
            result = num1 * num2; // Multiplicar
        } else if (divideRadio.isSelected()) {
            if (num2 != 0) {
                result = num1 / num2; // Dividir
            } else {
                showError("Error: División por cero.");
                return; // Salir si hay un error de división
            }
        }

        // Mostrar el resultado
        resultField.setText(String.valueOf(result));
    }

    /**
     * Muestra un mensaje de error en una ventana de alerta.
     *
     * @param message El mensaje de error a mostrar.
     */
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR); // Crear una alerta de tipo ERROR
        alert.setTitle("Error"); // Establecer el título de la alerta
        alert.setHeaderText(null); // Sin encabezado
        alert.setContentText(message); // Establecer el contenido del mensaje
        alert.showAndWait(); // Mostrar la alerta y esperar a que el usuario la cierre
    }

    /**
     * Limpia todos los campos de entrada y resultados.
     * Este método se utiliza para restablecer la calculadora a su estado inicial.
     */
    @FXML
    public void clearFields() {
        firstNumber.clear();  // Limpiar el campo del primer número
        secondNumber.clear(); // Limpiar el campo del segundo número
        resultField.clear();  // Limpiar el campo del resultado
        sumRadio.setSelected(false); // Deseleccionar el botón de suma
        subtractRadio.setSelected(false); // Deseleccionar el botón de resta
        multiplyRadio.setSelected(false); // Deseleccionar el botón de multiplicación
        divideRadio.setSelected(false); // Deseleccionar el botón de división
    }
}

