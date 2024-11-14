package practicos.Practico1;

public class ContarUnos {
    public static int contarUnos(int n) {
        if (n == 0) return 0;
        return (n % 2) + contarUnos(n / 2);
    }
}
