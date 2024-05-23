import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class MyGraph<T> {
    public final Map<T, Vertex<T>> vertices;
    public final boolean directed;

    public MyGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new HashMap<>();
    }

    public void addEdge(T from, T to) {
        Vertex<T> v = vertices.computeIfAbsent(from, Vertex::new);
        Vertex<T> w = vertices.computeIfAbsent(to, Vertex::new);
        v.addAdjacent(w);
        if (!directed) {
            w.addAdjacent(v);
        }
    }

    public Vertex<T> getVertex(T value) {
        return vertices.get(value);
    }

    public Collection<Vertex<T>> getVertices() {
        return vertices.values();
    }
}
