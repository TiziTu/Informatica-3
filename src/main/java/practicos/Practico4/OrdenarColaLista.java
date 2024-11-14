package practicos.Practico4;

public class OrdenarColaLista {
    public static ColaLista<Integer> ordenarColaAscendente(ColaLista<Integer> cola) {
        PilaLista<Integer> pilaAuxiliar = new PilaLista<>();

        while (!cola.isEmpty()) {
            int temp = cola.dequeue();
            while (!pilaAuxiliar.isEmpty() && pilaAuxiliar.peek() > temp) {
                cola.enqueue(pilaAuxiliar.pop());
            }
            pilaAuxiliar.push(temp);
        }

        while (!pilaAuxiliar.isEmpty()) {
            cola.enqueue(pilaAuxiliar.pop());
        }
        return cola;
    }
}
