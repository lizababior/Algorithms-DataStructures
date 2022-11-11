import org.junit.Assert;
import org.junit.Test;

public class ChainingTest {
    ChainingHashSet<Integer> chs = new ChainingHashSet<>();
    ChainingHashSet<String> chsStr = new ChainingHashSet<>();

    public void fillArr() {
        for (int i = -10; i < 10; i++) {
            chs.insert(i);
        }
    }

    @Test
    public void size() {
        Assert.assertEquals(0, chs.size());
        chs.insert(1);
        Assert.assertEquals(1, chs.size());
        chs.remove(1);
        Assert.assertEquals(0, chs.size());
    }

    @Test
    public void insert() {
        Assert.assertTrue(chs.insert(1));
        Assert.assertTrue(chs.insert(8));
        Assert.assertFalse(chs.insert(null));
        Assert.assertFalse(chs.insert(1));

        Assert.assertTrue(chsStr.insert("jhytgrf"));
        Assert.assertTrue(chsStr.insert("jhyt"));
        Assert.assertTrue(chsStr.insert("jhytgr"));
    }

    @Test
    public void contains() {
        fillArr();
        Assert.assertTrue(chs.contains(1));
        Assert.assertFalse(chs.contains(14));
        Assert.assertFalse(chs.contains(null));
    }

    @Test
    public void remove() {
        fillArr();
        Assert.assertFalse(chs.remove(null));
        Assert.assertTrue(chs.remove(1));
        Assert.assertTrue(chs.remove(2));
        Assert.assertFalse(chs.remove(Integer.MAX_VALUE));
    }

    @Test
    public void toStringPrint() {
        //Don't know how to assert it via test, see main method
        System.out.println(chs);
        fillArr();
        System.out.println(chs);
    }

    @Test
    public void clear() {
        fillArr();
        Assert.assertEquals(20, chs.size());
        chs.clear();
        Assert.assertEquals(0, chs.size());
    }
}
