import java.awt.*;

// Clase que representa un cuadrado
class Square extends Figure{
    private final int side;

    public Square(int x, int y, int side, boolean filled, Color color) {
        super(filled, color, side, side, x, y);
        this.side = side;
    }

    public void draw(Graphics g) {
        if (filled) {
            g.setColor(color); // Color del relleno
            g.fillRect(x, y, xSide, xSide); // Dibuja el cuadrado
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