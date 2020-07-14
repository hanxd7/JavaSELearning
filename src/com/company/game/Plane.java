package com.company.game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {

    boolean left ,right,up,down;
    int speed = 3;
    boolean live = true;
    @Override
    public void drawSelf(Graphics g) {
        if (live){
            g.drawImage(img,(int)x,(int)y,null);
            if (left){
                x -= this.speed;
            }
            if (right){
                x += this.speed;
            }
            if (up){
                y -= this.speed;
            }
            if (down){
                y += this.speed;
            }
        }else {
//            g.setColor(Color.yellow);
//            g.drawString("Game Over",200,200);
        }

    }

    public Plane(Image img, double x, double y) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);

    }

    /**
     * 按下某个键，增加方向
     * @param e
     */
    public void addDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }
    }
    /**
     * 抬起某个键，取消方向
     * @param e
     */
    public void minusDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
        }
    }
}
