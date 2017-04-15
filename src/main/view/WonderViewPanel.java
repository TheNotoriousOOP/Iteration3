package view;

/**
 * Created by TK on 4/14/17.
 */

import view.assets.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WonderViewPanel extends JPanel {

    private java.util.List<PanelObserver> observers = new ArrayList<PanelObserver>();

    private Circle[] prayCircles = new Circle[6];
    private Brick[][] topBrickRow = new Brick[3][7];
    private Brick[][] secondBrickRow = new Brick[5][6];
    private Brick[][] thirdBrickRow = new Brick[4][5];
    private Brick[][] bottomBrickRow = new Brick[3][4];
    private Phase[] phaseRow = new Phase[4];
    private Circle[] sequenceChart = new Circle[6];

    private int prayCircleXOffSet = 514;
    private int prayCircleYOffSet = 20;
    private int prayCircleXGap = 65;

    private int topBrickXOffSet = 515;
    private int topBrickYOffSet = 100;
    private int secondBrickXOffSet = 547;
    private int secondBrickYOffSet = 185;
    private int thirdBrickXOffSet = 579;
    private int thirdBrickYOffSet = 326;
    private int bottomBrickXOffSet = 612;
    private int bottomBrickYOffSet = 438;


    private int phaseRowXOffSet = 600;
    private int phaseRowYOffSet = 550;

    private int sequenceChartXOffSet = 436;
    private int sequenceChartYOffSet = 630;
    private int sequenceChartXGap = 105;

    private int brickColumn = 0;
    private int brickRow = bottomBrickRow.length-1;

    private Icon templeIcon;
    public WonderViewPanel(AssetLoader assets){

        templeIcon = new ImageIcon(assets.getImage("TEMPLE"));

        for(int i = 0; i < prayCircles.length; i++){
            prayCircles[i] = new Circle(i, prayCircleXGap, prayCircleXOffSet, prayCircleYOffSet);
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
        for(int i = 0; i < phaseRow.length; i++){
            phaseRow[i] = new Phase(i, phaseRowXOffSet, phaseRowYOffSet);
        }
        for(int i = 0; i < sequenceChart.length; i++){
            sequenceChart[i] = new Circle(i, sequenceChartXGap, sequenceChartXOffSet, sequenceChartYOffSet);
        }
        this.setLayout(new GridBagLayout());
        JPanel sidePanel = new JPanel(new GridLayout());
        JButton addBrick = new JButton("Add brick");
        JButton backToGame = new JButton("Back to Game");
        backToGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyAllObservers("GameViewPanel");
            }
        });
        sidePanel.add(addBrick);
        sidePanel.add(backToGame);
        addBrick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bottomBrickRow[brickRow][brickColumn].setColor(Color.red);
                brickColumn++;
                repaint();
                if(brickColumn == bottomBrickRow[brickRow].length) {
                    brickRow--;
                    brickColumn = 0;
                }
            }
        });
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_END;
        c.weightx = 1;
        c.weighty = 1;
        this.add(sidePanel, c);

    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g);
        templeIcon.paintIcon(this, g2, 905, 20);
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
        for(int i = 0; i < phaseRow.length; i++){
            drawPhaseRow(phaseRow[i], g2);
        }
        for(int i = 0; i < sequenceChart.length; i++){
            drawCircles(sequenceChart[i], g2);
        }
    }
    public void drawCircles(Circle circle, Graphics2D g2){
        g2.setColor(Color.blue);
        g2.drawOval(circle.getX(),circle.getY(), 60, 60);
    }
    public void drawTopBrickRow(Brick brick, Graphics2D g2){
        g2.setColor(brick.getColor());
        g2.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
    }
    public void drawSecondBrickRow(Brick brick, Graphics2D g2){
        g2.setColor(brick.getColor());
        g2.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
    }
    public void drawThirdBrickRow(Brick brick, Graphics2D g2){
        g2.setColor(brick.getColor());
        g2.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
    }
    public void drawBottomBrickRow(Brick brick, Graphics2D g2){
        g2.setColor(brick.getColor());
        g2.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
    }
    public void drawPhaseRow(Phase phase, Graphics2D g2){
        g2.setColor(Color.darkGray);
        g2.drawRect(phase.getX(), phase.getY(), phase.getWidth(), phase.getHeight());
    }

    public void attach(PanelObserver observer){
        observers.add(observer);
    }
    public void notifyAllObservers(String panelName){
        for(PanelObserver observer : observers){
            observer.update(panelName);
        }
    }
}

class Circle{

    private int x;
    private int y;

    public Circle(int i, int xGap, int circleXOffSet, int circleYOffSet){
        this.x = i * xGap + circleXOffSet;
        this.y = i + circleYOffSet;
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
    private Color defaultBrown = new Color(156, 93, 82);
    private Color brickColor;
    public Brick(int i, int j, int brickXOffSet, int brickYOffSet){
        this.x = j * 65 + brickXOffSet;
        this.y = i * 28 + brickYOffSet;
        this.brickColor = defaultBrown;
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
    public Color getColor(){
        return this.brickColor;
    }
    public void setColor(Color color){
        this.brickColor = color;
    }
}

class Phase{
    private int x;
    private int y;
    private int height = 45;
    private int width = 60;

    public Phase(int i, int phaseXOffSet, int phaseYOffSet){

        this.x = i * 65 + phaseXOffSet;
        this.y = phaseYOffSet;
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
