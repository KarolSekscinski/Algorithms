package pl.edu.pw.ee.graph;

public class CoordinatesForNode {

    private final int x;

    private final int y;

    private final Node nodeName;

    public CoordinatesForNode(Node nodeName, int x, int y) {
        this.nodeName = nodeName;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
