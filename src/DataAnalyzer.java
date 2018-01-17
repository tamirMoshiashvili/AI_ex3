import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to analyze data from input file,
 * and hold different info about the input.
 */
public class DataAnalyzer {
    private String algoName;
    private int numClusters;
    private List<Point> points;

    /**
     * constructor.
     * parse the data-file.
     *
     * @param filename name of input-file.
     */
    public DataAnalyzer(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));

            // first two lines are algorithm-name and number of clusters
            this.algoName = reader.readLine();
            this.numClusters = Integer.parseInt(reader.readLine());

            // from now on, each line is a point, save each in the list
            this.points = new ArrayList<Point>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                this.points.add(new Point(x, y));
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: reading file");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error: reading from file");
            e.printStackTrace();
        }
    }

    /**
     * getter for the algorithm name.
     *
     * @return string describing the name of the algorithm.
     */
    public String getAlgoName() {
        return algoName;
    }

    /**
     * getter for number of clusters.
     *
     * @return int.
     */
    public int getNumClusters() {
        return numClusters;
    }

    /**
     * getter for the points list.
     *
     * @return list of points.
     */
    public List<Point> getPoints() {
        return points;
    }
}
