package pl.edu.pw.ee.services;

import java.util.List;

public interface HeapExtension {

    void build();

    void heapify(int startId, int endId);

    <T> List<T> getData();
}
