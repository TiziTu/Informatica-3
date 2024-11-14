package practicos.Practico4;

import java.util.Scanner;

public class PilaPalabras {
    public static void main() {
        PilaLista<String> pila = new PilaLista<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese palabras (escriba 'salir' para finalizar):");
        while (true) {
            String palabra = scanner.nextLine();
            if (palabra.equalsIgnoreCase("salir")) break;
            pila.push(palabra);
        }

        System.out.println("Palabras en orden inverso:");
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
}
