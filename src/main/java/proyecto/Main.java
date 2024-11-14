package proyecto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import practicos.Practico1.Factorial;
import practicos.Practico1.Suma;
import practicos.Practico1.Potencia;
import practicos.Practico1.ConteoRegresivo;
import practicos.Practico1.Producto;
import practicos.Practico1.ArrayInverso;
import practicos.Practico1.ContarUnos;
import practicos.Practico2.MedicionTiempos;
import practicos.Practico2.Ordenamiento;
import practicos.Practico3.Cola;
import practicos.Practico3.Pila;
import practicos.Practico3.OrdenarCola;
import practicos.Practico3.Palindromo;
import practicos.Practico3.VerificarBalanceo;
import practicos.Practico4.ColaLista;
import practicos.Practico4.PilaLista;
import practicos.Practico4.PilaPalabras;
import practicos.Practico4.PalindromoLista;
import practicos.Practico4.PilaLista;
import practicos.Practico4.ConvertirADecimal;
import practicos.Practico4.ColaNumeros;
import practicos.Practico4.OrdenarColaLista;
import practicos.Practico4.VerificarBalanceoLista;
import practicos.Practico5.ArbolBinario;
import practicos.Practico7.ArbolAVL;
import practicos.Practico8.ArbolRojiNegro;
import practicos.Practico9.ColeccionesJava;
import practicos.Practico9.MonticuloBinario;
import practicos.Practico9.TablaHash;
// Importaciones de practicos

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("Seleccione el practico que desea ejecutar:");
            System.out.println("1. Practico 1: Recursividad");
            System.out.println("2. Practico 2: Ordenamiento");
            System.out.println("3. Practico 3: Pila y Cola con Arreglos");
            System.out.println("4. Practico 4: Pila y Cola con Listas Enlazadas");
            System.out.println("5. Practico 5: Arbol Binario 1");
            System.out.println("7. Practico 7: Arbol AVL");
            System.out.println("8. Practico 8: Arbol Rojinegro");
            System.out.println("9. Practico 9: Monticulo Binario, Tabla Hash y General");
            System.out.println("0. Salir");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ejecutarPractico1(scanner);
                    break;
                case 2:
                    ejecutarPractico2(scanner);
                    break;
                case 3:
                    ejecutarPractico3(scanner);
                    break;
                case 4:
                    ejecutarPractico4(scanner);
                    break;
                case 5:
                    ejecutarPractico5(scanner);
                    break;
                case 7:
                    ejecutarPractico7(scanner);
                    break;
                case 8:
                    ejecutarPractico8(scanner);
                    break;
                case 9:
                    ejecutarPractico9();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void ejecutarPractico1(Scanner scanner) {
        System.out.println("Ejecutando Practico 1: Recursividad");
        System.out.println("Seleccione la función a ejecutar:");
        System.out.println("1. Factorial");
        System.out.println("2. Suma de primeros n enteros");
        System.out.println("3. Potencia");
        System.out.println("4. Conteo regresivo");
        System.out.println("5. Multiplicar mediante suma");
        System.out.println("6. Invertir array");
        System.out.println("7. Contar unos");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.print("Ingrese un numero: ");
                int n = scanner.nextInt();
                System.out.println("Factorial de " + n + ": " + Factorial.calcular(n));
                break;
            case 2:
                System.out.print("Ingrese un numero: ");
                n = scanner.nextInt();
                System.out.println("Suma de primeros " + n + " enteros: " + Suma.calcular(n));
                break;
            case 3:
                System.out.print("Ingrese la base: ");
                int base = scanner.nextInt();
                System.out.print("Ingrese el exponente: ");
                int exponente = scanner.nextInt();
                System.out.println(base + "^" + exponente + " = " + Potencia.calcular(base, exponente));
                break;
            case 4:
                System.out.print("Ingrese el numero de inicio: ");
                n = scanner.nextInt();
                ConteoRegresivo.imprimir(n);
                break;
            case 5:
                System.out.print("Ingrese el operando a: ");
                int a = scanner.nextInt();
                System.out.print("Ingrese el operando b: ");
                int b = scanner.nextInt();
                Producto.producto(a, b);
                System.out.println("");
                break;
            case 6:
                int[] array = {1, 2, 3, 4, 5};
                System.out.println("Array original: \n" + Arrays.toString(array));
                System.out.println("Array inverso: ");
                ArrayInverso.arrayInverso(array, array.length - 1);
                System.out.println("");
                break;
            case 7:
                System.out.print("Ingrese un numero: ");
                n = scanner.nextInt();
                System.out.println("cantidad de unos: " + ContarUnos.contarUnos(n));
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }
    
    // Métodos para otros prácticos (ejecutarPractico2, ejecutarPractico3, etc.)
    private static void ejecutarPractico2(Scanner scanner) {
        System.out.println("Ejecutando Practico 2: Ordenamiento");
        System.out.println("Seleccione el algoritmo de ordenamiento:");
        System.out.println("1. Ordenamiento por insercion");
        System.out.println("2. Shellsort");
        System.out.println("3. Quicksort");
        int choice = scanner.nextInt();
        
        System.out.println("Seleccione el tipo de dato:");
        System.out.println("1. int");
        System.out.println("2. double");
        System.out.println("3. string");
        int dataType = scanner.nextInt();

        
        switch (dataType) {
            case 1:
                System.out.print("Ingrese la longitud del array: ");
                int longitud = scanner.nextInt();
                int[] arrayInt = Ordenamiento.generarArray(longitud);
                System.out.println("Array antes de ordenar:");
                Ordenamiento.mostrarArray(arrayInt);

                long tiempo = 0;
                switch (choice) {
                    case 1:
                        tiempo = MedicionTiempos.medirTiempoOrdenamiento(arrayInt, "insercion");
                        break;
                    case 2:
                        tiempo = MedicionTiempos.medirTiempoOrdenamiento(arrayInt, "shell");
                        break;
                    case 3:
                        tiempo = MedicionTiempos.medirTiempoOrdenamiento(arrayInt, "quicksort");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        return;
                }

                System.out.println("Array después de ordenar:");
                Ordenamiento.mostrarArray(arrayInt);
                System.out.println("Tiempo de ejecucion: " + tiempo + " nanosegundos");
                break;
            case 2:
                double[] arrayDouble = {3.3, 6.6, 8.8, 10.1, 1.1, 2.2, 1.1};
                System.out.println("Array antes de ordenar:");
                Ordenamiento.mostrarArray(arrayDouble);

                tiempo = 0;
                switch (choice) {
                    case 1:
                        tiempo = MedicionTiempos.medirTiempoOrdenamiento(arrayDouble, "insercion");
                        break;
                    case 2:
                        tiempo = MedicionTiempos.medirTiempoOrdenamiento(arrayDouble, "shell");
                        break;
                    case 3:
                        tiempo = MedicionTiempos.medirTiempoOrdenamiento(arrayDouble, "quicksort");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        return;
                }

                System.out.println("Array después de ordenar:");
                Ordenamiento.mostrarArray(arrayDouble);
                System.out.println("Tiempo de ejecucion: " + tiempo + " nanosegundos");
                break;
            case 3:
                String[] arrayString = {"zebra", "apple", "mango", "banana"};
                System.out.println("Array antes de ordenar:");
                Ordenamiento.mostrarArray(arrayString);

                tiempo = 0;
                switch (choice) {
                    case 1:
                        tiempo = MedicionTiempos.medirTiempoOrdenamiento(arrayString, "insercion");
                        break;
                    case 2:
                        tiempo = MedicionTiempos.medirTiempoOrdenamiento(arrayString, "shell");
                        break;
                    case 3:
                        tiempo = MedicionTiempos.medirTiempoOrdenamiento(arrayString, "quicksort");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        return;
                }

                System.out.println("Array después de ordenar:");
                Ordenamiento.mostrarArray(arrayString);
                System.out.println("Tiempo de ejecucion: " + tiempo + " nanosegundos");
                break;
            default:
                System.out.println("Opcion no valida.");
                return;
        }
    }

    private static void ejecutarPractico3(Scanner scanner) {
        System.out.println("Ejecutando Practico 3: Pila y Cola con Arreglos");
        System.out.println("Seleccione la estructura de datos:");
        System.out.println("1. Pila");
        System.out.println("2. Cola");
        int choice = scanner.nextInt();

        if (choice == 1) {
            Pila pila = new Pila(5);
            int operation;
            do {
                int number;
                String palabra;
                System.out.println("Seleccione operacion:");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Top");
                System.out.println("4. Check palindromo");
                System.out.println("5. Check expresion matemática");
                System.out.println("6. Salir");
                operation = scanner.nextInt();
                scanner.nextLine();

                switch(operation) {
                    case 1:
                        System.out.println("Ingrese un numero:");
                        number = scanner.nextInt();
                        scanner.nextLine();
                        pila.push(number);
                        break;
                    case 2:
                        pila.pop();
                        break;
                    case 3:
                        pila.peek();
                        break;
                    case 4:
                        System.out.println("Ingrese una palabra:");
                        palabra = scanner.nextLine();
                        System.out.println("¿Es palíndromo? " + Palindromo.esPalindromo(palabra));
                        break;
                    case 5:
                        System.out.println("Ingrese una expresion matematica:");
                        palabra = scanner.nextLine();
                        System.out.println("¿La expresión está balanceada? " + VerificarBalanceo.estaBalanceada(palabra));
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        return;
                }
            } while (operation != 6);
        } else if (choice == 2) {
            Cola cola = new Cola(5);
            int operation;
            do {
                int number;
                String palabra;
                System.out.println("Seleccione operacion:");
                System.out.println("1. enqueue");
                System.out.println("2. dequeue");
                System.out.println("3. Top");
                System.out.println("4. Ordenar");
                System.out.println("5. Salir");
                operation = scanner.nextInt();
                switch(operation) {
                    case 1:
                        System.out.println("Ingrese un numero:");
                        number = scanner.nextInt();
                        scanner.nextLine();
                        cola.enqueue(number);
                        break;
                    case 2:
                        System.out.println(cola.dequeue());
                        break;
                    case 3:
                        System.out.println(cola.peek());
                        break;
                    case 4:
                        System.out.println("Cola antes de ordenar:");
                        Cola colaOriginal = cola;
                        while (!colaOriginal.isEmpty()) {
                            System.out.print(colaOriginal.dequeue() + " ");
                        }

                        Cola colaOrdenada = OrdenarCola.ordenarColaAscendente(cola);
                        System.out.println("\nCola después de ordenar:");
                        while (!colaOrdenada.isEmpty()) {
                            System.out.print(colaOrdenada.dequeue() + " ");
                        }
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        return;
                }
            } while (operation != 5);
        } else {
            System.out.println("Opcion no valida.");
        }
    }
    
    private static void ejecutarPractico4(Scanner scanner) {
        System.out.println("Ejecutando Practico 4: Pila y Cola con Listas Enlazadas");
        System.out.println("Seleccione la estructura de datos:");
        System.out.println("1. Pila");
        System.out.println("2. Cola");
        int choice = scanner.nextInt();

        if (choice == 1) {
            PilaLista<Integer> pila = new PilaLista<>();
            int operation;
            do {
                int number;
                String palabra;
                System.out.println("Seleccione operacion:");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Top");
                System.out.println("4. Pila de palabras");
                System.out.println("5. Check expresion matemática");
                System.out.println("6. Convertir a decimal");
                System.out.println("7. Salir");
                operation = scanner.nextInt();
                scanner.nextLine();

                switch(operation) {
                    case 1:
                        System.out.println("Ingrese un numero:");
                        number = scanner.nextInt();
                        scanner.nextLine();
                        pila.push(number);
                        break;
                    case 2:
                        System.out.println(pila.pop());
                        break;
                    case 3:
                        System.out.println(pila.peek());
                        break;
                    case 4:
                        PilaPalabras.main();
                        break;
                    case 5:
                        System.out.println("Ingrese una expresion matematica: ");
                        palabra = scanner.nextLine();
                        System.out.println("¿La expresión está balanceada? " + VerificarBalanceoLista.verificarBalanceo(palabra));
                        break;
                    case 6:
                        System.out.println("Ingrese un numero:");
                        number = scanner.nextInt();
                        scanner.nextLine();
                        ConvertirADecimal.convertirADecimal(number);
                    default:
                        System.out.println("Opcion no valida.");
                        return;
                }
            } while (operation != 7);
        } else if (choice == 2) {
            ColaLista<Integer> cola = new ColaLista<>();
            int operation;
            do {
                int number;
                String palabra;
                System.out.println("Seleccione operacion:");
                System.out.println("1. enqueue");
                System.out.println("2. dequeue");
                System.out.println("3. Top");
                System.out.println("4. Cola de numeros");
                System.out.println("5. Ordenar");
                System.out.println("6. Palindromo");
                System.out.println("7. Salir");
                operation = scanner.nextInt();
                scanner.nextLine();
                switch(operation) {
                    case 1:
                        System.out.println("Ingrese un numero:");
                        number = scanner.nextInt();
                        scanner.nextLine();
                        cola.enqueue(number);
                        break;
                    case 2:
                        System.out.println(cola.dequeue());
                        break;
                    case 3:
                        System.out.println(cola.peek());
                        break;
                    case 4:
                        ColaNumeros.main();
                        break;
                    case 5:
                        ColaLista<Integer> colaOrdenada = OrdenarColaLista.ordenarColaAscendente(cola);
                        while (!colaOrdenada.isEmpty()) {
                            System.out.print(colaOrdenada.dequeue() + " ");
                        }
                        break;
                    case 6:
                        System.out.println("Ingrese una palabra:");
                        palabra = scanner.nextLine();
                        System.out.println("¿Es palíndromo? " + PalindromoLista.esPalindromo(palabra));
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        return;
                }
            } while (operation != 5);
        } else {
            System.out.println("Opcion no valida.");
        }

        if (choice == 1) {
            PilaLista<Integer> pila = new PilaLista<>();
            pila.push(10);
            pila.push(20);
            System.out.println("Tope de la pila: " + pila.peek());
            System.out.println("Elemento desapilado: " + pila.pop());
        } else if (choice == 2) {
            ColaLista<Integer> cola = new ColaLista<>();
            cola.enqueue(10);
            cola.enqueue(20);
            System.out.println("Frente de la cola: " + cola.peek());
            System.out.println("Elemento desencolado: " + cola.dequeue());
        } else {
            System.out.println("Opcion no valida.");
        }
    }
    
    public static void ejecutarPractico5(Scanner scanner) {
        ArbolBinario arbol = new ArbolBinario();
        int opcion;

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Insertar 10 elementos al árbol");
            System.out.println("2. Mostrar el árbol en inorder");
            System.out.println("3. Calcular cantidad de niveles");
            System.out.println("4. Eliminar un nodo");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    insertarElementosAleatorios(arbol);
                    break;
                case 2:
                    System.out.println("Recorrido inorder del árbol:");
                    arbol.inorder();
                    break;
                case 3:
                    System.out.println("Cantidad de niveles: " + arbol.profundidad());
                    break;
                case 4:
                    System.out.print("Ingrese el valor del nodo a eliminar: ");
                    int valor = scanner.nextInt();
                    arbol.dtree(valor);
                    System.out.println("Árbol después de la eliminación:");
                    arbol.inorder();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);
    }

    private static void insertarElementosAleatorios(ArbolBinario arbol) {
        Random rand = new Random();
        System.out.println("Insertando los siguientes valores:");
        for (int i = 0; i < 10; i++) {
            int valor = rand.nextInt(26);
            // Solo insertar si no está duplicado
            if (arbol.buscar(arbol.raiz, valor) == null) {
                arbol.insertar(valor);
                System.out.print(valor + " ");
            }
        }
        System.out.println();
    }
    
    private static void ejecutarPractico7(Scanner scanner) {
        ArbolAVL arbol = new ArbolAVL();
        int opcion;

        do {
            System.out.print("Seleccione una opción: ");
            System.out.println("1. Generar árbol con los valores (10, 100, 20, 80, 40, 70)");
            System.out.println("2. Generar árbol con los valores (5, 10, 20, 30, 40, 50, 60)");
            System.out.println("3. Eliminar un nodo del árbol (Arbol: 4, 2, 1, 30, 10, 50, 5, 20, 40, 60)");
            System.out.println("4. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int[] valores1 = {10, 100, 20, 80, 40, 70};
                    for (int valor : valores1) {
                        arbol.insertar(valor);
                    }
                    System.out.println("Arbol generado con los valores (10, 100, 20, 80, 40, 70):");
                    arbol.inorder();
                    System.out.println();
                    break;

                case 2:
                    // Insertar los valores 5, 10, 20, 30, 40, 50, 60
                    int[] valores2 = {5, 10, 20, 30, 40, 50, 60};
                    for (int valor : valores2) {
                        arbol.insertar(valor);
                    }
                    System.out.println("Arbol generado con los valores (5, 10, 20, 30, 40, 50, 60):");
                    arbol.inorder();
                    System.out.println();
                    break;

                case 3:
                    // Eliminar los nodos 1 y 30
                    int[] eliminarValores = {1, 30};
                    for (int valor : eliminarValores) {
                        arbol.eliminar(valor);
                        System.out.println("Arbol después de eliminar el nodo " + valor + ":");
                        arbol.inorder();
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
    
    private static void ejecutarPractico8(Scanner scanner) {
        ArbolRojiNegro arbolRojiNegro = new ArbolRojiNegro();
        int opcion;
            
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Visualizar arbol");
            System.out.println("2. Insertar un numero");
            System.out.println("3. Verificar propiedades");
            System.out.println("4. Visualizar altura negra");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Recorrido inorder del arbol RN:");
                    arbolRojiNegro.inorder();
                    break;
                case 2:
                    System.out.println("Ingrese un numero: ");
                    int numero = scanner.nextInt();
                    arbolRojiNegro.insertar(numero);
                    break;
                case 3:
                    arbolRojiNegro.verificarPropiedades();
                    break;
                case 4:
                    arbolRojiNegro.alturaNegra();
                    break;
                default:
                   System.out.println("Opción no válida.");      
            }
        } while (opcion != 5);
    }
    
   public static void ejecutarPractico9() {
        Scanner scanner = new Scanner(System.in);
        MonticuloBinario monticulo = new MonticuloBinario();
        TablaHash tablaHash = new TablaHash(10);

        int opcion;
        do {
            System.out.println("1. Monticulo binario");
            System.out.println("2. Tabla hash");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuMonticuloBinario(scanner, monticulo);
                    break;
                case 2:
                    menuTablaHash(scanner, tablaHash);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void menuMonticuloBinario(Scanner scanner, MonticuloBinario monticulo) {
        int opcion;
        do {
            System.out.println("1. Insertar un nuevo elemento al monticulo");
            System.out.println("2. Extraccion del elemento de mayor prioridad");
            System.out.println("0. Volver");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a insertar: ");
                    int elemento = scanner.nextInt();
                    monticulo.insertar(elemento);
                    monticulo.mostrarMonticulo();
                    break;
                case 2:
                    System.out.println("Monticulo antes de la extracción:");
                    monticulo.mostrarMonticulo();
                    int extraido = monticulo.extraerMayorPrioridad();
                    System.out.println("Elemento extraído: " + extraido);
                    System.out.println("Monticulo después de la extracción:");
                    monticulo.mostrarMonticulo();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void menuTablaHash(Scanner scanner, TablaHash tablaHash) {
        int opcion;
        do {
            System.out.println("1. Insertar un nuevo elemento a la tabla");
            System.out.println("2. Buscar un elemento en la tabla por su clave");
            System.out.println("3. Eliminar un elemento de la tabla por su clave");
            System.out.println("0. Volver");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave del elemento: ");
                    int claveInsertar = scanner.nextInt();
                    System.out.print("Ingrese el valor del elemento: ");
                    String valor = scanner.next();
                    tablaHash.insertar(claveInsertar, valor);
                    tablaHash.mostrarTablaHash();
                    break;
                case 2:
                    System.out.print("Ingrese la clave a buscar: ");
                    int claveBuscar = scanner.nextInt();
                    String resultado = tablaHash.buscar(claveBuscar);
                    System.out.println("Resultado de la búsqueda: " + (resultado != null ? resultado : "No encontrado"));
                    break;
                case 3:
                    System.out.print("Ingrese la clave del elemento a eliminar: ");
                    int claveEliminar = scanner.nextInt();
                    tablaHash.mostrarTablaHash();
                    tablaHash.eliminar(claveEliminar);
                    System.out.println("Tabla después de la eliminación:");
                    tablaHash.mostrarTablaHash();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

}
