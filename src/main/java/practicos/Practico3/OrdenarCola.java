package practicos.Practico3;

public class OrdenarCola {
    public static Cola ordenarColaAscendente(Cola colaOriginal) {
    Cola colaAuxiliar = new Cola(colaOriginal.maxSize);

    while (!colaOriginal.isEmpty()) {
        int temp = colaOriginal.dequeue();

        while (!colaAuxiliar.isEmpty() && colaAuxiliar.peek() < temp) {
            colaOriginal.enqueue(colaAuxiliar.dequeue());
        }
        colaAuxiliar.enqueue(temp);
    }
    
    // Pasar los elementos ordenados a la cola original
    while (!colaAuxiliar.isEmpty()) {
        colaOriginal.enqueue(colaAuxiliar.dequeue());
    }
    
    return colaOriginal;
}
}
