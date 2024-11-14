package practicos.Practico1;

// imprimirInverso(array, array.length - 1);
public class ArrayInverso {
    public static void arrayInverso(int[] arr, int index) {
        if (index < 0) {
            return;
        }
        System.out.print(arr[index] + " ");
        arrayInverso(arr, index - 1);
    }
}
