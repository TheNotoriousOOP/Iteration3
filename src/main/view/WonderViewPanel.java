package view;

/**
 * Created by TK on 4/14/17.
 */

import javax.swing.*;
import java.awt.*;

public class WonderViewPanel extends JPanel {

    private Circle[] circles;
    private int NUMCIRCLE = 6;

    public WonderViewPanel(){
        circles = new Circle[NUMCIRCLE];
        for(int i = 0; i < circles.length; i++){
            circles[i] = new Circle(i);
        }
    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g);
        for(int i = 0; i < circles.length; i++){
            drawCircles(circles[i], g2);
        }
    }
    public void drawCircles(Circle circle, Graphics2D g2){
        g2.setColor(Color.blue);
        g2.drawOval(circle.getX(),circle.getY(), 60, 60);
    }
    public void drawRectangles(Rectangle rectangle, Graphics2D g2){
        g2.drawRec
    }
}

class Circle{

    private int x;
    private int y;
    private int OFFSETX = 550;
    private int OFFSETY = 10;

    public Circle(int x){
        this.x = x * 65 + OFFSETX;
        this.y = x + OFFSETY;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}

class Brick{

}


