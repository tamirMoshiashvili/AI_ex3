/**
 * point has x and y coordinates.
 */
public class Point {
    private int x, y;

    /**
     * constructor.
     *
     * @param x x coordinate.
     * @param y y coordinate.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get the x-coordinate.
     *
     * @return int.
     */
    public int getX() {
        return x;
    }

    /**
     * get the y-coordinate.
     *
     * @return int.
     */
    public int getY() {
        return y;
    }

    /**
     * calculate the distance between this point to other point.
     *
     * @param other other point.
     * @return double, the distance between the points.
     */
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}
