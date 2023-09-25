package sxt;

import sxt.obj.*;
import sxt.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame  {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        GameWin gameWin=new GameWin();

    }
  public   static int state=0;
    Image offScreenImage = null;
    BgObj bgObj=new BgObj(GameUtils.bgImg,0,-2000,2);
   public PlaneObj planeObj=new PlaneObj(GameUtils.planeImg,290,550,20,30,0,this);
   public BossObj bossObj=null;
   int count=1;
   public static int score=0;
   int enemyCount=0;


    public GameWin() throws InterruptedException {

            this.setSize(600, 600);//窗口大小
            this.setLocationRelativeTo(null);//是否剧中
            this.setVisible(true);//是否可见
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭选项
            this.setResizable(false);//不可变
            GameUtils.gameObjList.add(bgObj);
            GameUtils.gameObjList.add(planeObj);

            this.setTitle("冲击波");
       /*鼠标点击*/     this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getButton()==1&&state==0){
                        state=1;
                        repaint();

                    }
                }
            });

       this.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e) {
              if(e.getKeyCode()==32){
                  switch (state){
                      case 1:state=2;
                      break;
                      case 2:state=1;
                      default:
                  }
              }
           }
       });

       while(true){
           if(state==1){
               createObj();
               repaint();

           }

           Thread.sleep(25);
       }
        }


    @Override
    public void paint(Graphics g) {
        if(offScreenImage==null){
            offScreenImage=createImage(600,600);
        }
        Graphics gImage=offScreenImage.getGraphics();
        gImage.fillRect(0,0,600,600);
        if (state == 0) {
            gImage.drawImage(GameUtils.bgImg,0,0,null);
            gImage.drawImage(GameUtils.explodeImg,270,350,null);
            gImage.drawImage(GameUtils.planeImg,280,470,null);
            gImage.drawImage(GameUtils.bossImg,220,120,null);
             GameUtils.drawWord(gImage,"开始",Color.yellow,40,280,300);
     //开始文字

    }
        if (state == 1) {
            GameUtils.gameObjList.addAll(GameUtils.explodeObList);

          for(int i=0;i<GameUtils.gameObjList.size();i++){
              GameUtils.gameObjList.get(i).paintSelf(gImage);
          }
           GameUtils.gameObjList.removeAll(GameUtils.removeList);
        }
        if (state == 3) {
            gImage.drawImage(GameUtils.explodeImg,planeObj.getX()-35,planeObj.getY()-50,null);

            //开始文字
            GameUtils.drawWord(gImage,"冲击波",Color.yellow,40,280,300);
        }
        if (state == 4) {
            gImage.drawImage(GameUtils.explodeImg,bossObj.getX()+30,bossObj.getY(),null);

            //开始文字
            GameUtils.drawWord(gImage,"拿下",Color.yellow,40,280,300);
        }
        GameUtils.drawWord(gImage,score+"分数",Color.cyan,40,30,100);
        g.drawImage(offScreenImage,0,0,null);
        count++;

    }
    void createObj() {
        if (count % 15 == 0) {
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, planeObj.getX() + 3, planeObj.getY() - 16, 14, 29, 5, this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
        }
        if (count % 15 == 0) {
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg,(int)(Math.random()*12)*50,0,49,39,5,this));
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size()-1));
            enemyCount++;
        }
        if (count % 15 == 0&&bossObj!=null) {
            GameUtils.bulletList.add((new BulletObj(GameUtils.bulletImg,bossObj.getX()+76,bossObj.getY()+85,15,25,5,this)));
            GameUtils.gameObjList.add(GameUtils.bulletList.get((GameUtils.bulletList.size()-1)));




        }
        if(enemyCount>20&&bossObj==null){
            bossObj=new BossObj(GameUtils.bossImg,250,35,155,100,5,this);
            GameUtils.gameObjList.add(bossObj);
        }

    }



}
