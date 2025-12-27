package finalProject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends Shape {
    public Rectangle(int x1, int y1, Color color, BasicStroke stroke, boolean filled) {
        super(x1, y1, color, stroke, filled);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(stroke);
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        if (filled) {
            g2d.fillRect(x, y, width, height);
            return;
        }
        else {
            g2d.drawRect(x, y, width, height);
        }
        
    }
    
}
