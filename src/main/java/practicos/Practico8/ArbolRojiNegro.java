package practicos.Practico8;

public class ArbolRojiNegro {
    private NodoRojiNegro raiz;

    // Rotación izquierda
    private void rotacionIzquierda(NodoRojiNegro nodo) {
        NodoRojiNegro temp = nodo.derecha;
        nodo.derecha = temp.izquierda;
        if (temp.izquierda != null) temp.izquierda.padre = nodo;
        temp.padre = nodo.padre;
        if (nodo.padre == null) raiz = temp;
        else if (nodo == nodo.padre.izquierda) nodo.padre.izquierda = temp;
        else nodo.padre.derecha = temp;
        temp.izquierda = nodo;
        nodo.padre = temp;
    }

    // Rotación derecha
    private void rotacionDerecha(NodoRojiNegro nodo) {
        NodoRojiNegro temp = nodo.izquierda;
        nodo.izquierda = temp.derecha;
        if (temp.derecha != null) temp.derecha.padre = nodo;
        temp.padre = nodo.padre;
        if (nodo.padre == null) raiz = temp;
        else if (nodo == nodo.padre.derecha) nodo.padre.derecha = temp;
        else nodo.padre.izquierda = temp;
        temp.derecha = nodo;
        nodo.padre = temp;
    }

    // Inserción
    public void insertar(int valor) {
        NodoRojiNegro nuevoNodo = new NodoRojiNegro(valor);
        raiz = insertarNodo(raiz, nuevoNodo);
        ajustarInsercion(nuevoNodo);
        System.out.println("Árbol después de insertar " + valor + ":");
        visualizar(raiz, "", true);
        System.out.println("===================================");
    }

    private NodoRojiNegro insertarNodo(NodoRojiNegro raiz, NodoRojiNegro nodo) {
        if (raiz == null) return nodo;

        if (nodo.valor < raiz.valor) {
            raiz.izquierda = insertarNodo(raiz.izquierda, nodo);
            raiz.izquierda.padre = raiz;
        } else if (nodo.valor > raiz.valor) {
            raiz.derecha = insertarNodo(raiz.derecha, nodo);
            raiz.derecha.padre = raiz;
        }
        return raiz;
    }

    private void ajustarInsercion(NodoRojiNegro nodo) {
        while (nodo != raiz && nodo.padre.esRojo) {
            NodoRojiNegro abuelo = nodo.padre.padre;

            if (nodo.padre == abuelo.izquierda) { // El padre es hijo izquierdo
                NodoRojiNegro tio = abuelo.derecha;

                if (tio != null && tio.esRojo) { // Caso 1: El tío es rojo
                    nodo.padre.esRojo = false;
                    tio.esRojo = false;
                    abuelo.esRojo = true;
                    nodo = abuelo;
                } else { // Tío es negro o nulo
                    if (nodo == nodo.padre.derecha) { // Caso 2: Nodo es hijo derecho
                        nodo = nodo.padre;
                        rotacionIzquierda(nodo);
                    }
                    // Caso 3: Nodo es hijo izquierdo
                    nodo.padre.esRojo = false;
                    abuelo.esRojo = true;
                    rotacionDerecha(abuelo);
                }
            } else { // El padre es hijo derecho
                NodoRojiNegro tio = abuelo.izquierda;

                if (tio != null && tio.esRojo) { // Caso 1: El tío es rojo
                    nodo.padre.esRojo = false;
                    tio.esRojo = false;
                    abuelo.esRojo = true;
                    nodo = abuelo;
                } else { // Tío es negro o nulo
                    if (nodo == nodo.padre.izquierda) { // Caso 2: Nodo es hijo izquierdo
                        nodo = nodo.padre;
                        rotacionDerecha(nodo);
                    }
                    // Caso 3: Nodo es hijo derecho
                    nodo.padre.esRojo = false;
                    abuelo.esRojo = true;
                    rotacionIzquierda(abuelo);
                }
            }
        }
        raiz.esRojo = false;
    }
    
    // Eliminar nodo
    // Eliminación con ilustración de cada paso
    public void eliminar(int valor) {
        NodoRojiNegro eliminarNodo = buscarNodo(raiz, valor);
        if (eliminarNodo == null) return;
        
        eliminarNodo(eliminarNodo);
        System.out.println("Árbol después de eliminar " + valor + ":");
        visualizar(raiz, "", true);
        System.out.println("===================================");
    }
    
    private NodoRojiNegro buscarNodo(NodoRojiNegro nodo, int valor) {
        while (nodo != null && nodo.valor != valor) {
            if (valor < nodo.valor) nodo = nodo.izquierda;
            else nodo = nodo.derecha;
        }
        return nodo;
    }
    
    private void eliminarNodo(NodoRojiNegro nodo) {
        NodoRojiNegro nodoReemplazo = nodo;
        boolean originalColor = nodoReemplazo.esRojo;

        NodoRojiNegro nodoAjuste;
        if (nodo.izquierda == null) {
            nodoAjuste = nodo.derecha;
            trasplantar(nodo, nodo.derecha);
        } else if (nodo.derecha == null) {
            nodoAjuste = nodo.izquierda;
            trasplantar(nodo, nodo.izquierda);
        } else {
            nodoReemplazo = obtenerMinimo(nodo.derecha);
            originalColor = nodoReemplazo.esRojo;
            nodoAjuste = nodoReemplazo.derecha;
            if (nodoReemplazo.padre == nodo) {
                nodoAjuste.padre = nodoReemplazo;
            } else {
                trasplantar(nodoReemplazo, nodoReemplazo.derecha);
                nodoReemplazo.derecha = nodo.derecha;
                nodoReemplazo.derecha.padre = nodoReemplazo;
            }
            trasplantar(nodo, nodoReemplazo);
            nodoReemplazo.izquierda = nodo.izquierda;
            nodoReemplazo.izquierda.padre = nodoReemplazo;
            nodoReemplazo.esRojo = nodo.esRojo;
        }
        if (!originalColor) {
            ajustarEliminacion(nodoAjuste);
        }
    }
    
    private void trasplantar(NodoRojiNegro u, NodoRojiNegro v) {
        if (u.padre == null) {
            raiz = v;
        } else if (u == u.padre.izquierda) {
            u.padre.izquierda = v;
        } else {
            u.padre.derecha = v;
        }
        if (v != null) {
            v.padre = u.padre;
        }
    }

    private NodoRojiNegro obtenerMinimo(NodoRojiNegro nodo) {
        while (nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }
    
    private void ajustarEliminacion(NodoRojiNegro nodo) {
        while (nodo != raiz && !nodo.esRojo) {
            if (nodo == nodo.padre.izquierda) {
                NodoRojiNegro hermano = nodo.padre.derecha;
                if (hermano.esRojo) { // Caso 1: El hermano es rojo
                    hermano.esRojo = false;
                    nodo.padre.esRojo = true;
                    rotacionIzquierda(nodo.padre);
                    hermano = nodo.padre.derecha;
                }
                if (!hermano.izquierda.esRojo && !hermano.derecha.esRojo) { // Caso 2: Los hijos de hermano son negros
                    hermano.esRojo = true;
                    nodo = nodo.padre;
                } else {
                    if (!hermano.derecha.esRojo) { // Caso 3: El hijo derecho de hermano es negro
                        hermano.izquierda.esRojo = false;
                        hermano.esRojo = true;
                        rotacionDerecha(hermano);
                        hermano = nodo.padre.derecha;
                    }
                    hermano.esRojo = nodo.padre.esRojo; // Caso 4: El hijo derecho de hermano es rojo
                    nodo.padre.esRojo = false;
                    hermano.derecha.esRojo = false;
                    rotacionIzquierda(nodo.padre);
                    nodo = raiz;
                }
            } else { // Caso simétrico si el nodo es hijo derecho
                NodoRojiNegro hermano = nodo.padre.izquierda;
                if (hermano.esRojo) {
                    hermano.esRojo = false;
                    nodo.padre.esRojo = true;
                    rotacionDerecha(nodo.padre);
                    hermano = nodo.padre.izquierda;
                }
                if (!hermano.derecha.esRojo && !hermano.izquierda.esRojo) {
                    hermano.esRojo = true;
                    nodo = nodo.padre;
                } else {
                    if (!hermano.izquierda.esRojo) {
                        hermano.derecha.esRojo = false;
                        hermano.esRojo = true;
                        rotacionIzquierda(hermano);
                        hermano = nodo.padre.izquierda;
                    }
                    hermano.esRojo = nodo.padre.esRojo;
                    nodo.padre.esRojo = false;
                    hermano.izquierda.esRojo = false;
                    rotacionDerecha(nodo.padre);
                    nodo = raiz;
                }
            }
        }
        nodo.esRojo = false;
    }

    // Visualización del árbol (inorder)
    public void visualizar(NodoRojiNegro nodo, String indentacion, boolean esDerecha) {
        if (nodo != null) {
            System.out.println(indentacion + (esDerecha ? "Derecha: " : "Izquierda: ") + 
                               nodo.valor + (nodo.esRojo ? " (Rojo)" : " (Negro)"));
            visualizar(nodo.izquierda, indentacion + "   ", false);
            visualizar(nodo.derecha, indentacion + "   ", true);
        }
    }
    
    // Verificar propiedades
    public boolean verificarPropiedades() {
        return verificarPropiedades(raiz, 0, -1);
    }

    private boolean verificarPropiedades(NodoRojiNegro nodo, int conteoNegros, int referenciaNegros) {
        if (nodo == null) return true;

        if (!nodo.esRojo) conteoNegros++;

        if (nodo.izquierda == null && nodo.derecha == null) {
            if (referenciaNegros == -1) referenciaNegros = conteoNegros;
            else return referenciaNegros == conteoNegros;
        }
        return verificarPropiedades(nodo.izquierda, conteoNegros, referenciaNegros) &&
               verificarPropiedades(nodo.derecha, conteoNegros, referenciaNegros);
    }
    
    // Calculo altura negra
    public int alturaNegra() {
        return alturaNegra(raiz);
    }

    private int alturaNegra(NodoRojiNegro nodo) {
        if (nodo == null) return 0;
        int alturaIzquierda = alturaNegra(nodo.izquierda);
        int alturaDerecha = alturaNegra(nodo.derecha);
        return (nodo.esRojo ? 0 : 1) + Math.max(alturaIzquierda, alturaDerecha);
    }
    
    // Visualización del árbol (inorder)
    public void inorder() {
        inorderRecursivo(raiz);
    }

    private void inorderRecursivo(NodoRojiNegro nodo) {
        if (nodo != null) {
            inorderRecursivo(nodo.izquierda);
            System.out.print(nodo.valor + (nodo.esRojo ? " (Rojo) " : " (Negro) "));
            inorderRecursivo(nodo.derecha);
        }
    }
}
