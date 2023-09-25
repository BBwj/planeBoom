package sxt.utils;

import sxt.obj.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    public static Image bgImg= Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
    public static Image bossImg= Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
    public static Image explodeImg= Toolkit.getDefaultToolkit().getImage("imgs/explode/e2.gif");
    public static Image planeImg= Toolkit.getDefaultToolkit().getImage("imgs/plane.png");
    public static Image shellImg = Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
    public static Image  bulletImg = Toolkit.getDefaultToolkit().getImage("imgs/bullet.png");
    public static Image  enemyImg = Toolkit.getDefaultToolkit().getImage("imgs/enemy.png");
    public static List<ShellObj> shellObjList=new ArrayList<>();
    public static List<GameObj> gameObjList=new ArrayList<>();
    public static List<EnemyObj> enemyObjList=new ArrayList<>();
    public static List<GameObj> removeList =new ArrayList<>();
    public static List<BulletObj>  bulletList =new ArrayList<>();
    public static List<ExplodeObj>  explodeObList =new ArrayList<>();
    public static  void  drawWord(Graphics gImage,String str,Color color,int size,int x,int y){
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋",Font.BOLD,size));
       gImage.drawString(str,x,y);

    }
}
