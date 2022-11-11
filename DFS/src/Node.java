public class Node<T> implements MyVertex {
    private T value;
    private boolean visited;

    public Node(T value) {
        this.value = value;
        this.visited = false;
    }

    public T getValue() {
        return value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
