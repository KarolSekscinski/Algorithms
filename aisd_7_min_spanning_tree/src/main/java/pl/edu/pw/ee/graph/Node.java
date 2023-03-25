package pl.edu.pw.ee.graph;

import static java.lang.String.format;

public class Node implements Comparable<Node> {

    private String name;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return format("Node: %s", name);
    }

    @Override
    public int compareTo(Node node) {
        return (int) name.charAt(0) - (int) node.getName().charAt(0);
    }

    @Override
    public boolean equals(Object object) {
        Node node = (Node) object;
        return name.charAt(0) == node.name.charAt(0);
    }
}
