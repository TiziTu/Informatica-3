package practicos.Practico4;

import java.util.Scanner;

public class ColaNumeros {
    public static void main() {
        ColaLista<Integer> cola = new ColaLista<>();
        Scanner scanner = new Scanner(System.in);
        int suma = 0;

        System.out.println("Ingrese números (escriba -1 para terminar):");
        while (true) {
            int numero = scanner.nextInt();
            if (numero == -1) break;
            cola.enqueue(numero);
        }

        while (!cola.isEmpty()) {
            suma += cola.dequeue();
        }
        System.out.println("La suma de los números es: " + suma);
    }
}
