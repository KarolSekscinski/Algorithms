package pl.edu.pw.ee;

import pl.edu.pw.ee.graph.Edge;
import pl.edu.pw.ee.graph.EdgeWeightComparator;
import pl.edu.pw.ee.graph.Graph;
import pl.edu.pw.ee.graph.Node;
import pl.edu.pw.ee.services.MinSpanningTree;

import java.util.*;

public class KruskalAlgorithm implements MinSpanningTree {

    private List<Edge> edgeList;

    private ArrayList<Node> nodeList;

    private boolean[] visited;

    private ArrayList<Edge> pQueue;

    private List<Edge> listToMST;

    private int[][] adjacencyMatrix;

    int numberOfNodes;


    @Override
    public String findMST(String pathToFile) {
        Graph graph = new Graph(pathToFile);

        edgeList = graph.getEdgeList();

        sortEdgesByPriority();

        validateGraphConnectivity(graph);


        numberOfNodes = numberOfNodesInGraph(edgeList);

        visited = new boolean[numberOfNodes];

        Arrays.fill(visited, false);

        pQueue = new ArrayList<>();

        fillAdjacencyMatrix(edgeList);


        listToMST = new ArrayList<>();

        pQueue.addAll(edgeList);


        Edge edge = pQueue.remove(0);
        int indexOfFirstNode = indexOfNodeInArray(edge.getFirstNode());
        visited[indexOfFirstNode] = true;
        int indexOfSecondNode = indexOfNodeInArray(edge.getSecondNode());
        listToMST.add(edge);

        while (pQueue.size() > 0) {
            edge = pQueue.remove(0);
            indexOfFirstNode = indexOfNodeInArray(edge.getFirstNode());
            indexOfSecondNode = indexOfNodeInArray(edge.getSecondNode());
            if (visited[indexOfFirstNode] && visited[indexOfSecondNode]) {
                continue;
            }
            visited[indexOfSecondNode] = true;
            visited[indexOfFirstNode] = true;
            listToMST.add(edge);
        }

        StringBuilder mst = new StringBuilder();
        mst.append(listToMST.get(0));
        for (int i = 1; i < listToMST.size(); i++) {

            mst.append("|" + listToMST.get(i));
        }
        System.out.println(mst);
        return mst.toString();
    }


    private void sortEdgesByPriority() {
        EdgeWeightComparator edgeWeightComparator = new EdgeWeightComparator();
        Collections.sort(edgeList, edgeWeightComparator);
    }

    private void fillAdjacencyMatrix(List<Edge> edgeList) {
        adjacencyMatrix = new int[numberOfNodes][numberOfNodes];
        for (int k = 0; k < edgeList.size(); k++) {
            Node firstNode = edgeList.get(0).getFirstNode();
            Node secondNode = edgeList.get(0).getSecondNode();
            int value = edgeList.get(0).getValue();
            int i = indexOfNodeInArray(firstNode);
            int j = indexOfNodeInArray(secondNode);
            adjacencyMatrix[i][j] = value;
        }



    }

    private int indexOfNodeInArray(Node node) {
        int i = 0;
        for (int j = 0; j < nodeList.size(); j++) {
            if (nodeList.get(j).getName().equals(node.getName())) {
                i = j;
            }
        }
        return i;
    }

    private int numberOfNodesInGraph(List<Edge> edgeList) {
        nodeList = new ArrayList<>();
        pl.edu.pw.ee.graph.Node node = edgeList.get(0).getFirstNode();
        Node secondNode = edgeList.get(0).getSecondNode();
        nodeList.add(node);
        nodeList.add(secondNode);
        for (int i = 1; i < edgeList.size(); i++) {
            node = edgeList.get(i).getFirstNode();
            secondNode = edgeList.get(i).getSecondNode();
            if (!nodeList.contains(node)) {
                nodeList.add(node);
            }
            if (!nodeList.contains(secondNode)) {
                nodeList.add(secondNode);
            }
        }
        Collections.sort(nodeList);

        return nodeList.size();
    }

    private void validateGraphConnectivity(Graph graph) {
        if (!solve(graph)) {
            throw new IllegalStateException("Graph need to be connected in order to find MST!");
        }
    }

    private boolean solve(Graph graph) {
        //TODO

        return true;

    }
}
