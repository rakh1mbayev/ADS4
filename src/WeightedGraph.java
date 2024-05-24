import java.util.*;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;
    private boolean directed;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new HashMap<>();
    }

    public void addVertex(V data) {
        if (!vertices.containsKey(data)) {
            vertices.put(data, new Vertex<>(data));
        }
    }

    public void addEdge(V sourceData, V destData, double weight) {
        addVertex(sourceData);
        addVertex(destData);
        Vertex<V> source = vertices.get(sourceData);
        Vertex<V> dest = vertices.get(destData);
        source.addAdjacentVertex(dest, weight);
        if (!directed) { 
            dest.addAdjacentVertex(source, weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Collection<Vertex<V>> getAllVertices() {
        return vertices.values();
    }
}
