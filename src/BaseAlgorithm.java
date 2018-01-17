import java.util.ArrayList;
import java.util.List;

/**
 * abstract class for an hierarchical algorithm.
 * has a skeleton of the algorithm, need to implement the similarity-calculation in derived classes.
 */
public abstract class BaseAlgorithm {
    protected List<Cluster> clusters;

    /**
     * constructor.
     */
    protected BaseAlgorithm() {
        this.clusters = new ArrayList<Cluster>();
    }

    /**
     * add each of the items in the given list as a cluster into the clusters list.
     *
     * @param items list of points.
     */
    private void initClustersFrom(List<Point> items) {
        for (Point item : items) {
            this.clusters.add(new Cluster(item));
        }
    }

    /**
     * apply the algorithm on the clusters-list.
     * find a division of the clusters.
     *
     * @param numNeededClusters num of needed clusters in the end.
     * @return list of clusters.
     */
    public List<Cluster> applyAlgorithm(List<Point> items, int numNeededClusters) {
        int currentClusterNum = 1;
        this.initClustersFrom(items);

        int len = this.clusters.size();
        // find two most similar clusters at each iteration and merge them,
        // till num of clusters needed is reached
        while (len != numNeededClusters) {
            int iMax = -1, jMax = -1;
            double maxSimVal = Double.MAX_VALUE;

            // create similarity matrix
            for (int i = 0; i < len; i++) {
                for (int j = 1; j < len && i < j; j++) {

                    // calculate similarity of cluster-i and cluster-j
                    Cluster a = this.clusters.get(i);
                    Cluster b = this.clusters.get(j);
                    double currSim = this.calcSimilarity(a, b);

                    // update if needed the argmax
                    if (currSim < maxSimVal) {
                        maxSimVal = currSim;
                        iMax = i;
                        jMax = j;
                    }
                }
            }

            // merge the most similar clusters
            Cluster a = this.clusters.get(iMax);
            Cluster b = this.clusters.get(jMax);
            a.mergeClusterWith(b);
            this.clusters.remove(jMax);

            // check for assigning cluster number
            if (!a.hasClusterNumber()) {
                a.setClusterNum(currentClusterNum);
                ++currentClusterNum;
            }

            len = this.clusters.size();
        }
        return this.clusters;
    }

    /**
     * calculate the similarity between two clusters.
     *
     * @param a first cluster.
     * @param b second cluster.
     * @return double value that represents the similarity between the given clusters.
     */
    protected abstract double calcSimilarity(Cluster a, Cluster b);
}
