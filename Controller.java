import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.*;

// Clase principal que controla la aplicación
public class Controller {
    private List<Square> squares = new ArrayList<>();
    private Color color;
    private final Random random = new Random();
    private final View view;

    public Controller() {
        view = new View(this); // Inicializa la ventana y pasa una referencia al controlador
        view.setVisible(true); // Muestra la ventana
    }

    public void addSquare(int x, int y, boolean relleno) {
        int lado = random.nextInt(100) + 20; // Lado aleatorio entre 20 y 119
        Square square = new Square(x, y, lado, relleno, color);
        squares.add(square);
    }

    public void drawSquare(Graphics g) {
        for (Square square : squares) {
            square.draw(g); // Dibuja cada cuadrado en la lista
        }
    }

    public void cleanSquareArray(){
        squares = new ArrayList<>();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static void main(String[] args) {
        new Controller();
    }
}
