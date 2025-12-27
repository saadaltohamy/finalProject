package finalProject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Shape {
    public Line(int x1, int y1, Color color, BasicStroke stroke, boolean filled) {
        super(x1, y1, color, stroke, filled);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(stroke);
        g2d.drawLine(x1, y1, x2, y2);
    }
    
}
