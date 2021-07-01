package com.zgz.data_structure.array;

public interface MyList<E> {
    public int size();
    boolean isEmpty();
    boolean isContains(E element);
    void add(E element);
    E get(int index);
    E set(int index,E element);
    void add(int index,E element);
    E remove(int index);
    void removeAll();
    void clear();
    int indexOf(int index);
}
