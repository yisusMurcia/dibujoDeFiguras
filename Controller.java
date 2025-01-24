import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.*;

// Clase principal que controla la aplicación
public class Controller {
    private final List<Figure> figures = new ArrayList<>();
    private Color color;
    private final Random random = new Random();
    private int totalFigures;

    public Controller() {
        View view = new View(this); // Inicializa la ventana y pasa una referencia al controlador
        view.setVisible(true); // Muestra la ventana
        totalFigures = 0;
    }

    public void addFigure(String figureType, int x, int y, boolean relleno) {

        Figure figure = switch (figureType) {
            case "Circle" -> new Circle(x, y, relleno, color);
            case "Rectangle" -> new Rectangle(x, y, relleno, color);
            case "Oval" -> new Oval(x, y, relleno, color);
            case "Triangle" -> new Triangle(x, y, relleno, color);
            default -> new Square(x, y, relleno, color);
        };

        totalFigures++;

        figures.add(figure);
    }

    public void drawFigure(Graphics g) {
        for (Figure figure : figures) {
            figure.draw(g); // Dibuja cada cuadrado en la lista
        }
    }

    public void cleanSquareArray(){
        figures.clear();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumOfFigures(){
        return figures.size();
    }

    public void reorganizeSquares(int ySize, int xSize){
        for (Figure figure : figures){
            figure.setX(random.nextInt(0, xSize - figure.getXSide()));
            figure.setY(random.nextInt(0, ySize - figure.getYSide()));
        }
    }

    public void deleteFigure(Figure figure){
        figures.remove(figure);
    }

    public void inverFiguresColor(){
        for(Figure figure : figures){
            figure.setFilled(!figure.isFilled());
        }
    }

    public Figure getFigureAt(int x, int y){
        for(Figure figure : figures){
            if(figure.inPosition(x, y)){
                return figure;
            }
        }
        return null;
    }

    public int getTotalFigures() {
        return totalFigures;
    }

    public static void main(String[] args) {
        new Controller();
    }
}
