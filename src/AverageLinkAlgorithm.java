import java.util.List;

/**
 * Implementation of Average Link Algorithm.
 * implement of similarity function according to it.
 */
public class AverageLinkAlgorithm extends BaseAlgorithm {
    /**
     * calculate the similarity of the given clusters.
     *
     * @param a first cluster.
     * @param b second cluster.
     * @return min average distance of item in a with item in b.
     */
    @Override
    protected double calcSimilarity(Cluster a, Cluster b) {
        List<Point> aItems = a.getItems();
        List<Point> bItems = b.getItems();

        // sum the distances of each item in a with each item in b
        double sim = 0;
        for (Point x : aItems) {
            for (Point y : bItems) {
                double currDistance = x.distanceTo(y);
                sim += currDistance;
            }
        }

        // sim is the average of the distances
        sim /= aItems.size() * bItems.size();
        return sim;
    }
}
