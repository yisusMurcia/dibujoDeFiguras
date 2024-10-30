import java.awt.*;

// Clase que representa un cuadrado
class Square {
    private int x;
    private int y;
    private int lado;
    private boolean relleno;
    private Color color;

    public Square(int x, int y, int lado, boolean relleno, Color color) {
        this.x = x;
        this.y = y;
        this.lado = lado;
        this.relleno = relleno;
        this.color = color;
    }

    public void draw(Graphics g) {
        if (relleno) {
            g.setColor(color); // Color del relleno
            g.fillRect(x, y, lado, lado); // Dibuja el cuadrado
        }

        g.setColor(Color.BLACK); // Color del contorno
        g.drawRect(x, y, lado, lado); // Dibuja el cuadrado
    }
}