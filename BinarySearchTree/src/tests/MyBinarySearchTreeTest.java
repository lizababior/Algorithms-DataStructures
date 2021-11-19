import com.company.MyBinarySearchTree;
import org.junit.Assert;
import org.junit.jupiter.api.*;

class MyBinarySearchTreeTest {
    MyBinarySearchTree<Integer> intTree = new MyBinarySearchTree<>();

    @BeforeEach
    void setUp() {

    }

    @Test
    void insert() {
        intTree.insert(10);
        intTree.insert(1);
        intTree.insert(5);
        intTree.insert(15);
        intTree.insert(20);
    }

    @Test
    void find() {

    }

    @Test
    void remove() {
    }

    @Test
    void size() {
        Assert.assertEquals(0, intTree.size());
        insert();
        Assert.assertEquals(5, intTree.size());
    }

    @Test
    void toArrayPostOrder() {
    }

    @Test
    void toArrayInOrder() {
    }

    @Test
    void toArrayPreOrder() {
    }

    @Test
    void getParent() {
    }

    @Test
    void isRoot() {
        intTree.insert(10);
        Assert.assertEquals(true, intTree.isRoot(10));

        intTree.insert(1);
        intTree.insert(11);
        Assert.assertEquals(false, intTree.isRoot(1));
        Assert.assertEquals(false, intTree.isRoot(11));
    }

    @Test
    void isInternal() {
    }

    @Test
    void isExternal() {
    }
}