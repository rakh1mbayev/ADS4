class WeightedGraph<T> extends MyGraph<T> {

    public WeightedGraph(boolean directed) {
        super(directed);
    }

    public void addEdge(T from, T to, double weight) {
        Vertex<T> v = getVertex(from);
        if (v == null) {
            v = new Vertex<>(from);
            addVertex(v);
        }
        Vertex<T> w = getVertex(to);
        if (w == null) {
            w = new Vertex<>(to);
            addVertex(w);
        }
        v.addAdjacent(w, weight);
        if (!directed) {
            w.addAdjacent(v, weight);
        }
    }

    private void addVertex(Vertex<T> vertex) {
        vertices.put(vertex.getValue(), vertex);
    }
}
