/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.ArrayList;

public class OffSetsMain implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    JFrame frame;
    JPanel display;
    Dude dude;
    Dude dude2;
    ArrayList<Block> blocks;
    int maxX=1000;

    public static void main(String[] args) throws Exception {
        new OffSetsMain();
    }

    public OffSetsMain() {
        frame = new JFrame("Insert Title Here");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here
        dude=new Dude();
        dude2=new Dude();
        blocks=new ArrayList<Block>();
        for (int i = 0; i < 200; i++) {
            blocks.add(new Block((int)(Math.random()*maxX),(int)(Math.random()*500)));
        }
        
        
        //end your constructor code
        timer = new javax.swing.Timer(10, this);
        timer.start();
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //type what needs to be performed every time the timer ticks
        dude.move();dude2.move();
        
        //end your code for timer tick code
        display.repaint();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            dude.setDown(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            dude.setUp(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dude.setRight(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dude.setLeft(true);
        } 
        if (e.getKeyCode() == KeyEvent.VK_S) {
            dude2.setDown(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            dude2.setUp(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            dude2.setRight(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            dude2.setLeft(true);
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            dude.setDown(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            dude.setUp(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dude.setRight(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dude.setLeft(false);
        }if (e.getKeyCode() == KeyEvent.VK_S) {
            dude2.setDown(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            dude2.setUp(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            dude2.setRight(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            dude2.setLeft(false);
        }
    }

    class DisplayPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //draw your graphics here
            int offset=0;
            int leftBoundary=250, rightBoundary=150;
            int furthestX=(int)Math.min(dude.getX(), dude2.getX());
            if(furthestX>leftBoundary)
                offset=(int)furthestX-leftBoundary;
            if(furthestX>maxX-leftBoundary)
                offset-=(furthestX-(maxX-leftBoundary));
            dude.draw(g,offset);dude2.draw(g,offset);
            for (Block block : blocks) {
                block.draw(g, offset);
            }
            
        }
    }
}