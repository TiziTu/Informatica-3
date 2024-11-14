package practicos.Practico4;

import java.util.LinkedList;

public class ColaLista<T> {
    private LinkedList<T> queue;

    public ColaLista() {
        queue = new LinkedList<>();
    }

    public void enqueue(T value) {
        queue.addLast(value);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Cola vacía.");
            return null;
        }
        return queue.removeFirst();
    }

    public T peek() {
        if (queue.isEmpty()) {
            System.out.println("Cola vacía.");
            return null;
        }
        return queue.peekFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
