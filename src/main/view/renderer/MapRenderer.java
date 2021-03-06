package view.renderer;

import model.map.tile.*;
import model.map.tile.nodeRepresentation.nodes.parent.ParentLandNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentRiverNode;
import model.map.tile.nodeRepresentation.nodes.parent.ParentSeaNode;
import model.structures.primary_production_structures.PrimaryProduction;
import model.structures.secondary_production_structures.SecondaryProduction;
import model.structures.transport_factory_structures.TransportFactory;
import model.transporters.land_transporters.AllTerrainLandTransporter;
import model.transporters.land_transporters.RoadLandTransporter;
import model.transporters.water_transporters.WaterTransporter;
import model.utilities.ConversionUtilities;
import view.BoardPanel;
import view.assets.AssetLoader;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class MapRenderer {

    private BoardPanel boardPanel;
    private AssetLoader assetLoader;
    private BufferedImage riverImg;
    private NodeOffset nodeOffset;
    private String riverTypeString;
    public MapRenderer(BoardPanel boardPanel, AssetLoader assetLoader) {
        this.boardPanel = boardPanel;
        this.assetLoader = assetLoader;
        this.nodeOffset = new NodeOffset();
        this.riverTypeString = "RIVER_SOURCE";
    }

    public void draw(DesertTile desertTile) {
        this.riverImg = determineCorrectRiverImage(desertTile.getNodeRepresentationRiverString(), desertTile.getNodeRepresentationRotation());
        boardPanel.drawTile(ConversionUtilities.convertFromCubeToPoint(desertTile.getLocation()), assetLoader.getImage("TILE_DESERT"), riverImg);
    }
    public void draw(MountainsTile mountainsTile) {
        this.riverImg = determineCorrectRiverImage(mountainsTile.getNodeRepresentationRiverString(), mountainsTile.getNodeRepresentationRotation());
        boardPanel.drawTile(ConversionUtilities.convertFromCubeToPoint(mountainsTile.getLocation()), assetLoader.getImage("TILE_MOUNTAIN"), riverImg);
    }
    public void draw(PastureTile pastureTile) {
        this.riverImg = determineCorrectRiverImage(pastureTile.getNodeRepresentationRiverString(), pastureTile.getNodeRepresentationRotation());
        boardPanel.drawTile(ConversionUtilities.convertFromCubeToPoint(pastureTile.getLocation()), assetLoader.getImage("TILE_PASTURE"), riverImg);
    }
    public void draw(RockTile rockTile) {
        this.riverImg = determineCorrectRiverImage(rockTile.getNodeRepresentationRiverString(), rockTile.getNodeRepresentationRotation());
        boardPanel.drawTile(ConversionUtilities.convertFromCubeToPoint(rockTile.getLocation()), assetLoader.getImage("TILE_ROCK"), riverImg);
    }
    public void draw(SeaTile seaTile) {
        boardPanel.drawTile(ConversionUtilities.convertFromCubeToPoint(seaTile.getLocation()), assetLoader.getImage("TILE_SEA"), null);
    }
    public void draw(WoodsTile woodsTile) {
        this.riverImg = determineCorrectRiverImage(woodsTile.getNodeRepresentationRiverString(), woodsTile.getNodeRepresentationRotation());
        boardPanel.drawTile(ConversionUtilities.convertFromCubeToPoint(woodsTile.getLocation()), assetLoader.getImage("TILE_WOODS"), riverImg);
    }

    public void drawTransporter(AllTerrainLandTransporter d){
        BufferedImage image = assetLoader.getImage("DONKEY");
        int xOffSet = d.getParentNode().getxOffSet() - 10;
        int yOffSet = d.getParentNode().getyOffSet() - 5;

        boardPanel.drawOnNode(ConversionUtilities.convertFromCubeToPoint(d.getParentNode().getNodeRepresentation().getTile().getLocation()), image, xOffSet, yOffSet );
    }

    public void drawTransporter(RoadLandTransporter roadLandTransporter) {
        BufferedImage image = assetLoader.getImage("LAND");
        int xOffSet = roadLandTransporter.getParentNode().getxOffSet() - 10;
        int yOffSet = roadLandTransporter.getParentNode().getyOffSet() - 5;

        boardPanel.drawOnNode(ConversionUtilities.convertFromCubeToPoint(roadLandTransporter.getParentNode().getNodeRepresentation().getTile().getLocation()), image, xOffSet, yOffSet );
    }

    public void drawTransporter(WaterTransporter waterTransporter) {
        BufferedImage image = assetLoader.getImage("WATER");
        int xOffSet = waterTransporter.getParentNode().getxOffSet() - 10;
        int yOffSet = waterTransporter.getParentNode().getyOffSet() - 5;

        boardPanel.drawOnNode(ConversionUtilities.convertFromCubeToPoint(waterTransporter.getParentNode().getNodeRepresentation().getTile().getLocation()), image, xOffSet, yOffSet );
    }

    public void drawNodeInfo(ParentLandNode parentLandNode) {
      //  BufferedImage image = assetLoader.getImage("DOT");
        int xOffSet = parentLandNode.getxOffSet();
        int yOffSet = parentLandNode.getyOffSet();

        if(parentLandNode.hasResource()){
            BufferedImage image = assetLoader.getImage("DOT");
            boardPanel.drawOnNode(ConversionUtilities.convertFromCubeToPoint(parentLandNode.getNodeRepresentation().getTile().getLocation()),image, xOffSet, yOffSet);

        }

        if(parentLandNode.getStructure() != null){
            BufferedImage structureImage = assetLoader.getImage("STRUCTURE");
            boardPanel.drawOnNode(ConversionUtilities.convertFromCubeToPoint(parentLandNode.getNodeRepresentation().getTile().getLocation()),structureImage, xOffSet, yOffSet);

        }
        if(parentLandNode.hasChildWithRoad()){
            BufferedImage roadImage = assetLoader.getImage("ROAD");
            boardPanel.drawOnNode(ConversionUtilities.convertFromCubeToPoint(parentLandNode.getNodeRepresentation().getTile().getLocation()),roadImage, xOffSet, yOffSet);

        }

    }

    public void drawNodeInfo(ParentSeaNode parentSeaNode) {
     //   BufferedImage image = assetLoader.getImage("DOT");
        int xOffSet = parentSeaNode.getxOffSet();
        int yOffSet = parentSeaNode.getyOffSet();

        if(parentSeaNode.getStructure() != null){
            BufferedImage structureImage = assetLoader.getImage("STRUCTURE");
            boardPanel.drawOnNode(ConversionUtilities.convertFromCubeToPoint(parentSeaNode.getNodeRepresentation().getTile().getLocation()),structureImage, xOffSet, yOffSet);

        }

     //   boardPanel.drawOnNode(ConversionUtilities.convertFromCubeToPoint(parentSeaNode.getNodeRepresentation().getTile().getLocation()), image, xOffSet, yOffSet);
    }

    public void drawNodeInfo(ParentRiverNode parentRiverNode){
      //  BufferedImage image = assetLoader.getImage("DOT");
        int xOffSet = parentRiverNode.getxOffSet();
        int yOffSet = parentRiverNode.getyOffSet();

        //  boardPanel.drawOnNode(ConversionUtilities.convertFromCubeToPoint(parentRiverNode.getNodeRepresentation().getTile().getLocation()), image, xOffSet, yOffSet);

        if(parentRiverNode.getStructure() != null){
            BufferedImage structureImage = assetLoader.getImage("STRUCTURE");
            boardPanel.drawOnNode(ConversionUtilities.convertFromCubeToPoint(parentRiverNode.getNodeRepresentation().getTile().getLocation()),structureImage, xOffSet, yOffSet);

        }
    }


    public void drawStructure(PrimaryProduction primaryProduction) {
        int xOffSet = primaryProduction.getParentNode().getxOffSet();
        int yOffSet = primaryProduction.getParentNode().getyOffSet();

        BufferedImage structureImage = assetLoader.getImage("PRIMARY");
        boardPanel.drawOnNode(ConversionUtilities.convertFromCubeToPoint(primaryProduction.getParentNode().getNodeRepresentation().getTile().getLocation()),structureImage, xOffSet, yOffSet);
    }

    public void drawStructure(SecondaryProduction secondaryProduction) {
        int xOffSet = secondaryProduction.getParentNode().getxOffSet();
        int yOffSet = secondaryProduction.getParentNode().getyOffSet();

        BufferedImage structureImage = assetLoader.getImage("SECONDARY");
        boardPanel.drawOnNode(ConversionUtilities.convertFromCubeToPoint(secondaryProduction.getParentNode().getNodeRepresentation().getTile().getLocation()),structureImage, xOffSet, yOffSet);
    }

    public void drawStructure(TransportFactory transportFactory) {
        int xOffSet = transportFactory.getParentNode().getxOffSet();
        int yOffSet = transportFactory.getParentNode().getyOffSet();

        BufferedImage structureImage = assetLoader.getImage("FACTORY");
        boardPanel.drawOnNode(ConversionUtilities.convertFromCubeToPoint(transportFactory.getParentNode().getNodeRepresentation().getTile().getLocation()),structureImage, xOffSet, yOffSet);
    }




    private BufferedImage determineCorrectRiverImage(String riverString, int rotation){

        BufferedImage riverImage;

        if(riverString == "")
            return null;
        else
            riverImage = assetLoader.getImage(riverString);

        double rotationRequired = Math.toRadians(rotation);
        double locationX = riverImage.getWidth() / 2;
        double locationY = riverImage.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(riverImage, null);
    }


    //TODO remove once all node representations are complete
    public BufferedImage determineCorrectRiverImage(Tile t){
        BufferedImage riverImage = null;
        int hexRotation = 0;
        int rotationBySides = 0;

        //count tile zones with water
        int zonesWithWater = 0;
        ArrayList<Integer> zoneIndices = new ArrayList<>();

        System.out.println("zone indices: " + zoneIndices.toString());

        //the rotation of the zone is the difference between index first watered zone and '1', multiplied by 60
        //'1' is the face in which all default river images begin
        switch (zonesWithWater){
            case 0:
                return null;
            case 1:
                //determine rotation
                rotationBySides = zoneIndices.get(0) - 1;
                hexRotation = rotationBySides*60;
                riverImage = assetLoader.getImage("RIVER_SOURCE");
                break;
            case 2:
                //determine rotation
                int zoneDistance = abs(zoneIndices.get(1) - zoneIndices.get(0));

                rotationBySides = zoneIndices.get(0) - 1;
                hexRotation = rotationBySides*60;
                if(zoneDistance == 1){
                    riverImage = assetLoader.getImage("RIVER_2_U");
                } else if (zoneDistance == 2){
                    riverImage = assetLoader.getImage("RIVER_2_CURVED");
                } else if (zoneDistance == 3){
                    riverImage = assetLoader.getImage("RIVER_2_STRAIGHT");
                }else if (zoneDistance == 4){   //edge case
                    riverImage = assetLoader.getImage("RIVER_2_CURVED");
                    hexRotation = 300;
                    if (zoneIndices.get(0) == 1){
                        hexRotation = 240;
                    }
                }else if (zoneDistance == 5){   //edge case
                    riverImage = assetLoader.getImage("RIVER_2_U");
                    hexRotation = 300;
                }

                break;
            case 3:
                //determine rotation
                rotationBySides = zoneIndices.get(0) - 1;
                hexRotation = rotationBySides*60;
                riverImage = assetLoader.getImage("RIVER_3");
                break;
            default:
                riverImage = assetLoader.getImage("RIVER_SOURCE");
        }

        double rotationRequired = Math.toRadians (hexRotation);
        double locationX = riverImage.getWidth() / 2;
        double locationY = riverImage.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(riverImage, null);


    }



}
