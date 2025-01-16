import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.*;

// Clase principal que controla la aplicación
public class Controller {
    private List<Figure> figures = new ArrayList<>();
    private Color color;
    private Figure figure;
    private final Random random = new Random();

    public Controller() {
        View view = new View(this); // Inicializa la ventana y pasa una referencia al controlador
        view.setVisible(true); // Muestra la ventana
    }

    public void addFigure(int x, int y, boolean relleno) {
        Square square = new Square(x, y, relleno, color);//Cambiar por una función que cree la figura que estás seleecionada
        figures.add(square);
    }

    public void drawSquare(Graphics g) {
        for (Figure figure : figures) {
            figure.draw(g); // Dibuja cada cuadrado en la lista
        }
    }

    public void cleanSquareArray(){
        figures = new ArrayList<>();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumOfSquares(){
        return figures.size();
    }

    public void reorganizeSquares(int ySize, int xSize){
        for (Figure figure : figures){
            figure.setX(random.nextInt(0, xSize - figure.getXSide()));
            figure.setY(random.nextInt(0, ySize - figure.getYSide()));
        }
    }

    public void deleteSquare(Figure figure){
        figures.remove(figure);
    }

    public Figure getSquareAt(int x, int y){
        for(Figure figure : figures){
            if(figure.inPosition(x, y)){
                return figure;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new Controller();
    }
}
