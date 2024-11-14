package practicos.Practico4;

public class ConvertirADecimal {
    public static void convertirADecimal(int numero) {
        PilaLista<Integer> pila = new PilaLista<>();

        while (numero > 0) {
            pila.push(numero % 2);
            numero /= 2;
        }

        StringBuilder binario = new StringBuilder();
        while (!pila.isEmpty()) {
            binario.append(pila.pop());
        }
        System.out.println("Representación binaria de " + numero + ": " + binario.toString());
    }
}
