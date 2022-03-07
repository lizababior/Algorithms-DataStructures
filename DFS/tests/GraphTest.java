import com.company.Graph;
import com.company.MyVertex;
import com.company.Node;
import org.junit.Assert;
import org.junit.Test;

public class GraphTest {
    Graph graph = new Graph(4);

    public void addVertices() {
        graph.insertVertex(new Node(0));
        graph.insertVertex(new Node(1));
        graph.insertVertex(new Node(2));
        graph.insertVertex(new Node(3));
    }

    public void addEdges() {
        graph.insertEdge(0, 1, 8);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(0, 3, 3);
        graph.insertEdge(1, 2, 7);
    }

    @Test
    public void getNumberOfVertices() {
        Assert.assertEquals(0, graph.getNumberOfVertices());
        graph.insertVertex(new Node(1));
        Assert.assertEquals(1, graph.getNumberOfVertices());
    }

    @Test
    public void getVertices() {
        Assert.assertEquals(4, graph.getVertices().length);
        Assert.assertNull(graph.getVertices()[0]);
        Node n = new Node(5);
        graph.insertVertex(n);
        Assert.assertEquals(4, graph.getVertices().length);
        Assert.assertEquals(n, graph.getVertices()[0]);
    }

    @Test
    public void insertVertex() {
        //null Node
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            graph.insertVertex(null);
        });
        String expectedMessage = "Null is not allowed";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        //number of Nodes
        int l1 = graph.getNumberOfVertices();
        Assert.assertEquals(l1++, graph.insertVertex(new Node(0)));
        graph.insertVertex(new Node(1));
        graph.insertVertex(new Node(2));
        graph.insertVertex(new Node(3));

        //too many Nodes
        exception = Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
            graph.insertVertex(new Node(6));
        });
        expectedMessage = "Max number of nodes is exceeded";
        actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void getEdgeWeight() {
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            graph.getEdgeWeight(6, 7);
        });
        String expectedMessage = "Unknown node index";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            graph.getEdgeWeight(1, 2);
        });
        expectedMessage = "Unknown node index";
        actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        addVertices();
        addEdges();
        Assert.assertEquals(8, graph.getEdgeWeight(0, 1));
    }

    @Test
    public void insertEdge() {
        //null Node
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            graph.insertEdge(1, 2, 3);
        });
        String expectedMessage = "Unknown node index";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        addVertices();

        //out of range
        exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            graph.insertEdge(6, 7, 3);
        });
        expectedMessage = "Unknown node index";
        actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));


        Assert.assertTrue(graph.insertEdge(0, 1, 8));
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(0, 3, 3);
        graph.insertEdge(1, 2, 7);
        Assert.assertFalse(graph.insertEdge(0, 1, 8));
    }

    @Test
    public void getAdjacencyMatrix() {
        addVertices();
        addEdges();

        System.out.println(graph);
    }

    @Test
    public void getAdjacentVertices() {
        addVertices();
        addEdges();

        MyVertex[] arr = new MyVertex[] {new Node(1), new Node(2), new Node(3)};
        Assert.assertEquals(arr.length, graph.getAdjacentVertices(0).length);
    }

}
