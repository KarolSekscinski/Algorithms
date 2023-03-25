package pl.edu.pw.ee.graph;

import pl.edu.pw.ee.exception.ReadingGraphFromFileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;

public class GraphReader {

    private final String lineRegex = "^\\S+ \\S+ \\d+$";

    private final String lineRegexForExtendedFile = "^\\S+ \\d+ \\d+$";

    private final Pattern patternForExtendedFile = Pattern.compile(lineRegexForExtendedFile);

    private final Pattern pattern = Pattern.compile(lineRegex);

    private final String pathToFile;

    private final List<Edge> edgeList;

    public GraphReader(String pathToFile) {
        validateData(pathToFile);

        this.pathToFile = pathToFile;
        this.edgeList = new ArrayList<>();

        readAndSortEdges();
    }


    public List<Edge> getEdgeList() {
        return edgeList;
    }

    private void validateData(String pathToFile) {
        if (pathToFile == null) {
            throw new IllegalArgumentException("Path to file cannot be null!");
        }
    }

    private void readAndSortEdges() {
        readGraphFromFile();
    }

    private void readGraphFromFile() {
        Edge edge;
        int i = 1;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                edge = parseToEdge(line, i);
                if (!checkIfThereIsAlreadyEdgeBetweenTwoNodes(edge)) {
                    edgeList.add(edge);
                }
                i++;
            }
        } catch (IOException e) {
            throw new ReadingGraphFromFileException("Cannot read file from path!", e);
        }
    }

    private boolean checkIfThereIsAlreadyEdgeBetweenTwoNodes(Edge edge) {
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edgeToCompare = edgeList.get(i);
            if (edge.getFirstNode().getName().equals(edgeToCompare.getFirstNode().getName()) && edge.getSecondNode().getName().equals(edgeToCompare.getSecondNode().getName())) {
                edgeList.remove(edgeToCompare);
                edgeList.add(edge);
                return true;
            }

        }
        return false;
    }

    private Edge parseToEdge(String line, int lineNumber) {
        String[] args;
        Node firstNode;
        Node secondNode;
        int value;


        Matcher matcher = pattern.matcher(line);



        if (matcher.find()) {
            args = line.split(" ");
            firstNode = new Node(args[0]);
            secondNode = new Node(args[1]);
            value = Integer.parseInt(args[2]);

            return new Edge(firstNode, secondNode, value);

        } else {
            throw new ReadingGraphFromFileException
                    (format("Cannot correctly parse line %d from file", lineNumber));
        }


    }

    private void sortEdgesByPriority() {
        EdgeWeightComparator edgeWeightComparator = new EdgeWeightComparator();
        Collections.sort(edgeList, edgeWeightComparator);
    }
}
