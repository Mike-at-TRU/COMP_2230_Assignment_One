import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import com.digiteched.javadsa.LinkedQueue;
import com.digiteched.javadsa.exceptions.FailedToDequeueFromEmptyQueueException;
import com.digiteched.javadsa.interfaces.IQueue;
import com.digiteched.javadsa.exceptions.FailedToDequeueFromEmptyQueueException;

@SuppressWarnings("unused")
public class LinkedQueueTest {
    @Test
    public void itShouldCreateAnEmptyQueue() {
        IQueue<Integer> q = new LinkedQueue<Integer>();

        assertEquals(0, q.size());
    }

    @Test
    public void itShouldEnqueueAFirstItem() {
        IQueue<Integer> q = new LinkedQueue<>();

        Integer firstValue = 55;

        q.enqueue(firstValue);

        assertEquals(1, q.size());

        Integer firstOut = q.dequeue();

        assertEquals(55, firstOut.intValue());

        assertEquals(0, q.size());
    }

    @Test
    public void itShouldExpandAsNeeded() {
        final int INITIAL_SIZE = 3;

        IQueue<Integer> q = new LinkedQueue<>();

        for (int i = 0; i < INITIAL_SIZE; i++) {
            q.enqueue(i);
        }

        q.enqueue(INITIAL_SIZE + 1);

        assertEquals(q.size(), INITIAL_SIZE + 1);
    }

    @Test
    public void itShouldPopTilEmpty() {
        final int INITIAL_SIZE = 3;

        IQueue<Integer> q = new LinkedQueue<>();

        for (int i = 0; i < INITIAL_SIZE; i++) {
            q.enqueue(i);
        }

        for (int i = 0; i < INITIAL_SIZE; i++) {
            int result = q.dequeue();

            assertEquals(i, result);
        }
    }

    @Test
    public void itShouldThrowWhenDequeueingFromEmptyQueue() {
        IQueue<String> q = new LinkedQueue<String>();

        assertThrows(FailedToDequeueFromEmptyQueueException.class, () -> {
            q.dequeue();
        });
    }
}
