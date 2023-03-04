package pl.edu.pw.ee;

public class HashQuadraticProbingForOpenAddressing<T extends Comparable<T>> extends HashOpenAdressingForOpenAddressing<T> {

    private double A = 0.5;

    private double B = 0.5;

    public HashQuadraticProbingForOpenAddressing() {
        super();
    }

    public HashQuadraticProbingForOpenAddressing(int size, double a, double b) {
        super(size);
        this.A = a;
        this.B = b;
    }

    @Override
    int hashFunc(int key, int i) {

        int m = getSize();

        int fHash = key % m;

        if (A == 0 || B == 0) {
            throw new IllegalStateException("Const value cannot be zero!");
        }

        int hash = (int) ((fHash + A * i + B * i * i) % m);

        hash = hash < 0 ? -hash : hash;

        return hash;
    }
}
