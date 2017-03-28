package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 * Responsibilities:
 */
public class BoardPanel extends JPanel{

    private int boardSize = 21;
    private int[][] board = new int[boardSize][boardSize];
    private int hexSize = 50;
    private int borderSize = 10;

    private int s = 0;
    private int t = 0;
    private int r = 0;
    private int h = 0;
    public BoardPanel(){
        Dimension mapDimension = new Dimension(1200, 1100);
        this.setPreferredSize(mapDimension);
        this.setBackground(Color.black);
        requestFocusInWindow();
        setFocusable(true);
        setHeight();
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                board[i][j] = 0;
            }
        }
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        super.paintComponent(g2);
        //draw grid
        for (int i=0;i<boardSize;i++) {
            for (int j=0;j<boardSize;j++) {
                drawHex(i,j,g2);
            }
        }
        //fill in hexes
        for (int i=0;i<boardSize;i++) {
            for (int j=0;j<boardSize;j++) {
                String x = Integer.toString(i);
                String y = Integer.toString(j);
                String xy = x + "," + y;
                fillHex(i,j,xy,g2);
            }
        }
        g2.translate(200,200);
    }
    private void setHeight(){
        h = hexSize;
        r = h / 2;
        s = (int) (h / 1.73205);
        t = (int) (r / 1.73205);
    }
    public Polygon hex (int x0, int y0) {

        int y = y0 + borderSize;
        int x = x0 + borderSize;

        int[] cx,cy;

        cx = new int[] {x+t,x+s+t,x+s+t+t,x+s+t,x+t,x};
        cy = new int[] {y,y,y+r,y+r+r,y+r+r,y+r};

        return new Polygon(cx,cy,6);
    }
    public void drawHex(int i, int j, Graphics2D g2) {
        int x = i * (s+t);
        int y = j * h + (i%2) * h/2;
        Polygon poly = hex(x,y);
        g2.setColor(Color.blue);
        g2.fillPolygon(poly);
        g2.setColor(Color.orange);
        g2.drawPolygon(poly);
    }
    public void fillHex(int i, int j, String xy, Graphics2D g2) {
        int x = i * (s+t);
        int y = j * h + (i%2) * h/2;
        g2.drawString(xy, x+r+borderSize-10, y+r+borderSize+4);
    }
}
