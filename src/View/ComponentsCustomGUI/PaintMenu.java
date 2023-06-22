package View.ComponentsCustomGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintMenu extends JPanel{
    private int rounded = 10;
  
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillRoundRect(0, 0, 100, 100, getRounded(), getRounded());
        super.paint(g);
    }

    public int getRounded() {
        return rounded;
    }

    public void setRounded(int rounded) {
        this.rounded = rounded;
    }
    
}
