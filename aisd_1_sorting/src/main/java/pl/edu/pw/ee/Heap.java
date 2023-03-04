package pl.edu.pw.ee;

import java.util.List;

import pl.edu.pw.ee.services.HeapExtension;
import pl.edu.pw.ee.services.HeapInterface;

public class Heap<T extends Comparable<T>> implements HeapInterface<T>, HeapExtension {

    private List<T> data;

    public Heap(List<T> data) {
        this.data = data;
    }

    @Override
    public List<T> getData() {
        return data;
    }

    @Override
    public void put(T item) {

        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null!");
        }
        data.add(item);

    }

    @Override
    public T pop() {
        if (!isItHeap()) {
            throw new IllegalStateException("Cannot pop from unsorted heap!");
        }

        if (data.get(0) == null) {
            throw new ArrayIndexOutOfBoundsException
                    ("Cannot pop from empty heap!");
        }
        swap(0, data.size() - 1);
        T item = data.remove(data.size() - 1);
        heapify(0, data.size() - 1);

        return item;
    }

    @Override
    public void build() {
        int n = data.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i, n);
        }

    }

    @Override
    public void heapify(int startId, int endId) {

        while (true) {

            int parentId = startId;
            int leftChildId = startId * 2 + 1;
            int rightChildId = startId * 2 + 2;

            if (leftChildId < endId && data.get(parentId).compareTo(data.get(leftChildId)) < 0) {
                parentId = leftChildId;
            }
            if (rightChildId < endId && data.get(parentId).compareTo(data.get(rightChildId)) < 0) {
                parentId = rightChildId;
            }
            if (parentId == startId) {
                break;
            }
            swap(parentId, startId);
            startId = parentId;
        }
    }


    private void swap(int firstId, int secondId) {
        T firstVal = data.get(firstId);
        data.set(firstId, data.get(secondId));
        data.set(secondId, firstVal);
    }

    public boolean isItHeap() {
        if (data.isEmpty()) {
            return true;
        }
        for (int i = data.size() / 2 - 1; i > 0; i--) {

            int leftChildId = 2 * i + 1;
            int rightChildId = 2 * i + 2;

            if (leftChildId < data.size() && data.get(i).compareTo(data.get(leftChildId)) < 0) {
                return false;
            }
            if (rightChildId < data.size() && data.get(i).compareTo(data.get(leftChildId)) < 0) {
                return false;
            }
        }
        return true;
    }
}
