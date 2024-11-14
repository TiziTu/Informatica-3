package practicos.Practico7;

public class ArbolAVL {
    private NodoAVL raiz;

    // Método para insertar un nodo en el árbol AVL
    public void insertar(int valor) {
        raiz = insertarNodo(raiz, valor);
    }

    private NodoAVL insertarNodo(NodoAVL nodo, int valor) {
        if (nodo == null) return new NodoAVL(valor);
        
        if (valor < nodo.valor) nodo.izquierdo = insertarNodo(nodo.izquierdo, valor);
        else if (valor > nodo.valor) nodo.derecho = insertarNodo(nodo.derecho, valor);
        else return nodo;

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        int balance = obtenerBalance(nodo);
        if (balance > 1 && valor < nodo.izquierdo.valor) return rotacionDerecha(nodo);
        if (balance < -1 && valor > nodo.derecho.valor) return rotacionIzquierda(nodo);
        if (balance > 1 && valor > nodo.izquierdo.valor) {
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }
        if (balance < -1 && valor < nodo.derecho.valor) {
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }
        return nodo;
    }

    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;
        x.derecho = y;
        y.izquierdo = T2;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;
        y.izquierdo = x;
        x.derecho = T2;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        return y;
    }

    private int altura(NodoAVL nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    private int obtenerBalance(NodoAVL nodo) {
        return nodo == null ? 0 : altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    // Método para eliminar un nodo
    public void eliminar(int valor) {
        raiz = eliminarNodo(raiz, valor);
    }

    private NodoAVL eliminarNodo(NodoAVL raiz, int valor) {
        if (raiz == null) {
            System.out.println("El nodo con valor " + valor + " no existe.");
            return raiz;
        }

        if (valor < raiz.valor) raiz.izquierdo = eliminarNodo(raiz.izquierdo, valor);
        else if (valor > raiz.valor) raiz.derecho = eliminarNodo(raiz.derecho, valor);
        else {
            if (raiz.izquierdo == null || raiz.derecho == null) {
                NodoAVL temp = raiz.izquierdo != null ? raiz.izquierdo : raiz.derecho;
                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else raiz = temp;
            } else {
                NodoAVL temp = obtenerMin(raiz.derecho);
                raiz.valor = temp.valor;
                raiz.derecho = eliminarNodo(raiz.derecho, temp.valor);
            }
        }

        if (raiz == null) return raiz;

        raiz.altura = 1 + Math.max(altura(raiz.izquierdo), altura(raiz.derecho));

        int balance = obtenerBalance(raiz);
        if (balance > 1 && obtenerBalance(raiz.izquierdo) >= 0) return rotacionDerecha(raiz);
        if (balance > 1 && obtenerBalance(raiz.izquierdo) < 0) {
            raiz.izquierdo = rotacionIzquierda(raiz.izquierdo);
            return rotacionDerecha(raiz);
        }
        if (balance < -1 && obtenerBalance(raiz.derecho) <= 0) return rotacionIzquierda(raiz);
        if (balance < -1 && obtenerBalance(raiz.derecho) > 0) {
            raiz.derecho = rotacionDerecha(raiz.derecho);
            return rotacionIzquierda(raiz);
        }
        return raiz;
    }

    private NodoAVL obtenerMin(NodoAVL nodo) {
        NodoAVL actual = nodo;
        while (actual.izquierdo != null) actual = actual.izquierdo;
        return actual;
    }

    // Recorrido inorder
    public void inorder() {
        inorderRecursivo(raiz);
    }

    private void inorderRecursivo(NodoAVL nodo) {
        if (nodo != null) {
            inorderRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorderRecursivo(nodo.derecho);
        }
    }
}