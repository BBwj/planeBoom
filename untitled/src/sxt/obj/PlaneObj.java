package sxt.obj;

import sxt.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlaneObj extends GameObj  {




    public PlaneObj() {
        super();
    }

    public PlaneObj(Image image, int x, int y, int width, int height, double speed, GameWin gameWin) {
        super(image, x, y, width, height, speed, gameWin);
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                PlaneObj.super.x=e.getX()-11;
                PlaneObj.super.y=e.getY()-16;

            }
        });

    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if(this.frame.bossObj!=null&&this.getRec().intersects(this.frame.bossObj.getRec())){
            GameWin.state=3;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}


