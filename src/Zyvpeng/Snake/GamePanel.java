package Zyvpeng.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    int length;//蛇的长度
    int []snakeX=new int[600];
    int []snakeY=new int[600];
    String fx;//R:右 L:左  U：上 D：下

    boolean isStart=false;//游戏是否开始

    Timer timer=new Timer(10, this);//定时器

    //定义食物
    int foodx;
    int foody;
    Random random=new Random();


    //death
    boolean isFail=false;

    //score
    int score;
    // 构造器
    GamePanel(){
        init();

        timer.start();
        //获取键盘的监听事件
        this.setFocusable(true);//聚集键盘焦点
        this.addKeyListener(this);//实现监听
    }


    //初始化
    public void init(){
        score=0;
        length=3;
        snakeX[0] =100;snakeY[0]=100;//头部坐标
        snakeX[1]=75;snakeY[1]=100;//第一个身体坐标
        snakeX[2]=50;snakeY[2]=100;//第二个身体坐标
        fx="R";

        foodx=25+25*random.nextInt(34);
        foody=75+25*random.nextInt(24);

    }
    //画板：画界面，画蛇

    //Graphics： 画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏

        this.setBackground(Color.WHITE);//设置背景颜色

        //绘制头部广告栏
//        Data.header.paintIcon(this,g,25,11);

        //绘制游戏区域
        g.fillRect(25,75,850,600);

        //画一条静态的蛇
        if(fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }

        for(int i=1;i<length;i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);//蛇身体的长度
        }

        g.setColor(Color.BLACK);//设置画笔颜色
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度"+length,750,35);
        g.drawString("得分"+score,750,50);



        Data.food.paintIcon(this,g,foodx,foody);


        if(!isStart){
            //画一个文字
            g.setColor(Color.WHITE);//设置画笔颜色
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格启动游戏",300,300);
        }


        //death
        if(isFail){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("游戏失败,按下空格重新开始",300,300);
        }

    }


    //接收键盘的输入：监听
    @Override
    public void keyPressed(KeyEvent e) {
        //键盘按下，未释放

        //获取按下的键盘是哪一个键
        int keyCode=e.getKeyCode();

        if(keyCode==KeyEvent.VK_SPACE) {
            if (isFail) {
                isFail = false;
                init();
            } else {
                //如果按下的是空格键，就取反
                isStart = !isStart;
                //刷新界面操作

            }
            repaint();
        }


        if(keyCode==KeyEvent.VK_LEFT){
            if(!fx.equals("R")) {
                fx = "L";
                repaint();
            }
        }else if(keyCode==KeyEvent.VK_RIGHT){
            if(!fx.equals("L")) {
                fx = "R";
                repaint();
            }
        }else if(keyCode==KeyEvent.VK_UP){

            if(!fx.equals("D")) {
                fx = "U";
                repaint();
            }
        }else if(keyCode==KeyEvent.VK_DOWN){

            if(!fx.equals("U")){
                fx="D";
                repaint();
            }

        }
    }

    //定时器：监听时间流动
    @Override
    public void actionPerformed(ActionEvent e) {
        //如果游戏处于开始状态
        if(isStart&&!isFail){

            for(int i=length-1;i>0;i--){
                snakeX[i]=snakeX[i-1];
                snakeY[i]=snakeY[i-1];
            }
            //通过控制方向让头部移动
            if(fx.equals("R")){
                snakeX[0]+=25;

                if(snakeX[0]>850){
                    snakeX[0]=25;
                }

            }else if(fx.equals("L")){
                snakeX[0]-=25;
                if(snakeX[0]<25){
                    snakeX[0]=850;
                }

            }else if(fx.equals("U")){
                snakeY[0]=snakeY[0]-25;
                if(snakeY[0]<75){
                    snakeY[0]=650;
                }
            }else if(fx.equals("D")){
                snakeY[0]=snakeY[0]+25;
                if(snakeY[0]>650){
                    snakeY[0]=75;
                }
            }


            if(snakeX[0]==foodx&&snakeY[0]==foody){
                //长度加一
                length++;
                score+=10;
                foodx=25+25*random.nextInt(34);
                foody=75+25*random.nextInt(24);
            }

            //
            for(int i=1;i<length;i++){
                if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]){
                    isFail=true;
                }
            }

            //刷新界面
            repaint();

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //释放某个键

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //键盘按下，弹起
    }


}
