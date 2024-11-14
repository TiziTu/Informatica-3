package practicos.Practico4;

import java.util.LinkedList;

public class PilaLista<T> {
    private LinkedList<T> stack;

    public PilaLista() {
        stack = new LinkedList<>();
    }

    public void push(T value) {
        stack.addFirst(value);
    }

    public T pop() {
        if (stack.isEmpty()) {
            System.out.println("Pila vacía.");
            return null;
        }
        return stack.removeFirst();
    }

    public T peek() {
        if (stack.isEmpty()) {
            System.out.println("Pila vacía.");
            return null;
        }
        return stack.peekFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        PilaLista<Integer> pila = new PilaLista<>();
        pila.push(10);
        pila.push(20);
        System.out.println("Elemento en la cima: " + pila.peek());
        pila.pop();
        System.out.println("Elemento en la cima después del pop: " + pila.peek());
    }
}

