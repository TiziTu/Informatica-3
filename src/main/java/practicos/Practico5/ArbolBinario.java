package practicos.Practico5;

public class ArbolBinario {
    public NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private NodoArbol insertarRecursivo(NodoArbol nodo, int valor) {
        if (nodo == null) {
            nodo = new NodoArbol(valor);
            return nodo;
        }
        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        return nodo;
    }

    // Recorrido inorder
    public void inorder() {
        inorderRecursivo(raiz);
    }

    private void inorderRecursivo(NodoArbol nodo) {
        if (nodo != null) {
            inorderRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorderRecursivo(nodo.derecho);
        }
    }

    public int profundidad() {
        return calcularProfundidad(raiz);
    }

    private int calcularProfundidad(NodoArbol nodo) {
        if (nodo == null) return 0;
        int profundidadIzq = calcularProfundidad(nodo.izquierdo);
        int profundidadDer = calcularProfundidad(nodo.derecho);
        return Math.max(profundidadIzq, profundidadDer) + 1;
    }

    public void dtree(int valor) {
        raiz = eliminarNodo(raiz, valor);
    }

    private NodoArbol eliminarNodo(NodoArbol nodo, int valor) {
        if (nodo == null) {
            System.out.println("Nodo con valor " + valor + " no encontrado.");
            return nodo;
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = eliminarNodo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = eliminarNodo(nodo.derecho, valor);
        } else {
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            nodo.valor = obtenerMinimo(nodo.derecho);
            nodo.derecho = eliminarNodo(nodo.derecho, nodo.valor);
        }
        return nodo;
    }

    private int obtenerMinimo(NodoArbol nodo) {
        int min = nodo.valor;
        while (nodo.izquierdo != null) {
            min = nodo.izquierdo.valor;
            nodo = nodo.izquierdo;
        }
        return min;
    }

    public NodoArbol buscar(NodoArbol nodo, int valor) {
        if (nodo == null) return null;
        if (valor == nodo.valor) return nodo;
        if (valor < nodo.valor) return buscar(nodo.izquierdo, valor);
        return buscar(nodo.derecho, valor);
    }
}
