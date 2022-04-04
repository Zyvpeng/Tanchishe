package Zyvpeng.Snake;

import javax.swing.*;

public class StarGames {
    public static void main(String[] args) {
        // 1.绘制一个静态窗口  JFrame
        JFrame jFrame=new JFrame("贪吃蛇小游戏");

        jFrame.setBounds(10,10,900,720); //设置界面大小
        jFrame.setResizable(false);//大小不可变
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭事件
        jFrame.setVisible(true);//设置可见性

        //2.面板  JPanel  可以加入到JFrame中

        jFrame.add(new GamePanel());



    }
}
