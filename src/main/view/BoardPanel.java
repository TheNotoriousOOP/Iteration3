package view;

import model.map.CubeVector;
import model.map.tile.Tile;
import view.assets.AssetLoader;
import view.renderer.MapRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 * Responsibilities:
 */
public class BoardPanel extends JPanel{

    private int boardSize = 21;
    private Tile[][] board = new Tile[boardSize][boardSize];
    private int hexSize = 50;
    private int borderSize = 10;

    private int s = 0;
    private int t = 0;
    private int r = 0;
    private int h = 0;

    private int x = 0;
    private int y = 0;

    private MapRenderer mapRenderer;

    public BoardPanel(AssetLoader assetLoader){
        Dimension mapDimension = new Dimension(1200, 1100);
        this.setPreferredSize(mapDimension);
        this.setBackground(Color.black);
        requestFocusInWindow();
        setFocusable(true);
        setHeight();

        //board is auto-init to null

        //Renderer?
        mapRenderer = new MapRenderer(this, assetLoader);
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
                board[i][j].render(mapRenderer);
                String x = Integer.toString(i);
                String y = Integer.toString(j);
                String xy = x + "," + y;
                fillHex(i,j,xy,g2);
            }
        }

        int h = hexSize;
        int r = h/2;
        int s = (int) (h / 1.73205);
        int t = (int) (r / 1.73205);
        int i = x * (s+t);
        int j = y * h + (x%2) * h/2;

        Polygon poly = hex(i,j);
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(10));
        g2.setColor(Color.yellow);
        g2.drawPolygon(poly);
        g2.setStroke(oldStroke);

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

    public void updateBoard(Tile[][] boardFromMap) {
        this.board = boardFromMap;
    }

    public void highlightNorthWest(){
        if(x % 2 == 0 || x == 0){
            x = (x-1 < 0)? boardSize-1 : x-1;
            y = (y-1 < 0)? boardSize-1 : y-1;
        } else {
            x = (x-1 < 0)? boardSize-1 : x-1;
        }
        repaint();
    }
    public void hightlightNorth(){
        y = (y-1 < 0)? boardSize-1 : y-1;
        repaint();
    }
    public void hightlightNorthEast(){
        if(x % 2 == 0 || x == 0){
            x = (x+1) % boardSize;
            y = (y-1 < 0)? boardSize-1 : y-1;
        } else{
            x = (x+1) % boardSize;
        }
        repaint();
    }
    public void highlightSouthWest(){
        if(x % 2 == 1 || x == 0) {
            y = (y+1) % boardSize;
            x = (x - 1 < 0) ? boardSize - 1 : x - 1;
        } else{
            x = (x - 1 < 0) ? boardSize - 1 : x - 1;
        }
        repaint();
    }
    public void highlightSouth(){
        y = (y+1) % boardSize;
        repaint();
    }
    public void highlightSouthEast(){
        if(x % 2 == 1 || x == 0) {
            y = (y+1) % boardSize;
            x = (x+1) % boardSize;
        } else {
            x = (x + 1) % boardSize;
        }
        repaint();
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public void drawTile(Point locationAsPoint, BufferedImage tile) {
        //TODO implement
        
    }
}
