package practicos.Practico1;

public class ConteoRegresivo {
    public static void imprimir(int n) {
        if (n <= 0) return;
        System.out.println(n);
        imprimir(n - 1);
    }
}
