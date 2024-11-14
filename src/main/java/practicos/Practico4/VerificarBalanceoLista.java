package practicos.Practico4;

public class VerificarBalanceoLista {
    public static boolean verificarBalanceo(String expresion) {
        PilaLista<Character> pila = new PilaLista<>();

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

    public static void main(String[] args) {
        String expresion = "((3+2)*5)";
        System.out.println("¿Paréntesis balanceados? " + verificarBalanceo(expresion));
    }
}
