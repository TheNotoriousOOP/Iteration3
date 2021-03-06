package view;

import model.map.CubeVector;
import model.map.tile.Tile;
import model.transporters.Transporter;
import view.assets.AssetLoader;
import view.renderer.MapRenderer;
import view.renderer.NodeOffset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

/**
 * Created by TheNotoriousOOP on 3/26/2017.
 * Class Description:
 * Responsibilities:
 */
public class BoardPanel extends JPanel{

    private int boardSize = 21;
    private Tile[][] board = new Tile[boardSize][boardSize];
    private ArrayList<Transporter> transporters = new ArrayList<>();
    private BufferedImage[][] imageBoard = new BufferedImage[boardSize][boardSize];
    private BufferedImage[][] riverBoard = new BufferedImage[boardSize][boardSize];

    private NodeOffset[][] nodeBoard = new NodeOffset[boardSize][boardSize];

    private boolean started = true;
    private int hexSize = 120;
    private int borderSize = 5;
    private int s = 0;
    private int t = 0;
    private int r = 0;
    private int h = 0;

    private int x = 0;
    private int y = 0;

    private MapRenderer mapRenderer;
    private AssetLoader assetLoader;

    private double scale = 1;
    private int cameraX = 0;
    private int cameraY = 0;

    public BoardPanel(AssetLoader assetLoader){
        Dimension mapDimension = new Dimension(1280, 720);
        this.setPreferredSize(mapDimension);
        this.setBackground(Color.white);
        requestFocusInWindow();
        setFocusable(true);
        setHeight();
        this.assetLoader = assetLoader;
        //board is auto-init to null
        //Renderer?
        mapRenderer = new MapRenderer(this, assetLoader);

        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                nodeBoard[i][j] = new NodeOffset();
            }
        }

        this.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();

                if(notches < 0) {
//                    System.out.println("moved up");
                    Point pt = MouseInfo.getPointerInfo().getLocation();
                    if(scale < 5){
                        scale += 0.05;
                    }
                    repaint();
                } else {
//                    System.out.println("moved down");
                    if(scale >= 0.25){
                        scale -= 0.05;
                    }
                    repaint();
                }
            }
        });
    }
    public void moveCameraRight(){
        cameraX -= 40;
        repaint();
    }
    public void moveCameraLeft(){
        cameraX += 40;
        repaint();
    }
    public void moveCameraUp(){
        cameraY += 40;
        repaint();
    }
    public void moveCameraDown(){
        cameraY -= 40;
        repaint();
    }
    public void paintComponent(Graphics g) {
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                nodeBoard[i][j] = new NodeOffset();
            }
        }

        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        super.paintComponent(g2);
        g2.translate(200, 30);

        g2.scale(scale, scale);

        //draw transporters
        for(Transporter t : transporters){
            t.render(mapRenderer);
        }

        //draw grid
        for (int i=0;i<boardSize;i++) {
            for (int j=0;j<boardSize;j++) {
                if(board[i][j] != null){
                    board[i][j].render(mapRenderer);
                   board[i][j].getNodeRepresentation().render(mapRenderer);  //draw all parent node stuff
                    drawHex(i,j,g2,imageBoard[i][j]);
                    drawHex(i,j,g2,riverBoard[i][j]);
                    drawHexWithOffSet(i, j, g2, nodeBoard[i][j].getImages(), nodeBoard[i][j].getxOffSets(), nodeBoard[i][j].getyOffSets());
                } else {
                    drawHex(i, j, g2);
                }
            }
        }
        //fill in hexes
        for (int i=0;i<boardSize;i++) {
            for (int j=0;j<boardSize;j++) {
                String x = Integer.toString(i);
                String y = Integer.toString(j);
                String xy = "";
//                String xy = x + "," + y;
               // String xy ="" + nodeBoard[i][j].getImages().size();
                fillHex(i,j,xy,g2);
            }
        }

        setHeight();
        int i = x * (s+t)  + cameraX;
        int j = (y * h + (x%2) * h/2)  + cameraY;

        Polygon poly = hex(i,j);
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(10));
        g2.setColor(Color.yellow);
        g2.drawPolygon(poly);
        g2.setStroke(oldStroke);
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
        int x = i * (s+t) + cameraX;
        int y = (j * h + (i%2) * h/2) + cameraY;
        Polygon poly = hex(x,y);
        g2.setColor(Color.black);
        g2.fillPolygon(poly);
        g2.setColor(Color.white);
        g2.drawPolygon(poly);
    }
    public void drawHex(int i, int j, Graphics2D g2, BufferedImage image) {
        int x = i * (s+t) +  + cameraX;
        int y = (j * h + (i%2) * h/2) + cameraY;
        Polygon poly = hex(x,y);
//        System.out.println(i + " " + j);
        g2.drawImage(image, x+9, y+5, null);
        g2.drawPolygon(poly);
    }

    public void drawHexWithOffSet(int i, int j, Graphics2D g2, ArrayList<BufferedImage> images, ArrayList<Integer> xOffSets, ArrayList<Integer> yOffSets){
        for(int index = 0; index < images.size(); index++){
            int x = i * (s+t) +  + cameraX + xOffSets.get(index);
            int y = (j * h + (i%2) * h/2) + cameraY + yOffSets.get(index);
            g2.drawImage(images.get(index), x+r+borderSize+8, y+r+borderSize, null);
        }
    }

    public void fillHex(int i, int j, String xy, Graphics2D g2) {
        int x = i * (s+t) + cameraX;
        int y = (j * h + (i%2) * h/2) + cameraY;
        g2.drawString(xy, x+r+borderSize-10, y+r+borderSize+4);
    }

    public void updateBoard(Tile[][] boardFromMap) {
       // System.out.println("board has been updated");
        this.board = boardFromMap;
        repaint();
    }

    public void updateTransporters(ArrayList<Transporter> transporters){
        this.transporters = transporters;
        repaint();
    }

    public Point highlightNorthWest(){
        if(x % 2 == 0 || x == 0){
            x = (x-1 < 0)? boardSize-1 : x-1;
            y = (y-1 < 0)? boardSize-1 : y-1;
        } else {
            x = (x-1 < 0)? boardSize-1 : x-1;
        }
        repaint();
        return getPoint();
    }
    public Point highlightNorth(){
        y = (y-1 < 0)? boardSize-1 : y-1;
        repaint();
        return getPoint();
    }
    public Point highlightNorthEast(){
        if(x % 2 == 0 || x == 0){
            x = (x+1) % boardSize;
            y = (y-1 < 0)? boardSize-1 : y-1;
        } else{
            x = (x+1) % boardSize;
        }
        repaint();
        return getPoint();
    }
    public Point highlightSouthWest(){
        if(x % 2 == 1 || x == 0) {
            y = (y+1) % boardSize;
            x = (x - 1 < 0) ? boardSize - 1 : x - 1;
        } else{
            x = (x - 1 < 0) ? boardSize - 1 : x - 1;
        }
        repaint();
        return getPoint();
    }
    public Point highlightSouth(){
        y = (y+1) % boardSize;
        repaint();
        return getPoint();
    }
    public Point highlightSouthEast(){
        if(x % 2 == 1) {
            y = (y+1) % boardSize;
            x = (x+1) % boardSize;
        } else {
            x = (x + 1) % boardSize;
        }
        repaint();
        return getPoint();
    }

    public int getXCoord(){
        return this.x;
    }
    public int getYCoord(){
        return this.y;
    }
    public Point getPoint() { return new Point(getXCoord(), getYCoord());}

    public void drawTile(Point locationAsPoint, BufferedImage tile, BufferedImage river) {
        //TODO implement
        imageBoard[locationAsPoint.x][locationAsPoint.y] = tile;
        riverBoard[locationAsPoint.x][locationAsPoint.y] = river;
    }

    public void drawOnNode(Point point, BufferedImage image, int xOffSet, int yOffSet) {
        nodeBoard[point.x][point.y].getImages().add(image);
        nodeBoard[point.x][point.y].getxOffSets().add(xOffSet);
        nodeBoard[point.x][point.y].getyOffSets().add(yOffSet);
    }
}
