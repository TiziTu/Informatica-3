package practicos.Practico9;

import java.util.ArrayList;
import java.util.Collections;

public class MonticuloBinario {
    private ArrayList<Integer> heap;

    public MonticuloBinario() {
        heap = new ArrayList<>();
    }

    public void insertar(int elemento) {
        heap.add(elemento);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(i) > heap.get((i - 1) / 2)) {
            Collections.swap(heap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public int extraerMayorPrioridad() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("El montículo está vacío.");
        }
        int raiz = heap.get(0);
        int ultimoElemento = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, ultimoElemento);
            maxHeapify(0);
        }
        return raiz;
    }

    private void maxHeapify(int i) {
        int izquierda = 2 * i + 1;
        int derecha = 2 * i + 2;
        int mayor = i;

        if (izquierda < heap.size() && heap.get(izquierda) > heap.get(mayor)) {
            mayor = izquierda;
        }
        if (derecha < heap.size() && heap.get(derecha) > heap.get(mayor)) {
            mayor = derecha;
        }
        if (mayor != i) {
            Collections.swap(heap, i, mayor);
            maxHeapify(mayor);
        }
    }

    public void mostrarMonticulo() {
        System.out.println(heap);
    }
}

