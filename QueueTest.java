package nmahfouz_p3;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void enqueue_OneSInteger_ItemExistsAtEndOfQueue() {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        assertEquals(1, queue.size());
        assertEquals(1, queue.peek());
        assertFalse(queue.empty());

    }

    @Test
    void empty_NoElements_ExpectedTrue() {

        // Given Empty Queue
        Queue<String> queue = new Queue<>();
        // When - Check if stack is empty
        boolean isEmpty = queue.empty();

        assertTrue(isEmpty);
    }

    void peek_NotEmpty_ReturnsItemAtTop()
    {
        // Given - Not Empty Queue
        Queue<String> q = new Queue<>();
        q.enqueue("Nouran");

        // When - peek is called
        String actualItem = q.peek();

        // Then - Nouran is returned and size does not change
        assertEquals("Nouran", actualItem);
        assertEquals(1, q.size());
    }


    @Test
    void dequeue() {
        Queue<Double> queue = new Queue<>();
        try
        {
            queue.dequeue();

            fail("No Exception Thrown!");
        }
        catch(NoSuchElementException e)
        {
            System.out.println("NoSuchElementException Thrown: " + e.getMessage());
        }
        catch (Exception e)
        {
            fail("Unexpected Exception: " + e.getMessage());
        }
        queue.enqueue(2.5);
        queue.enqueue(3.0);
        assertEquals(2.5, queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals(3.0, queue.peek());
    }

    @Test
    void size_isEmpty_ReturnsZero()
    {
        // Given - Empty Stack
        Queue<String> q = new Queue<>();

        // When - Size is called
        int acutalSize = q.size();

        // Then - Size returns zero
        assertEquals(0, acutalSize);
    }

    @Test
    void size_NotEmpty_ReturnsCorrectSize()
    {
        // Given - Not Empty Stack
        Queue<String> q = new Queue<>();
        q.enqueue("Nouran");
        q.enqueue("Mahfouz");

        // When - Size is called
        int acutalSize = q.size();

        // Then - Should return expected size
        assertEquals(2, acutalSize);
    }


    @Test
    void element_ToString_ReturnStrigRepresentation() {
        Queue<String> queue = new Queue<>();
        assertEquals("", queue.toString());

        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");
        assertEquals("One Two Three ", queue.toString());
    }
}