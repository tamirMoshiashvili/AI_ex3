import java.util.ArrayList;
import java.util.List;

/**
 * cluster object groups elements.
 * it has a unique number.
 */
public class Cluster {
    private List<Point> items;

    /**
     * constructor.
     *
     * @param firstItem first item in the cluster.
     */
    public Cluster(Point firstItem) {
        this.items = new ArrayList<Point>();
        this.items.add(firstItem);
    }

    /**
     * get list of items in the cluster.
     *
     * @return list of points.
     */
    public List<Point> getItems() {
        return this.items;
    }

    /**
     * merge this cluster with the given one.
     *
     * @param other list of points.
     */
    public void mergeClusterWith(Cluster other) {
        this.items.addAll(other.getItems());
    }

    /**
     * check if the given item is in the cluster.
     *
     * @param item point.
     * @return true if the cluster contains the item, false otherwise.
     */
    public boolean containsItem(Point item) {
        return this.items.contains(item);
    }
}
