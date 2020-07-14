package com.company.game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

/**
 * 飞机游戏的主窗口
 * @author hxd
 */
public class MyGameFrame extends JFrame {

    Image bg = GameUtil.getImage("images/bg.jpg");
    Image planeImg = GameUtil.getImage("images/plane.png");
    Plane plane = new Plane(planeImg,250,250);
    Shell shell = new Shell();
    Shell[] shells = new Shell[50];
    Explode bang;
    Date startTime = new Date();
    Date endTime;
    int period;//游戏持续时间

    /**
     * 初始化窗口
     */
    public void launchFrame(){
        this.setTitle("躲避球");

        this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        this.setLocation(300,300);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
        new PaintThread().start();//启动重画窗口的线程
        addKeyListener(new KeyMonitor());//给窗口增加键盘的监听

        //初始化50个炮弹
        for(int i=0;i<shells.length;i++){
            shells[i]= new Shell();
        }
    }

    @Override
    public void paint(Graphics g) { //自动被调用
        Color color = g.getColor();
//        Font font = g.getFont();
//        g.setColor(Color.blue);
//        g.drawLine(100,100,300,300);
//        g.drawRect(100,100,300,300);
//        g.drawOval(100,100,300,300);
//        g.setColor(Color.red);
//        g.fillRect(100,100,40,40);
//        g.setFont(new Font("楷体",Font.BOLD,50));
//        g.drawString("我试试",200,200);
//        g.drawImage(sky,0,0,null);
//        g.setFont(font);
//        g.setColor(color);
        g.drawImage(bg,0,0,null);
        plane.drawSelf(g);//画飞机
        //shell.draw(g);//画炮弹
        for (Shell s:shells){
            s.draw(g);
            boolean peng = s.getRect().intersects(plane.getRect());
            if (peng){
                plane.live = false;
                if (bang == null){
                    bang = new Explode(plane.x,plane.y);

                    endTime = new Date();
                    period =  (int)(endTime.getTime()-startTime.getTime())/1000;
                }

                bang.draw(g);
            }
            if(!plane.live){
                Font f = new Font("楷体",Font.BOLD,50);
                g.setFont(f);
                g.setColor(Color.yellow);
                g.drawString("时间："+period+"秒",(int)plane.x,(int)plane.y);
            }
        }
        g.setColor(color);

    }

    /**
     * 内部类反复重画窗口
     *
     */
    class PaintThread extends Thread{
        @Override
        public void run() {
            while (true){
                //System.out.println("窗口重画");
                repaint(); //重画

                try {
                    Thread.sleep(40); //1s=1000ms 1000/40=25 人眼刷新率每秒24张图片
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 定义键盘监听的内部类
     */
    class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);
        }
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
    private Image offScreenImage = null;
    public void update(Graphics g){
        if (offScreenImage == null){
            offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
            Graphics gOff = offScreenImage.getGraphics();
            paint(gOff);
            g.drawImage(offScreenImage,0,0,null);

        }
    }
}
