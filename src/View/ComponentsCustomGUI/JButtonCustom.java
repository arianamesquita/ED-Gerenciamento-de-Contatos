package View.ComponentsCustomGUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class JButtonCustom extends JButton{
    
    private  Color backgroundcolor,clicked,entered;

    public JButtonCustom() {

        setForeground(Color.lightGray);
        setCustomConfig();
    }

    public JButtonCustom(Icon icon) {
        super(icon);

        setForeground(Color.lightGray);
        setCustomConfig();
    }

    public JButtonCustom(String text) {
        super(text);

        setForeground(Color.lightGray);
        setCustomConfig();
    }


    public JButtonCustom(String text, Icon icon) {
        super(text, icon);

        setForeground(Color.lightGray);
        setCustomConfig();
    }

    private void setCustomConfig() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(5,0,5,0));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(getClicked());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(getClicked());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(getBackgroundcolor());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(getEntered());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(getBackgroundcolor());
            }
        });

    }

    public void setColors(Color background,Color entered, Color clicked){
        this.clicked = clicked;
        this.entered=entered;
        this.backgroundcolor=background;
        setBackground(background);
    }


    public Color getClicked() {
        return clicked;
    }

    public Color getEntered() {
        return entered;
    }

    public Color getBackgroundcolor() {
        return backgroundcolor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
        super.paintComponent(g);
    }
    
}
