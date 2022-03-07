import com.company.AVLTree;
import org.junit.Assert;
import org.junit.Test;

public class AVLTreeTest {

    AVLTree<Integer> tree = new AVLTree<>();

    private void fillInt() {
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);
    }

    @Test
    public void size() {
        Assert.assertEquals(0, tree.size());
        tree.insert(1);
        Assert.assertEquals(1, tree.size());
        tree.remove(1);
        Assert.assertEquals(0, tree.size());
    }

    @Test
    public void height() {
        Assert.assertEquals(0, tree.height());
        tree.insert(1);
        Assert.assertEquals(1, tree.height());
        fillInt();
        Assert.assertEquals(4, tree.height());
    }

    @Test
    public void insert() {
        fillInt();
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> tree.insert(null));
        String expectedMessage = "Null is not allowed";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        exception = Assert.assertThrows(IllegalArgumentException.class, () -> tree.insert(30));
        expectedMessage = "Tree already contains a node with key ";
        actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void find() {
        fillInt();
        int n = 10;
        Assert.assertNull(tree.find(Integer.MIN_VALUE));
        Assert.assertEquals((Integer) n, tree.find(10));

        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> tree.find(null));
        String expectedMessage = "Null is not allowed";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void remove() {
        tree.insert(10);
        tree.remove(10);
        Assert.assertEquals(0, tree.size());

        fillInt();
        int size = tree.size();
        tree.remove(10);
        Assert.assertEquals(size - 1, tree.size());

        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> tree.remove(null));
        String expectedMessage = "Null is not allowed";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void toArray() {
        fillInt();
        Assert.assertArrayEquals(new Object[]{10, 25, 20, 50, 40, 30}, tree.toArray());
    }

    @Test
    public void crashTest() {
        for (int i = 0; i < 1000; i++) {
            tree.insert((int) (Math.random() * 20000001));
        }
    }
}
