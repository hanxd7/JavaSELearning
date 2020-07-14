package com.company.game;

import java.awt.*;

public class Explode {
    double x,y;

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //频繁使用的爆炸资源，只new一次
    static Image[] imgs = new Image[16];
    static {
        for (int i=0;i<16;i++){
            imgs[i] = GameUtil.getImage("images/explode/e"+(i+1)+".gif");
            imgs[i].getWidth(null);
        }
    }
    int count;
    public void draw(Graphics g){
        if (count<=15){
            g.drawImage(imgs[count],(int)x,(int)y,null);
            count++;
        }
    }
}
