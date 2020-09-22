
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jbarrett
 */
public class Dude extends Rectangle {

    boolean up, down, left, right, recentJump;

    public Dude() {
        super(200, 200, 15, 30);
        up = down = left = right = false;
    }

    public Rectangle getFoot() {
        return new Rectangle(x, y + height - 1, width, 1);
    }

    public void draw(Graphics g, int offset) {
        g.setColor(Color.BLACK);
        g.drawRect(x - offset, y, width, height);
        g.setColor(Color.red);
        g.fillRect(getFoot().x - offset, getFoot().y, getFoot().width, getFoot().height);
        g.setColor(Color.BLACK);
        g.drawString(("X: "+x+" OffSet: "+offset), x-offset, y);
        
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public void moveDown() {
        y++;
    }

    public void moveUp() {
        y--;
    }

    public void move() {
        if (right) {
            moveRight();
        }
        if (left) {
            moveLeft();
        }

        if (up) {
            moveUp();
        }
        if (down) {
            moveDown();
        }

    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

}
