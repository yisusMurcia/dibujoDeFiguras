import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.*;

// Clase principal que controla la aplicación
public class Controller {
    private List<Square> squares = new ArrayList<>();
    private Color color;
    private final Random random = new Random();

    public Controller() {
        View view = new View(this); // Inicializa la ventana y pasa una referencia al controlador
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

    public int getNumOfSquares(){
        return squares.size();
    }

    public void reorganizeSquares(int ySize, int xSize){
        for (Square square : squares){
            square.setX(random.nextInt(0, xSize - square.getLado()));
            square.setY(random.nextInt(0, ySize - square.getLado()));
        }
    }

    public boolean deleteSquare(int x, int y){
        for (Square square: squares){//Borarr cuadrado al clicker el borde derecho inferior
            if ((square.getLado() + square.getX() - 10) <= x && x <= (square.getLado() + square.getX()) && (square.getLado() + square.getY() - 10) <= y &&  y <= (square.getLado() + square.getY())){
                squares.remove(square);
                return true;
            }
        }
        return false;
    }

    public Square getSquareAt(int x, int y){
        for(Square square : squares){
            if(square.inPosition(x, y)){
                return square;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new Controller();
    }
}
