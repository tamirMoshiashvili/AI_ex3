import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class java_ex3 {

    /**
     * main class to run the program.
     *
     * @param args arguments.
     */
    public static void main(String[] args) {
        // parse input
        String inputFilename = "input.txt";
        DataAnalyzer parser = new DataAnalyzer(inputFilename);

        // create optional algorithms
        Map<String, BaseAlgorithm> algoFactory = new HashMap<String, BaseAlgorithm>();
        algoFactory.put("single link", new SingleLinkAlgorithm());
        algoFactory.put("average link", new AverageLinkAlgorithm());

        // apply algorithm
        BaseAlgorithm chosenAlgo = algoFactory.get(parser.getAlgoName());
        List<Point> items = parser.getPoints();
        List<Cluster> clusters = chosenAlgo.applyAlgorithm(items, parser.getNumClusters());

        // write results to output file
        try {
            Writer writer = new FileWriter(new File("output.txt"));

            // for each point, write to the output file the cluster number it is in
            for (Point item : items) {
                for (Cluster cluster : clusters) {
                    if (cluster.containsItem(item)) {
                        writer.write(cluster.getClusterNum());
                        writer.write("\n");
                        break;
                    }
                }
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error: problem with output file");
            e.printStackTrace();
        }
    }
}
