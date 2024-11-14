package practicos.Practico3;

public class Cola {
    private int[] queue;
    private int front, rear;
    public int maxSize;

    public Cola(int size) {
        maxSize = size;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
    }
    
    public boolean isEmpty() {
        return rear < front;
    }

    
    

    public void enqueue(int value) {
        if (rear == maxSize - 1) {
            System.out.println("Cola llena, no se puede agregar el elemento.");
        } else {
            queue[++rear] = value;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Cola vacía, no se puede extraer el elemento.");
            return -1;
        } else {
            int value = queue[front];
            for (int i = 0; i < rear; i++) {
                queue[i] = queue[i + 1];
            }
            rear--;
            return value;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return queue[front];
        }
        System.out.println("La cola está vacía");
        return -1;
    }
}
