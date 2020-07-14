package com.company.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GameUtil {
    //工具类最好将构造器私有化
    private GameUtil(){

    }

    /**
     * 返回指定路径文件的图片对象
     * @param path
     * @return
     */
    public static Image getImage(String path){
        BufferedImage bi = null;
        try {
            URL resource = GameUtil.class.getClassLoader().getResource(path);
            bi = ImageIO.read(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        return bi;
    }
}
