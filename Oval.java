import java.awt.*;
import java.util.Random;

public class Oval extends Figure{

    public Oval(int x, int y, boolean filled, Color color){
        super(filled, color, (new Random().nextInt(100) + 20), (new Random().nextInt(100) + 20), x, y);
    }

    @Override
    public void draw(Graphics g) {
        if (filled) {
            g.setColor(color); // Color del relleno
            g.fillOval(x, y, xSide, ySide); // Dibuja el óvalo
        }

        g.setColor(color); // Color del contorno
        g.drawOval(x, y, xSide, ySide); // Dibuja el óvalo
    }
}
