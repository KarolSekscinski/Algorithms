package pl.edu.pw.ee;

public class HashDoubleHashingForOpenAddressing<T extends Comparable<T>> extends HashOpenAdressingForOpenAddressing<T> {


    public HashDoubleHashingForOpenAddressing() {
        super();
    }

    public HashDoubleHashingForOpenAddressing(int size) {
        super(size);
    }
    @Override
    int hashFunc(int key, int i) {

        int m = getSize();

        if(m == 3) {
            throw new ArithmeticException("You cannot create hashTable with size 3 (dividing by zero)!");
        }

        int gHash = 1 + (key % (m-3));

        int fHash = key % m;

        int hash = ((fHash + i * gHash) % m);

        hash = hash < 0 ? -hash : hash;

        return hash;

    }
}
