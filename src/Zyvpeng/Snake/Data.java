package Zyvpeng.Snake;

import javax.swing.*;
import java.net.URI;
import java.net.URL;

// 存放外部数据   URL定位图片地址    ImageIcon 图片
public class Data {

    public static URL downurl=Data.class.getResource("/statics/down.png");
    public static URL foodurl=Data.class.getResource("/statics/food.png");
    public static URL bodyurl=Data.class.getResource("/statics/body.png");
    public static URL lefturl=Data.class.getResource("/statics/left.png");
    public static URL righturl=Data.class.getResource("/statics/right.png");
    public static URL upurl=Data.class.getResource("/statics/up.png");




    public static ImageIcon body=new ImageIcon(bodyurl);
    public static ImageIcon down=new ImageIcon(downurl);
    public static ImageIcon food=new ImageIcon(foodurl);
    public static ImageIcon left=new ImageIcon(lefturl);
    public static ImageIcon right=new ImageIcon(righturl);
    public static ImageIcon up=new ImageIcon(upurl);




}
