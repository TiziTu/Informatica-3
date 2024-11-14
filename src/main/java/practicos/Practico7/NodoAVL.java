package practicos.Practico7;

public class NodoAVL {
    int valor;
    NodoAVL izquierdo, derecho;
    int altura;

    public NodoAVL(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 1;
    }
}