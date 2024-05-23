interface Search<T> {
    boolean hasPathTo(T v);
    Iterable<T> pathTo(T v);
}
