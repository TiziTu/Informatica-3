package practicos.Practico2;

public class MedicionTiempos {
    public static long medirTiempoOrdenamiento(int[] arr, String tipo) {
        long inicio = System.nanoTime();
        switch (tipo) {
            case "insercion":
                Ordenamiento.insertionSort(arr);
                break;
            case "shell":
                Ordenamiento.shellSort(arr);
                break;
            case "quicksort":
                Ordenamiento.quickSort(arr, 0, arr.length - 1);
                break;
        }
        return System.nanoTime() - inicio;
    }
    
    public static long medirTiempoOrdenamiento(double[] arr, String tipo) {
        long inicio = System.nanoTime();
        switch (tipo) {
            case "insercion":
                Ordenamiento.insertionSort(arr);
                break;
            case "shell":
                Ordenamiento.shellSort(arr);
                break;
            case "quicksort":
                Ordenamiento.quickSort(arr, 0, arr.length - 1);
                break;
        }
        return System.nanoTime() - inicio;
    }
    
    public static long medirTiempoOrdenamiento(String[] arr, String tipo) {
        long inicio = System.nanoTime();
        switch (tipo) {
            case "insercion":
                Ordenamiento.insertionSort(arr);
                break;
            case "shell":
                Ordenamiento.shellSort(arr);
                break;
            case "quicksort":
                Ordenamiento.quickSort(arr, 0, arr.length - 1);
                break;
        }
        return System.nanoTime() - inicio;
    }
}
