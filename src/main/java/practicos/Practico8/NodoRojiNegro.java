package practicos.Practico8;

public class NodoRojiNegro {
    int valor;
    NodoRojiNegro izquierda, derecha, padre;
    boolean esRojo; // true = rojo, false = negro

    public NodoRojiNegro(int valor) {
        this.valor = valor;
        izquierda = derecha = padre = null;
        this.esRojo = true; // Los nuevos nodos son rojos por defecto
    }
}
