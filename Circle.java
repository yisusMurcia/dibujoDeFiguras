import java.awt.*;
import java.util.Random;

public class Circle extends Figure{
    private final int side;
    public Circle(int x, int y, boolean filled, Color color){
        super(filled, color, (new Random().nextInt(100) + 20), x, y);
        side = xSide;
    }

    @Override
    public void draw(Graphics g) {
        if (filled) {
            g.setColor(color); // Color del relleno
            g.fillOval(x, y, side, side); // Dibuja el círculo
        }

        g.setColor(color); // Color del contorno
        g.drawOval(x, y, side, side); // Dibuja el círculo
    }
}
