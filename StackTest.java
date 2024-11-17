package nmahfouz_p3;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void empty_NoElements_ExpectedTrue()
    {
        // Given - Empty Stack
        Stack<Integer> s = new Stack<>();

        // When - Check if stack is empty
        boolean isEmpty = s.empty();

        // Then - stack should be empty
        assertTrue(isEmpty);
    }

    @Test
    void empty_AtLeastOneElement_ExpectedFalse()
    {
        // Given - Stack with one element
        Stack<Integer> s = new Stack<>();
        s.push(1);

        // When - Check if stack is empty
        boolean isEmpty = s.empty();

        // Then - Stack is !Empty
        assertFalse(isEmpty);
    }

    @Test
    void push_OneString_ItemExistsAtTopOfStack()
    {
        // Given - Empty Stack
        Stack<String> s = new Stack<>();

        // When - Push item to stack
        s.push("Matthew");

        // Then - Stack has 1 item storing "Matthew"
        assertEquals(1, s.size());
        assertFalse(s.empty());
        assertEquals("Matthew", s.peek());
    }

    @Test
    void pop_NotEmpty_ReturnsItem() {
        // Given - A stack with 1 item
        wk5_wed.Stack<String> s = new wk5_wed.Stack<>();
        s.push("Matthew");

        // When - Pop is called
        String actualItem = s.pop();

        // Then - Item "Matthew" is returned and size is decremented by 1
        assertEquals("Matthew", actualItem);
        assertEquals(0, s.size());
    }

    @Test
    void pop_IsEmpty_ThrowsEmptyStackException()
    {
        // Given - Empty Stack
        wk5_wed.Stack<String> s = new wk5_wed.Stack<>();

        // When - pop on empty Stack
        try
        {
            s.pop();

            // Then - EmptyStackException should be thrown (fail if not)
            fail("Expected EmptyStackException");
        }
        catch (EmptyStackException e)
        {
            System.out.println("Threw EmptyStackException");
        }
        catch (Exception e)
        {
            fail("Unexpected Exception Thrown" + e.getMessage());
        }
    }

    @Test
    void peek_NotEmpty_ReturnsItemAtTop()
    {
        // Given - Not Empty Stack
        Stack<String> s = new Stack<>();
        s.push("Matthew");

        // When - peek is called
        String actualItem = s.peek();

        // Then - Matthew is returned and size does not change
        assertEquals("Matthew", actualItem);
        assertEquals(1, s.size());
    }

    @Test
    void peek_IsEmpty_ThrowsEmptyStackException() {
        // Given - Empty Stack
        wk5_wed.Stack<String> s = new wk5_wed.Stack<>();

        // When - peek on empty Stack
        try
        {
            s.peek();

            // Then - EmptyStackException should be thrown (fail if not)
            fail("Expected EmptyStackException in Peek");
        }
        catch (EmptyStackException e)
        {
            System.out.println("Threw EmptyStackException in Peek");
        }
        catch (Exception e)
        {
            fail("Unexpected Exception Thrown in Peek" + e.getMessage());
        }
    }

    @Test
    void size_isEmpty_ReturnsZero()
    {
        // Given - Empty Stack
        Stack<String> s = new Stack<>();

        // When - Size is called
        int acutalSize = s.size();

        // Then - Size returns zero
        assertEquals(0, acutalSize);
    }

    @Test
    void size_NotEmpty_ReturnsCorrectSize()
    {
        // Given - Not Empty Stack
        Stack<String> s = new Stack<>();
        s.push("Matthew");
        s.push("Thayer");

        // When - Size is called
        int acutalSize = s.size();

        // Then - Should return expected size
        assertEquals(2, acutalSize);
    }
}