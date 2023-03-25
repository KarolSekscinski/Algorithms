package pl.edu.pw.ee.graph;

import java.util.List;

public class Graph {

    private final String pathToGraphFile;

    private List<Edge> edgeList;

    public Graph(String pathToGraphFile) {

        validatePathToGraphFile(pathToGraphFile);


        this.pathToGraphFile = pathToGraphFile;

        readGraphFromFile();
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    @Override
    public String toString() {
        StringBuilder graphAsString = new StringBuilder();
        int i = 1;
        for (Edge edge : edgeList) {
            graphAsString.append(edge);
            if (edgeList.size() > i) {
                graphAsString.append("|");
                i++;
            }

        }
        System.out.println(graphAsString);
        return graphAsString.toString();
    }

    private void validatePathToGraphFile(String pathToGraphFile) {
        if (pathToGraphFile == null) {
            throw new IllegalArgumentException("Path to graph file cannot be null!");
        }
    }

    private void readGraphFromFile() {
        GraphReader graphReader = new GraphReader(pathToGraphFile);
        edgeList = graphReader.getEdgeList();
    }
}
