import java.awt.*;
import java.util.Random;

public class Triangle extends Figure{

    public Triangle(int x, int y, boolean filled, Color color){
        super(filled, color, (new Random().nextInt(100) + 25), x, y);
    }

    @Override
    public void draw(Graphics g) {
        if (filled) {
            g.setColor(color); // Color del relleno
            g.fillPolygon(new int[]{x, x + xSide, x + xSide/2}, new int[]{y + ySide, y + ySide, y}, 3); // Dibuja el triángulo
        }

        g.setColor(color); // Color del contorno
        g.drawPolygon(new int[]{x, x + xSide, x + xSide/2}, new int[]{y + ySide, y + ySide, y}, 3); // Dibuja el triángulo

    }
}
