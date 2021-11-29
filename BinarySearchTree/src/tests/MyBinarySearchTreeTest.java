import com.company.MyBinarySearchTree;
import org.junit.Assert;
import org.junit.jupiter.api.*;

class MyBinarySearchTreeTest {
    MyBinarySearchTree<Integer> intTree = new MyBinarySearchTree<>();

    private Object getNewRoot(Object[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return arr[i - 1];
            }
        }
        return null;
    }

    private void fillInt() {
        intTree.insert(10);
        intTree.insert(1);
        intTree.insert(5);
        intTree.insert(15);
        intTree.insert(20);
        intTree.insert(0);
        intTree.insert(11);
    }

    @Test
    void insert() {
        fillInt();
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            intTree.insert(null);
        });
        String expectedMessage = "Null is not allowed";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            intTree.insert(11);
        });
        expectedMessage = "Duplicates are not allowed";
        actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void find() {
        fillInt();
        int n = 10;
        Assert.assertNull(intTree.find(Integer.MIN_VALUE));
        Assert.assertEquals((Integer) n, intTree.find(10));

        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            intTree.find(null);
        });
        String expectedMessage = "Null is not allowed";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void remove() {
        insert();
        int size = intTree.size();
        Object newRoot = getNewRoot(intTree.toArrayInOrder(), 10);
        intTree.remove(10);
        Assert.assertEquals(size - 1, intTree.size());
        Assert.assertEquals(false, intTree.isRoot(10));
        Assert.assertEquals(true, intTree.isRoot((Integer) newRoot));

        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            intTree.remove(null);
        });
        String expectedMessage = "Null is not allowed";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void size() {
        Assert.assertEquals(0, intTree.size());
        insert();
        Assert.assertEquals(7, intTree.size());
        intTree.remove(5);
        Assert.assertEquals(6, intTree.size());
    }

    @Test
    void toArrayPostOrder() {
        fillInt();
        Assert.assertArrayEquals(new Object[]{0, 5, 1, 11, 20, 15, 10}, intTree.toArrayPostOrder());
    }

    @Test
    void toArrayInOrder() {
        fillInt();
        Assert.assertArrayEquals(new Object[]{0, 1, 5, 10, 11, 15, 20}, intTree.toArrayInOrder());
    }

    @Test
    void toArrayPreOrder() {
        fillInt();
        Assert.assertArrayEquals(new Object[]{10, 1, 0, 5, 15, 11, 20}, intTree.toArrayPreOrder());
    }

    @Test
    void getParent() {
        fillInt();
        Assert.assertEquals((Integer) 15, intTree.getParent(11));
        Assert.assertEquals((Integer) 1, intTree.getParent(5));

        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            intTree.getParent(null);
        });
        String expectedMessage = "Null is not allowed";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        Assert.assertNull(intTree.getParent(Integer.MAX_VALUE));
    }

    @Test
    void isRoot() {
        intTree.insert(10);
        Assert.assertTrue(intTree.isRoot(10));

        intTree.insert(1);
        intTree.insert(11);
        Assert.assertFalse(intTree.isRoot(1));
        Assert.assertFalse(intTree.isRoot(11));
    }

    @Test
    void isInternal() {
        fillInt();
        Assert.assertTrue(intTree.isInternal(1));
        Assert.assertTrue(intTree.isInternal(15));
        Assert.assertFalse(intTree.isInternal(0));

        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            intTree.isInternal(null);
        });
        String expectedMessage = "Null is not allowed";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void isExternal() {
        fillInt();
        Assert.assertTrue(intTree.isExternal(5));
        Assert.assertTrue(intTree.isExternal(20));

        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            intTree.isExternal(null);
        });
        String expectedMessage = "Null is not allowed";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}