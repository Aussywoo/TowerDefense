package game;

import java.awt.Point;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Graphics;

/**
 * Reads coordinate points from the path.txt file and stores values in a list.
 */
public class Path {
    private static int coordNum;
    private static ArrayList<Point> coords = new ArrayList<Point>();

    /** This constructor does the following:
     *     - It reads a number of coordinates, n, from the scanner.
     *     - It creates new array(s) (or an ArrayList) to hold the path coordinates,
     *          and stores it in the field in 'this' object.
     *     - It loops n times, each time scanning a coordinate x,y pair, creating an
     *         object to represent the coordinate (if needed), and stores the coordinate
     *         in the array(s) or ArrayList.
     *
     * @param s  a Scanner set up by the caller to provide a list of coordinates
     */
    public Path(Scanner s) {

        coordNum = s.nextInt();

        for(int i = 0; i < coordNum; i++) {
            coords.add(new Point(s.nextInt(), s.nextInt()));
        }
    }

    /**
     * Draws the current path to the screen (to wherever the graphics object points)
     * using a highly-visible color.
     *
     * @param g   a graphics object
     */
    public static void drawPath(Graphics g) {
        int x1, y1, x2, y2;
        for(int i = 0; i < coordNum - 1; i++) {
            x1 = (int)coords.get(i).getX();
            y1 = (int)coords.get(i).getY();
            x2 = (int)coords.get(i+1).getX();
            y2 = (int)coords.get(i+1).getY();
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * Returns the total length of the path. Since the path
     * is specified using screen coordinates, the length is
     * in pixel units (by default).
     *
     * @return the length of the path
     */
    public static double getPathLength() {
        double x1, y1, x2, y2;
        double length = 0;
        for(int i = 0; i < coordNum - 1; i++) {
            x1 = coords.get(i).getX();
            y1 = coords.get(i).getY();
            x2 = coords.get(i+1).getX();
            y2 = coords.get(i+1).getY();

            length += Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }

        return length;
    }

    /**
     * Returns the length of a given segment. Since the path
     * is specified using screen coordinates, the length is
     * in pixel units (by default).
     *
     * @return the length of the path
     */
    public static double getSegLength(Point a, Point b) {
        double x1, y1, x2, y2;
        double length = 0;{

            x1 = a.getX();
            y1 = a.getY();
            x2 = b.getX();
            y2 = b.getY();

            length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }

        return length;
    }

    /**
     * Given a percentage between 0% and 100%, this method calculates
     * the location along the path that is exactly this percentage
     * along the path. The location is returned in a Point object
     * (integer x and y), and the location is a screen coordinate.
     *
     * If the percentage is less than 0%, the starting position is
     * returned. If the percentage is greater than 100%, the final
     * position is returned.
     *
     * If students don't want to use Point objects, they may
     * write or use another object to represent coordinates.
     *
     * Caution: Students should never directly return a Point object
     * from a path list. It could be changed by the outside caller.
     * Instead, always create and return new point objects as
     * the result from this method.
     *
     * @param percentTraveled a distance along the path
     * @return the screen coordinate of this position along the path
     */
    public static Point getPathPosition(double percentTraveled) {
        //Calculates actual length based off of percentage
        if(percentTraveled == 0.0) {
            return(coords.get(0));
        }

        double targetLength = getPathLength()*percentTraveled;
        double currentLength = 0;
        int segmentCount = 0;

        //Finds the point within coords before the target length is reached
        while(currentLength < targetLength) {
            currentLength += getSegLength(coords.get(segmentCount), coords.get(segmentCount+1));
            segmentCount++;
        }
        double finalSegLength = getSegLength(coords.get(segmentCount-1), coords.get(segmentCount));

        //Find the distance left to travel starting from the point before the target length is reached
        double distLeft = targetLength - currentLength + finalSegLength;

        //Calculate the final coordinate
        double x1, y1, x2, y2;

        x1 = coords.get(segmentCount-1).getX();
        y1 = coords.get(segmentCount-1).getY();
        x2 = coords.get(segmentCount).getX();
        y2 = coords.get(segmentCount).getY();
        int finalX = (int)Math.round(x1 + (x2-x1)*distLeft/finalSegLength);
        int finalY = (int)Math.round(y1 + (y2-y1)*distLeft/finalSegLength);

        return new Point(finalX, finalY);
    }
}
