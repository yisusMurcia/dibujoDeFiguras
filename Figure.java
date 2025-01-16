import java.awt.*;

abstract class Figure{
    protected final boolean filled;
    protected final Color color;
    protected final int xSide;
    protected final int ySide;
    protected int x;
    protected int y;
    
    public Figure(Boolean filled, Color color, int xSide, int ySide,  int x, int y) {
        this.filled = filled;
        this.color = color;
        this.xSide = xSide;
        this.ySide = ySide;
        this.x = x;
        this.y = y;
    }

    public Figure(Boolean filled, Color color, int side,  int x, int y) {
        this.filled = filled;
        this.color = color;
        this.xSide = side;
        this.ySide = side;
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics g);

    public boolean inPosition(int x, int y){//Return true if x and y are into the square
        return (this.x <= x && x <= (this.x + xSide) && this.y <= y && y <= (this.y + ySide));
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

    public int getXSide() {
        return xSide;
    }

    public int getYSide() {
        return ySide;
    }
}
