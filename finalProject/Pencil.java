package finalProject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Pencil extends Shape {
    private ArrayList<Integer> xPoints;
    private ArrayList<Integer> yPoints;

    public Pencil(int x1, int y1, Color color, BasicStroke stroke, boolean filled) {
        super(x1, y1, color, stroke, filled);
        xPoints = new ArrayList<>();
        yPoints = new ArrayList<>();
        xPoints.add(x1);
        yPoints.add(y1);
    }

    public void addPoint(int x, int y) {
        xPoints.add(x);
        yPoints.add(y);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(stroke);
        
        for (int i = 0; i < xPoints.size() - 1; i++) {
            g2d.drawLine(xPoints.get(i), yPoints.get(i), xPoints.get(i + 1), yPoints.get(i + 1));
        }
    }
}
