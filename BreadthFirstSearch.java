import java.util.*;

class BreadthFirstSearch<T> implements Search <T> {
    private final Map<T, T> edgeTo;
    private final Set<T> marked;
    private final T start;

    public BreadthFirstSearch(MyGraph<T> graph, T start) {
        this.edgeTo = new HashMap<>();
        this.marked = new HashSet<>();
        this.start = start;
        bfs(graph, start);
    }

    private void bfs(MyGraph<T> graph, T start) {
        Queue<T> queue = new LinkedList<>();
        marked.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            T v = queue.poll();
            Vertex<T> vertex = graph.getVertex(v);
            for (Edge<T> edge : vertex.getAdjacents()) {
                T w = edge.getVertex().getValue();
                if (!marked.contains(w)) {
                    edgeTo.put(w, v);
                    marked.add(w);
                    queue.add(w);
                }
            }
        }
    }

    public boolean hasPathTo(T v) {
        return marked.contains(v);
    }

    public Iterable<T> pathTo(T v) {
        if (!hasPathTo(v)) return null;
        LinkedList<T> path = new LinkedList<>();
        for (T x = v; x != start; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }
}
