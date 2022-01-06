import java.util.*;

public class DepthFirstSearchExample {

        public static void main (String[] args) {
            Node<Integer> n0 = new Node<>(0);
            Node<Integer> n1 = new Node<>(1);
            Node<Integer> n2 = new Node<>(2);
            Node<Integer> n3 = new Node<>(3);
            Node<Integer> n4 = new Node<>(4);
            Node<Integer> n5 = new Node<>(5);
            Node<Integer> n6 = new Node<>(6);

            n0.setNeighbors(Arrays.asList(n1,n5,n6));
            n1.setNeighbors(Arrays.asList(n3,n4,n5));
            n4.setNeighbors(Arrays.asList(n2,n6));
            n6.setNeighbors(Arrays.asList(n0));

            DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>();
            dfs.traverse(n0);
        }


}

class DepthFirstSearch<T> {
    public void traverse(Node<T> startNode) {
        //Deque can have values added to the beginning and end of the queue. (Double Ended Queue)
        Deque<Node<T>> stack = new LinkedList<>();
        stack.push(startNode);
        System.out.println("Pushed: " + startNode.getData());
        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            System.out.println("Popped: "+ current.getData());
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current);
                Collections.reverse(current.getNeighbors());
                current.getNeighbors().forEach((x) -> {
                        System.out.println("Pushing: " + x.getData());
                        stack.push(x); }
                );
            }
        }
    }
}

class Node<T> {

    public Node(T value) {
        data = value;
    }

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Node<T>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node<T>> neighbors) {
        this.neighbors = neighbors;
    }

    private final T data;
    private boolean visited;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node<T> n: neighbors) {
            sb.append(n.getData() + " ");
        }
        return "Node" + data + " {" +
                "neighbors=" + sb.toString() +
                '}';
    }

    private List<Node<T>> neighbors = new ArrayList<>();


}
