import java.util.ArrayList;
import java.util.List;

// Graph class to represent the undirected graph
class Graph {
    private int numVertices;   // Number of vertices in the graph
    private List<List<Integer>> adj; // Adjacency Lists to store the graph

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adj = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
        adj.get(vertex2).add(vertex1); // Since the graph is undirected
    }

    public List<List<Integer>> getAdjacencyLists() {
        return adj;
    }

    public int getNumVertices() {
        return numVertices;
    }
}

// DFS class to encapsulate the Depth-First Search logic
public class DFS {
    private Graph graph;

    public DFS(Graph graph) {
        this.graph = graph;
    }

    // Method to initiate the DFS and check for connectivity
    public boolean isConnected(int source, int target) {
        boolean[] visited = new boolean[graph.getNumVertices()];
        return explore(source, target, visited);
    }

    // Recursive DFS method to explore the graph
    private boolean explore(int current, int target, boolean[] visited) {
        if (current == target) return true; // Target found

        visited[current] = true;
        for (int neighbor : graph.getAdjacencyLists().get(current)) {
            if (!visited[neighbor] && explore(neighbor, target, visited)) {
                return true; // Path found via neighbor
            }
        }
        return false; // No path found
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        DFS dfs = new DFS(graph);

        int source = 0, target = 3;
        System.out.println("Path exists between " + source + " and " + target + ": " + dfs.isConnected(source, target));

        source = 3;
        target = 1;
        System.out.println("Path exists between " + source + " and " + target + ": " + dfs.isConnected(source, target));
    }
}




