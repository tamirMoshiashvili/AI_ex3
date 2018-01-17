import java.util.ArrayList;
import java.util.List;

/**
 * cluster object groups elements.
 * it has a unique number.
 */
public class Cluster {
    private List<Point> items;
    private int clusterNum;

    /**
     * constructor.
     *
     * @param firstItem first item in the cluster.
     */
    public Cluster(Point firstItem) {
        this.items = new ArrayList<Point>();
        this.items.add(firstItem);

        // -1 will note that the cluster has no number yet
        this.clusterNum = -1;
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
     * check if this cluster has a unique number.
     *
     * @return false if the number is -1 and true otherwise.
     */
    public boolean hasClusterNumber() {
        return this.clusterNum != -1;
    }

    /**
     * setter for the unique number of the cluster.
     *
     * @param clusterNum number of the cluster.
     */
    public void setClusterNum(int clusterNum) {
        this.clusterNum = clusterNum;
    }

    /**
     * getter for the cluster's number.
     *
     * @return int.
     */
    public int getClusterNum() {
        return clusterNum;
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
