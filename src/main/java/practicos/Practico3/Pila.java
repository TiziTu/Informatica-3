package practicos.Practico3;

public class Pila {
    private int[] stack;
    private int top;
    private int max;

    public Pila(int size) {
        stack = new int[size];
        top = -1;
        max = size;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (top == max - 1) {
            System.out.println("La pila está llena");
        } else {
            stack[++top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return stack[top];
        }
        System.out.println("La pila está vacía");
        return -1;
    }
}
