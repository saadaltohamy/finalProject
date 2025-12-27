package finalProject;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    ArrayList<Shape> shapes;
    Color currentColor = Color.BLACK;
    BasicStroke currentStroke = new BasicStroke(2);
    String currentShape;
    JCheckBox solidCheckBox;
    JCheckBox dottedCheckBox;
    JCheckBox fillCheckBox;
    boolean filled;

    // Keep track of shape buttons
    JButton lineBtn, rectBtn, ovalBtn, pencilBtn, eraserBtn;
    JButton blackBtn, redBtn, greenBtn, blueBtn;

    public MyPanel() {
        setLayout(null);
        addMouseListener(new myMouseListener());
        addMouseMotionListener(new myMouseListener());
        setFocusable(true);
        shapes = new ArrayList<>();

        // Functions Label
        JLabel functionsLabel = new JLabel("Functions:");
        functionsLabel.setBounds(10, 10, 80, 30);
        functionsLabel.setFont(new Font("Arial", Font.BOLD, 12));
        this.add(functionsLabel);

        // Function Buttons
        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(90, 10, 80, 30);
        clearBtn.setBackground(Color.LIGHT_GRAY);
        clearBtn.addActionListener(e -> {
            shapes.clear();
            repaint();
        });
        this.add(clearBtn);

        JButton undoBtn = new JButton("Undo");
        undoBtn.setBounds(180, 10, 80, 30);
        undoBtn.setBackground(Color.LIGHT_GRAY);
        undoBtn.addActionListener(e -> {
            if (!shapes.isEmpty()) {
                shapes.remove(shapes.size() - 1);
                repaint();
            }
        });
        this.add(undoBtn);

        // Paint Mode Label
        JLabel paintModeLabel = new JLabel("Paint Mode:");
        paintModeLabel.setBounds(270, 10, 90, 30);
        paintModeLabel.setFont(new Font("Arial", Font.BOLD, 12));
        this.add(paintModeLabel);

        // Shape Buttons
        lineBtn = new JButton("Line");
        lineBtn.setBounds(370, 10, 90, 30);
        lineBtn.setBackground(Color.LIGHT_GRAY);
        lineBtn.addActionListener(e -> {
            currentShape = "Line";
            setActiveShapeButton(lineBtn);
        });
        this.add(lineBtn);

        rectBtn = new JButton("Rectangle");
        rectBtn.setBounds(470, 10, 100, 30);
        rectBtn.setBackground(Color.LIGHT_GRAY);
        rectBtn.addActionListener(e -> {
            currentShape = "Rectangle";
            setActiveShapeButton(rectBtn);
        });
        this.add(rectBtn);

        ovalBtn = new JButton("Oval");
        ovalBtn.setBounds(580, 10, 80, 30);
        ovalBtn.setBackground(Color.LIGHT_GRAY);
        ovalBtn.addActionListener(e -> {
            currentShape = "Oval";
            setActiveShapeButton(ovalBtn);
        });
        this.add(ovalBtn);

        pencilBtn = new JButton("Pencil");
        pencilBtn.setBounds(670, 10, 80, 30);
        pencilBtn.setBackground(Color.LIGHT_GRAY);
        pencilBtn.addActionListener(e -> {
            currentShape = "Pencil";
            setActiveShapeButton(pencilBtn);
        });
        this.add(pencilBtn);

        eraserBtn = new JButton("Eraser");
        eraserBtn.setBounds(760, 10, 80, 30);
        eraserBtn.setBackground(Color.LIGHT_GRAY);
        eraserBtn.addActionListener(e -> {
            currentShape = "Eraser";
            currentColor = Color.WHITE;
            setActiveShapeButton(eraserBtn);
        });
        this.add(eraserBtn);

        // Stroke Style Checkboxes

        // Fill Checkbox (add this new checkbox)
        fillCheckBox = new JCheckBox("Fill");
        fillCheckBox.setBounds(850, 10, 70, 30);
        fillCheckBox.setSelected(false);
        fillCheckBox.addActionListener(e -> {
            filled = fillCheckBox.isSelected();
            if (fillCheckBox.isSelected()) {
                dottedCheckBox.setSelected(false);
            }
            else {
                currentStroke = new BasicStroke(2);
                filled = false;
            }
        });
        this.add(fillCheckBox);

        // Dotted Checkbox
        dottedCheckBox = new JCheckBox("Dotted");
        dottedCheckBox.setBounds(930, 10, 80, 30);
        dottedCheckBox.addActionListener(e -> {
            if (dottedCheckBox.isSelected()) {
                // solidCheckBox.setSelected(false);
                fillCheckBox.setSelected(false);
                filled = false;
                currentStroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0);
            }
        });
        this.add(dottedCheckBox);


        // Colors Label (adjust position)
        JLabel colorsLabel = new JLabel("Colors:");
        colorsLabel.setBounds(1090, 10, 60, 30);
        colorsLabel.setFont(new Font("Arial", Font.BOLD, 12));
        this.add(colorsLabel);

        // Color Buttons (adjust positions)
        blackBtn = new JButton();
        blackBtn.setBounds(1160, 10, 40, 30);
        blackBtn.setBackground(Color.BLACK);
        blackBtn.addActionListener(e -> {
            currentColor = Color.BLACK;
            setActiveColorButton(blackBtn);
        });
        this.add(blackBtn);

        redBtn = new JButton();
        redBtn.setBounds(1210, 10, 40, 30);
        redBtn.setBackground(Color.RED);
        redBtn.addActionListener(e -> {
            currentColor = Color.RED;
            setActiveColorButton(redBtn);
        });
        this.add(redBtn);

        greenBtn = new JButton();
        greenBtn.setBounds(1260, 10, 40, 30);
        greenBtn.setBackground(Color.GREEN);
        greenBtn.addActionListener(e -> {
            currentColor = Color.GREEN;
            setActiveColorButton(greenBtn);
        });
        this.add(greenBtn);

        blueBtn = new JButton();
        blueBtn.setBounds(1310, 10, 40, 30);
        blueBtn.setBackground(Color.BLUE);
        blueBtn.addActionListener(e -> {
            currentColor = Color.BLUE;
            setActiveColorButton(blueBtn);
        });
        this.add(blueBtn);

        // Set initial active state
        setActiveColorButton(blackBtn);
    }

    private void setActiveShapeButton(JButton activeButton) {
        // Reset all shape buttons
        lineBtn.setBorder(BorderFactory.createEmptyBorder());
        rectBtn.setBorder(BorderFactory.createEmptyBorder());
        ovalBtn.setBorder(BorderFactory.createEmptyBorder());
        pencilBtn.setBorder(BorderFactory.createEmptyBorder());
        eraserBtn.setBorder(BorderFactory.createEmptyBorder());

        // Highlight the active button
        activeButton.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
    }

    private void setActiveColorButton(JButton activeButton) {
        // Reset all color buttons
        blackBtn.setBorder(BorderFactory.createEmptyBorder());
        redBtn.setBorder(BorderFactory.createEmptyBorder());
        greenBtn.setBorder(BorderFactory.createEmptyBorder());
        blueBtn.setBorder(BorderFactory.createEmptyBorder());

        // Highlight the active button
        activeButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Shape l : shapes) {
            l.draw(g);
        }
    }

    public class myMouseListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if (currentShape == null)
                return;
            switch (currentShape) {
                case "Line":
                    shapes.add(new Line(e.getX(), e.getY(), currentColor, currentStroke, filled));
                    break;

                case "Rectangle":
                    shapes.add(new Rectangle(e.getX(), e.getY(), currentColor, currentStroke, filled));
                    break;
                case "Oval":
                    shapes.add(new Oval(e.getX(), e.getY(), currentColor, currentStroke, filled));
                    break;
                case "Pencil":
                    shapes.add(new Pencil(e.getX(), e.getY(), currentColor, currentStroke, filled));
                    break;
                case "Eraser":
                    shapes.add(new Pencil(e.getX(), e.getY(), Color.WHITE, currentStroke, filled));
                    break;
                default:
                    break;
            }
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (currentShape == null)
                return;
            Shape lastShape = shapes.get(shapes.size() - 1);

            if (currentShape.equals("Pencil") || currentShape.equals("Eraser")) {
                ((Pencil) lastShape).addPoint(e.getX(), e.getY());
            } else {
                lastShape.x2 = e.getX();
                lastShape.y2 = e.getY();
            }

            repaint();
        }
    }
}
