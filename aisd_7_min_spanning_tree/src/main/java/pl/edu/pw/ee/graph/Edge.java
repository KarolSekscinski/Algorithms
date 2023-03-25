package pl.edu.pw.ee.graph;

import static java.lang.String.format;

public class Edge {

    private final Node firstNode;

    private final Node secondNode;

    private final int value;

    public Edge(Node firstNode, Node secondNode, int value) {
        validateInput(firstNode, secondNode);

        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.value = value;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getSecondNode() {
        return secondNode;
    }

    public int getValue() {
        return value;
    }


    @Override
    public String toString() {
        return format("%s_%d_%s", firstNode.getName(), value, secondNode.getName());
    }

    private void validateInput(Node firstNode, Node secondNode) {
        if (firstNode == null || secondNode == null) {
            throw new IllegalArgumentException("Input Nodes (start or end) cannot be null!");
        }
    }

}
