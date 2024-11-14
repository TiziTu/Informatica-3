package practicos.Practico1;

public class Potencia {
    public static int calcular(int base, int exponente) {
        if (exponente == 0) return 1;
        return base * calcular(base, exponente - 1);
    }
}
