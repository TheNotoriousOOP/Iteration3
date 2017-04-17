package model.utilities;

import model.map.CubeVector;

import java.awt.*;

/**
 * Utilities class that provides functionality to convert between cube coordinates and indices
 * In this class, x, y, and z all refer to cube coordinate values.
 * In this class, col and row refer to the first and second index, respectively
 * In this class, maxDistance refers to the max distance allowed between tiles. This constant factor helps shift between indices correctly
 * Created by Jonathen on 3/29/2017.
 */
public class ConversionUtilities {

    //TODO any way to get around this?
    //TODO tied to maxDistance in map.
    private static final int maxDistance = 21;

    public static CubeVector convertFromIndicesToCube(int col, int row) {
        int x = computeX(col);
        int z = computeZ(x, row);
        int y = computeY(x,z);

        System.out.println("class CONVERSIONUTILITIES: converted " + col + ", " + row + " to " + x + ", " + y + ", " + z);
        return new CubeVector(x,y,z);
    }

    private static int computeX(int col) { return col - maxDistance/2; }

    private static int computeZ(int x, int row) {
        return (int) Math.ceil(-1 * x / 2.0) + row - maxDistance/2;
    }

    private static int computeY(int x, int z) {
        return -1*x - z;
    }

    public static int convertFromCubeToColumn(CubeVector cubeVector) {
        return cubeVector.getXCoord() + maxDistance/2;
    }

    public static int convertFromCubeToRow(CubeVector cubeVector) {
        return Math.floorDiv(cubeVector.getZCoord() - (cubeVector.getYCoord()), 2) + maxDistance/2;
    }

    public static Point convertFromCubeToPoint(CubeVector cubeVector) {
        return new Point(convertFromCubeToColumn(cubeVector), convertFromCubeToRow(cubeVector));
    }

    public static CubeVector convertFromPointToCube(Point point) {
        return convertFromIndicesToCube(point.x, point.y);
    }
}
