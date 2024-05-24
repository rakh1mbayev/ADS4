import java.util.*;

public interface Search<V> {
    Iterable<Vertex<V>> pathTo(V destination);
}
