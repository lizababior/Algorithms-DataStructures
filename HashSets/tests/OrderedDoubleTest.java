import org.junit.Assert;
import org.junit.Test;

public class OrderedDoubleTest {
    OrderedDoubleHashSet<Integer> odhs = new OrderedDoubleHashSet<>();
    OrderedDoubleHashSet<Integer> odhsStr = new OrderedDoubleHashSet<>();

    public void fillArr() {
        odhs.insert(19);
        odhs.insert(27);
        odhs.insert(36);
        odhs.insert(10);
        odhs.insert(64);
        odhs.insert(1);
    }

    @Test
    public void size() {
        Assert.assertEquals(0, odhs.size());
        odhs.insert(1);
        Assert.assertEquals(1, odhs.size());
        odhs.remove(1);
        Assert.assertEquals(0, odhs.size());
    }

    @Test
    public void insert() {
        Assert.assertFalse(odhs.insert(null));
        Assert.assertTrue(odhs.insert(1));
        Assert.assertTrue(odhs.insert(8));
        Assert.assertFalse(odhs.insert(1));

        Assert.assertTrue(odhsStr.insert("jhytgrf"));
        Assert.assertFalse(odhsStr.insert("jhytgrf"));
        Assert.assertTrue(odhsStr.insert("jhyt"));
        Assert.assertTrue(odhsStr.insert("jhytgr"));
    }

    @Test
    public void contains() {
        Assert.assertFalse(odhs.contains(null));
        Assert.assertFalse(odhs.contains(36));

        fillArr();

        Assert.assertTrue(odhs.contains(64));
        Assert.assertFalse(odhs.contains(Integer.MAX_VALUE));
    }

    @Test
    public void remove() {
        fillArr();
        Assert.assertFalse(odhs.remove(null));
        Assert.assertTrue(odhs.remove(1));
        Assert.assertFalse(odhs.remove(2));
        Assert.assertFalse(odhs.remove(Integer.MAX_VALUE));
    }

    @Test
    public void toStringPrint() {
        //Don't know how to assert it via test, see main method
        System.out.println(odhs);
        fillArr();
        System.out.println(odhs);
    }

    @Test
    public void clear() {
        fillArr();
        Assert.assertEquals(6, odhs.size());
        odhs.clear();
        Assert.assertEquals(0, odhs.size());
    }
}
