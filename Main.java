package finalProject;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        MyPanel panel = new MyPanel();
        
        panel.setBackground(Color.WHITE);
        
        frame.setContentPane(panel);
        frame.setTitle("Hello Java");
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
