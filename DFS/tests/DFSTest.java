import com.company.DFS;
import com.company.Node;
import org.junit.Assert;
import org.junit.Test;

public class DFSTest {
    DFS dfs = new DFS(8);

    public void fillGraph() {
        dfs.insertVertex(new Node("A"));
        dfs.insertVertex(new Node("B"));
        dfs.insertVertex(new Node("C"));
        dfs.insertVertex(new Node("D"));

        dfs.insertEdge(0, 1, 8);
        dfs.insertEdge(0, 2, 1);
        dfs.insertEdge(0, 3, 3);
    }

    @Test
    public void isConnected() {
        fillGraph();
        Assert.assertTrue(dfs.isConnected());
        dfs.insertVertex(new Node("E"));
        dfs.insertVertex(new Node("F"));
        dfs.insertVertex(new Node("G"));
        dfs.insertVertex(new Node("H"));

        dfs.insertEdge(4, 5, 2);
        dfs.insertEdge(6, 7, 7);

        Assert.assertFalse(dfs.isConnected());
    }

    @Test
    public void getNumberOfComponents() {
        fillGraph();
        Assert.assertEquals(1, dfs.getNumberOfComponents());
        dfs.insertVertex(new Node("E"));
        dfs.insertVertex(new Node("F"));
        dfs.insertVertex(new Node("G"));
        dfs.insertVertex(new Node("H"));

        dfs.insertEdge(4, 5, 2);
        dfs.insertEdge(6, 7, 7);
        dfs.insertEdge(1, 2, 7);
        dfs.insertEdge(4, 5, 2);
        dfs.insertEdge(6, 7, 7);

        Assert.assertEquals(3, dfs.getNumberOfComponents());
    }

    @Test
    public void isCyclic() {
        fillGraph();
        Assert.assertFalse(dfs.isCyclic());
        //makes cycle
        dfs.insertEdge(1, 2, 7);
        Assert.assertTrue(dfs.isCyclic());
    }

    @Test
    public void printComponents() {
        fillGraph();
        dfs.insertVertex(new Node("E"));
        dfs.insertVertex(new Node("F"));
        dfs.insertVertex(new Node("G"));
        dfs.insertVertex(new Node("H"));

        dfs.insertEdge(4, 5, 2);
        dfs.insertEdge(6, 7, 7);
        dfs.insertEdge(1, 2, 7);
        dfs.insertEdge(4, 5, 2);
        dfs.insertEdge(6, 7, 7);
        //check main Class
        dfs.printComponents();
    }

}
