package org.example.lab05.DAO;

import java.util.List;

public interface Reposity<T, K>{
    K add(T item);
    List<T> getAll();
    T get(K id);
    boolean update(T item);
    boolean remove(T item);
    boolean removeById(K id);
}
