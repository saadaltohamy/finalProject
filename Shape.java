package finalProject;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.BasicStroke;

public abstract class Shape {
    Color color;
    int x1;
    int y1;
    int x2;
    int y2;
    BasicStroke stroke;
    boolean filled;

    public Shape(int x1, int y1, Color color, BasicStroke stroke, boolean filled) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1;
        this.y2 = y1;
        this.color = color;
        this.stroke = stroke;
        this.filled = filled;
    }
    public abstract void draw(Graphics g);
}
