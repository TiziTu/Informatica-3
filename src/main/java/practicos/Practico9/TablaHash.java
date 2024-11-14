package practicos.Practico9;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class TablaHash {
    private LinkedList<Entry>[] table;
    private int capacidad;

    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        table = new LinkedList[capacidad];
        for (int i = 0; i < capacidad; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int clave) {
        return clave % capacidad;
    }

    public void insertar(int clave, String valor) {
        int indice = hash(clave);
        for (Entry entry : table[indice]) {
            if (entry.clave == clave) {
                entry.valor = valor;
                return;
            }
        }
        table[indice].add(new Entry(clave, valor));
    }

    public String buscar(int clave) {
        int indice = hash(clave);
        for (Entry entry : table[indice]) {
            if (entry.clave == clave) {
                return entry.valor;
            }
        }
        return null;
    }

    public void eliminar(int clave) {
        int indice = hash(clave);
        table[indice].removeIf(entry -> entry.clave == clave);
    }

    public void mostrarTablaHash() {
        for (int i = 0; i < capacidad; i++) {
            System.out.print(i + ": ");
            for (Entry entry : table[i]) {
                System.out.print("(" + entry.clave + ", " + entry.valor + ") ");
            }
            System.out.println();
        }
    }

    private static class Entry {
        int clave;
        String valor;

        Entry(int clave, String valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }
}

