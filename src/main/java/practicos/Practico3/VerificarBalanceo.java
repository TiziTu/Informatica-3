package practicos.Practico3;

public class VerificarBalanceo {
    public static boolean estaBalanceada(String expresion) {
        Pila pila = new Pila(expresion.length());

        for (char c : expresion.toCharArray()) {
            if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                if (pila.isEmpty() || pila.pop() != '(') {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }
}
