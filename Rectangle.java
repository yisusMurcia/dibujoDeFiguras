import java.awt.*;
import java.util.Random;

public class Rectangle extends Figure{

    public Rectangle(int x, int y, boolean filled, Color color){
        super(filled, color, (new Random().nextInt(100) + 25), (new Random().nextInt(100) + 25), x, y);
    }

    @Override
    public void draw(Graphics g) {
        if (filled) {
            g.setColor(color); // Color del relleno
            g.fillRect(x, y, xSide, ySide); // Dibuja el cuadrado
        }

        g.setColor(color); // Color del contorno
        g.drawRect(x, y, xSide, ySide); // Dibuja el cuadrado
    }

    @Override
    public double getArea() {
        return xSide*ySide;
    }
}
