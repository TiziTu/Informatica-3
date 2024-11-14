package practicos.Practico1;

public class Producto {
    public static int producto(int a, int b) {
        if (b == 0) return 0;
        return a + producto(a, b - 1);
    }
}
