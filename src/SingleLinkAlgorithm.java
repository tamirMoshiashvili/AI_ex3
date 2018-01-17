import java.util.List;

/**
 * Implementation of Single Link Algorithm.
 * implement of similarity function according to it.
 */
public class SingleLinkAlgorithm extends BaseAlgorithm {
    /**
     * calculate the similarity of the given clusters.
     *
     * @param a first cluster.
     * @param b second cluster.
     * @return min distance of item in a with item in b.
     */
    @Override
    protected double calcSimilarity(Cluster a, Cluster b) {
        List<Point> aItems = a.getItems();
        List<Point> bItems = b.getItems();

        // calculate the similarity of each item in a with every item in b,
        // save the min value in sim-variable
        double sim = Double.MAX_VALUE;
        for (Point x : aItems) {
            for (Point y : bItems) {
                double currSim = x.distanceTo(y);
                if (currSim < sim) {
                    sim = currSim;
                }
            }
        }

        return sim;
    }
}
