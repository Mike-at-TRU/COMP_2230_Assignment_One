import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.digiteched.javadsa.ArrayList;
import com.digiteched.javadsa.interfaces.IList;

public class MoreArrayListTests {

    @Test
    public void shiftingWorksBothWays() {
        IList<String> list = new ArrayList<String>(String.class);

        int numberOfStartingItems = 10;

        for (int i = 0; i < numberOfStartingItems; i++) {
            list.add(String.valueOf(i));
        }

        list.remove(3);
        list.remove(7);

        assertEquals("0", list.get(0));
        assertEquals("9", list.get(list.size() - 1));

    }
}
