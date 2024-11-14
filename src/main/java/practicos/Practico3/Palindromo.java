package practicos.Practico3;

public class Palindromo {
    public static boolean esPalindromo(String cadena) {
        cadena = cadena.replaceAll("\\s+", "").toLowerCase();
        int longitud = cadena.length();
        Pila pila = new Pila(longitud / 2);

        for (int i = 0; i < longitud / 2; i++) {
            pila.push(cadena.charAt(i));
        }

        for (int i = (longitud + 1) / 2; i < longitud; i++) {
            if (cadena.charAt(i) != pila.pop()) {
                return false;
            }
        }
        return true;
    }
}
