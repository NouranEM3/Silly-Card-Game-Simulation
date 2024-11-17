package nmahfouz_p3;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Array Implementation of a stack.
 */
public class Stack<E>{
    private ArrayList<E> s;  // Holds stack elements

    /**
     * Constructor.
     */
    public Stack() {
        s = new ArrayList<>();
    }

    /**
     * The empty method checks for an empty stack.
     *
     * @return true if stack is empty.
     */
    public boolean empty() {
        return s.size() == 0;
    }

    /**
     * The push method pushes a value onto the stack.
     *
     * @param x The value to push onto the stack.
     */
    public void push(E x) {
        s.add(x);
    }

    /**
     * The pop method pops a value off the stack.
     *
     * @return The value popped.
     * @throws EmptyStackException When the stack is empty.
     */
    public E pop() {
        if (empty())
            throw new EmptyStackException();
        else {
            E val = s.get(s.size() - 1);
            s.remove(size() -1);
            return val;
        }
    }

    /**
     * The peek method returns the value at the top of the stack.
     *
     * @return value at top of the stack.
     * @throws EmptyStackException When the stack is empty.
     */
    public E peek() {
        if (empty())
            throw new EmptyStackException();
        else
            return s.get(s.size() - 1);
    }

    /**
     * The size method returns the number of items in the queue.
     *
     * @return
     */
    public int size() {
        return s.size();
    }
}