import java.awt.*;
import java.util.Random;

// Clase que representa un cuadrado
class Square extends Figure{
    private final int side;

    public Square(int x, int y,boolean filled, Color color){
        super(filled, color, (new Random().nextInt(100) + 20), x, y);// Lado aleatorio entre 20 y 119
        side = xSide;
    }

    public void draw(Graphics g) {
        if (filled) {
            g.setColor(color); // Color del relleno
            g.fillRect(x, y, side, side); // Dibuja el cuadrado
        }

        g.setColor(color); // Color del contorno
        g.drawRect(x, y, side, side); // Dibuja el cuadrado
    }

    public int getXSide() {
        return side;
    }

    public int getYSide() {
        return side;
    }

    public int getSide() {
        return side;
    }
}