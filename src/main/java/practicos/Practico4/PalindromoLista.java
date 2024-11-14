package practicos.Practico4;

public class PalindromoLista {
    public static boolean esPalindromo(String cadena) {
        cadena = cadena.replaceAll("\\s+", "").toLowerCase();
        int longitud = cadena.length();
        ColaLista cola = new ColaLista();

        // Insertar la primera mitad en la cola
        for (int i = 0; i < longitud / 2; i++) {
            cola.enqueue(cadena.charAt(i));
        }

        // Comparar la segunda mitad con los elementos en la cola
        for (int i = (longitud + 1) / 2; i < longitud; i++) {
            char caracterDeCola = (Character) cola.dequeue();
            if (cadena.charAt(i) != caracterDeCola) {
                return false;
            }
        }
        return true;
    }
}
