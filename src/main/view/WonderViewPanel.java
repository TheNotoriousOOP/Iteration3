package view;

/**
 * Created by TK on 4/14/17.
 */

import javax.swing.*;
import java.awt.*;

public class WonderViewPanel extends JPanel {

    private Circle[] prayCircles = new Circle[6];
    private Brick[][] topBrickRow = new Brick[3][7];
    private Brick[][] secondBrickRow = new Brick[5][6];
    private Brick[][] thirdBrickRow = new Brick[4][5];
    private Brick[][] bottomBrickRow = new Brick[3][4];

    private int topBrickXOffSet = 515;
    private int topBrickYOffSet = 100;
    private int secondBrickXOffSet = 547;
    private int secondBrickYOffSet = 185;
    private int thirdBrickXOffSet = 579;
    private int thirdBrickYOffSet = 326;
    private int bottomBrickXOffSet = 612;
    private int bottomBrickYOffSet = 438;

    public WonderViewPanel(){
        for(int i = 0; i < prayCircles.length; i++){
            prayCircles[i] = new Circle(i);
        }
        for(int i = 0; i < topBrickRow.length; i++){
            for(int j = 0; j < topBrickRow[i].length; j++) {
                topBrickRow[i][j] = new Brick(i, j, topBrickXOffSet, topBrickYOffSet);
            }
        }
        for(int i = 0; i < secondBrickRow.length; i++){
            for(int j = 0; j < secondBrickRow[i].length; j++) {
                secondBrickRow[i][j] = new Brick(i, j, secondBrickXOffSet, secondBrickYOffSet);
            }
        }
        for(int i = 0; i < thirdBrickRow.length; i++){
            for(int j = 0; j < thirdBrickRow[i].length; j++) {
                thirdBrickRow[i][j] = new Brick(i, j, thirdBrickXOffSet, thirdBrickYOffSet);
            }
        }
        for(int i = 0; i < bottomBrickRow.length; i++){
            for(int j = 0; j < 4; j++) {
                bottomBrickRow[i][j] = new Brick(i, j, bottomBrickXOffSet, bottomBrickYOffSet);
            }
        }
    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g);
        for(int i = 0; i < prayCircles.length; i++){
            drawCircles(prayCircles[i], g2);
        }
        for(int i = 0; i < topBrickRow.length; i++){
            for(int j = 0; j < topBrickRow[i].length; j++){
                drawTopBrickRow(topBrickRow[i][j], g2);
            }
        }
        for(int i = 0; i < secondBrickRow.length; i++){
            for(int j = 0; j < secondBrickRow[i].length; j++){
                drawSecondBrickRow(secondBrickRow[i][j], g2);
            }
        }
        for(int i = 0; i < thirdBrickRow.length; i++){
            for(int j = 0; j < thirdBrickRow[i].length; j++){
                drawThirdBrickRow(thirdBrickRow[i][j], g2);
            }
        }
        for(int i = 0; i < bottomBrickRow.length; i++){
            for(int j = 0; j < bottomBrickRow[i].length; j++){
                drawBottomBrickRow(bottomBrickRow[i][j], g2);
            }
        }
    }
    public void drawCircles(Circle circle, Graphics2D g2){
        g2.setColor(Color.blue);
        g2.drawOval(circle.getX(),circle.getY(), 60, 60);
    }
    public void drawTopBrickRow(Brick brick, Graphics2D g2){
        g2.setColor(Color.darkGray);
        g2.drawRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
    }
    public void drawSecondBrickRow(Brick brick, Graphics2D g2){
        g2.setColor(Color.darkGray);
        g2.drawRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
    }
    public void drawThirdBrickRow(Brick brick, Graphics2D g2){
        g2.setColor(Color.darkGray);
        g2.drawRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
    }
    public void drawBottomBrickRow(Brick brick, Graphics2D g2){
        g2.setColor(Color.darkGray);
        g2.drawRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
    }
}

class Circle{

    private int x;
    private int y;
    private int OFFSETX = 514;
    private int OFFSETY = 20;

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
    private int x;
    private int y;
    private int height = 25;
    private int width = 60;

    public Brick(int i, int j, int topBrickXOffSet, int topBrickYOffSet){

        this.x = j * 65 + topBrickXOffSet;
        this.y = i * 28 + topBrickYOffSet;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
}


