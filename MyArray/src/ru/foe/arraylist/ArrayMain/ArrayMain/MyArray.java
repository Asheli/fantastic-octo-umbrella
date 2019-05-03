package ru.foe.arraylist.ArrayMain.ArrayMain;

import java.util.*;

public class MyArray<T> implements List<T> {
    private T[] items;
    private int length;
    private int modCount;

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }


    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < length; i++) {
            if (items[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, length);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < this.length) {
            return (T1[]) Arrays.copyOf(items, this.length, a.getClass());
        }
        System.arraycopy(items, 0, a, 0, this.length);
        if (a.length > this.length) {
            a[this.length] = null;
        }
        return a;
    }


    @Override
    public boolean add(T t) {
        int index = indexOf(t);

        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
            if (o == null) {
                for (int index = 0; index < length; index++)
                    if (items[index] == null) {
                        return true;
                    }
            } else {
                for (int index = 0; index < length; index++)
                    if (o.equals(items[index])) {
                        return true;
                    }
            }
            return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            items[i] = null;
        }
        length = 0;

    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        T temp = items[index];
        items[index] = element;
        return temp;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        if (length >= items.length) {
            increaseCapacity();
        }
        items[index] = element;
        length++;

    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T temp = items[index];
        if (index < length - 1) {
            System.arraycopy(items, index + 1, items, index, length - index - 1);
        }
        length--;
        return temp;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++){
            if (items[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length - 1; i >= 0; i--) {
            if (items[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void trimToSize() {
        modCount++;
        int capacity = items.length;
        if (length < capacity) {
            items = Arrays.copyOf(items, length);
        }
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }
}
