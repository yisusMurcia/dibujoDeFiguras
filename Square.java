import java.awt.*;

// Clase que representa un cuadrado
class Square {
    private int x;
    private int y;
    private final int lado;
    private final boolean relleno;
    private final Color color;

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

        g.setColor(color); // Color del contorno
        g.drawRect(x, y, lado, lado); // Dibuja el cuadrado
    }

    public boolean inPosition(int x, int y){//Return true if x and y are into the square
        return (this.x <= x && x <= (this.x + lado) && this.y <= y && y <= (this.y + lado));
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLado() {
        return lado;
    }
}