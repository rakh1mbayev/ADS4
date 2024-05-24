import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<Vertex<V>, Vertex<V>> edgeTo;
    private Vertex<V> source;

    public BreadthFirstSearch(WeightedGraph<V> graph, V sourceData) {
        this.edgeTo = new HashMap<>();
        this.source = graph.getVertex(sourceData);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> source) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();
        queue.offer(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    edgeTo.put(neighbor, current);
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    @Override
    public Iterable<Vertex<V>> pathTo(V destinationData) {
        List<Vertex<V>> path = new ArrayList<>();
        Vertex<V> destination = source.getAdjacentVertices().keySet().stream()
                .filter(v -> v.getData().equals(destinationData))
                .findFirst().orElse(null);
        if (destination == null) return path;
        for (Vertex<V> vertex = destination; vertex != source; vertex = edgeTo.get(vertex)) {
            path.add(vertex);
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }
}
