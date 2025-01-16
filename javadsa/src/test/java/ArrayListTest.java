import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.digiteched.javadsa.ArrayList;
import com.digiteched.javadsa.interfaces.IList;

public class ArrayListTest {
    @Test
    public void itShouldCreateAnEmptyList() {
        IList<String> list = new ArrayList<String>(String.class);

        assertEquals(0, list.size());
    }

    @Test
    public void itShouldAddAFirstItem() {
        IList<String> list = new ArrayList<String>(String.class);

        String firstItem = "first";

        list.add(firstItem);

        assertEquals(1, list.size());

        assertEquals(firstItem, list.get(0));
    }

    @Test
    public void itShouldPopUntilEmpty() {
        ArrayList<String> list = new ArrayList<String>(String.class);

        final int NUMBER_OF_ITEMS = 30;

        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            list.add(String.valueOf(i));
        }

        for (int i = NUMBER_OF_ITEMS - 1; i >= 0; i--) {
            String result = list.pop();

            assertEquals(true, result.equals(String.valueOf(i)));
        }

        assertEquals(0, list.size());
    }

    @Test
    public void itShouldPushSeveralItems() {
        ArrayList<String> list = new ArrayList<String>(String.class);

        final int NUMBER_OF_ITEMS = 100;

        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            list.push(String.valueOf(i));
        }

        assertEquals(NUMBER_OF_ITEMS, list.size());

        assertEquals(String.valueOf(NUMBER_OF_ITEMS - 1), list.peek());
    }

    @Test
    public void itShouldGracefullyGrowAndShrink() {
        ArrayList<String> list = new ArrayList<String>(String.class);

        list.add("a");

        list.add("b");

        list.add("c");

        list.add("d");

        list.add("e");

        list.add("f");

        String popped = list.pop();

        assertEquals(true, popped.equals("f"));

        String dequeued = list.dequeue();

        assertEquals(true, dequeued.equals("a"));

        list.dequeue(); // b

        list.dequeue(); // c

        final int NUMBER_OF_ADDITIONAL_ELEMENTS = 50;

        for (int i = 0; i < NUMBER_OF_ADDITIONAL_ELEMENTS; i++) {
            list.add(String.valueOf(i));
        }

        // d and e are left before we add additional elements
        assertEquals(NUMBER_OF_ADDITIONAL_ELEMENTS + 2, list.size());
    }

    @Test
    public void itShouldDequeue() {
        ArrayList<String> list = new ArrayList<String>(String.class);

        list.enqueue("a");

        list.enqueue("b");

        list.enqueue("c");

        list.enqueue("d");

        list.enqueue("e");

        list.enqueue("f");

        String dequeueResult = list.dequeue();

        // First In, First Out
        assertEquals(true, dequeueResult.equals("a"));
    }

    @Test
    public void itShouldSetAnInteriorElement() {
        ArrayList<Integer> list = new ArrayList<>(Integer.class);

        list.add(1);

        list.add(2);

        list.add(3);

        list.add(4);

        list.add(5);

        Integer newValue = 100;

        int targetIndex = 2;

        list.set(targetIndex, newValue);

        Integer result = list.get(targetIndex);

        assertEquals(newValue, result);
    }

    @Test
    public void itShouldRemoveAnInteriorElement() {
        ArrayList<Integer> list = new ArrayList<>(Integer.class);

        Integer successiveValue = 2;

        list.add(0);

        // index 1
        list.add(1);

        list.add(successiveValue);

        list.add(3);

        int targetIndex = 1;

        list.remove(targetIndex);

        Integer result = list.get(targetIndex);

        assertEquals(successiveValue, result);

        assertEquals(3, list.size());
    }

    @Test
    public void itShouldInsertAnInteriorElement() {
        ArrayList<Integer> list = new ArrayList<>(Integer.class);

        list.add(0);

        list.add(1);

        list.add(2);

        Integer elementToAdd = 100;

        int targetIndex = 1;

        list.add(targetIndex, elementToAdd);

        Integer searchResult = list.get(targetIndex);

        assertEquals(elementToAdd, searchResult);

        assertEquals(4, list.size());
    }
}
