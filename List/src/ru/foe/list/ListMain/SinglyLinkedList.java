package ru.foe.list.ListMain;


import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;
    private int modCount;

    public SinglyLinkedList() {
        this.modCount = 0;
    }

    public int getSize() {
        return size;
    }

    public ListItem<T> getFirst() {
        if (head == null) {
            throw new NullPointerException("first element can't be null");
        }
        return head;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();

        ListItem<T> current = head;

        while (current != null) {
            newList.addFront(current.getData());
            current = current.getNext();
        }
        newList.reverse();
        return newList;
    }


    public T getItem(int index) {
        checkIndex(index);

        ListItem<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }


    public T setItem(int index, T data) {
        checkIndex(index);

        ListItem<T> current = head;
        ListItem<T> parentItem = null;
        ListItem<T> newItem = new ListItem<>(data);

        for (int i = 0; i < index; i++) {
            parentItem = current;
            current = current.getNext();
        }
        if (parentItem != null) {
            parentItem.setNext(newItem);
        }
        newItem.setNext(current.getNext());
        return current.getData();
    }

    public T removeByIndex(int index) {
        checkIndex(index);

        ListItem<T> current = head;
        ListItem<T> parentItem = null;

        for (int i = 0; i < index; i++) {
            parentItem = current;
            current = current.getNext();
        }
        if (parentItem != null) {
            parentItem.setNext(current.getNext());
        }
        return current.getData();
    }

    public void addFront(T data) {
        ListItem<T> newItem = new ListItem<>(data, head);

        if (head == null) {
            head = newItem;
        } else {
            newItem.setNext(head);
            head = newItem;
        }
    }

    public void insertByIndex(int index, T data) {
        checkIndex(index);

        ListItem<T> newItem = new ListItem<>(data);
        ListItem<T> current = head;
        ListItem<T> parentItem = null;

        for (int i = 0; i < index; i++) {
            parentItem = current;
            current = current.getNext();
        }
        if (current == head) {
            newItem.setNext(current);
            head = newItem;
        } else {
            newItem.setNext(current);
            parentItem.setNext(newItem);
        }
    }

    public boolean remove(T data) {
        ListItem<T> current = head;
        ListItem<T> parent = null;

        while (current != null) {
            if (current.getData().equals(data)) {
                if (parent == null) {
                    head = null;
                } else {
                    parent.setNext(current.getNext());
                }
                size--;
                return true;
            }
            parent = current;
            current = current.getNext();
        }
        return false;
    }

    public ListItem<T> removeFirst() {
        ListItem<T> temp = head;
        head = head.getNext();
        return temp;
    }

    public void reverse() {
        ListItem<T> next;
        ListItem<T> current = head;
        ListItem<T> parent = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(parent);
            parent = current;
            current = next;
        }
        head = parent;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList:\n");
        ListItem<T> current = head;

        while (current != null) {
            sb.append(current.getData()).append("\n");
            current = current.getNext();
        }
        return sb.toString();
    }

    private class MyListIterator implements Iterator<T> {
        ListItem<T> current;
        ListItem<T> previous;
        ListItem<T> next;
        int expectedModCount = modCount;

        MyListIterator() {
            next = head;
        }

        public T next() {
            checkForModification();

            if (next == null) {
                throw new NoSuchElementException();
            }
            T temp = next.getData();
            previous = current;
            current = next;
            next = next.getNext();
            return temp;
        }

        public boolean hasNext() {
            return next != null;
        }

        public void remove() {
            checkForModification();

            if (current == null) {
                throw new NoSuchElementException();
            }
            if (previous == null) {
                head = current;
            } else {
                previous.setNext(next);
            }
            size--;
        }
        final void checkForModification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    public Iterator<T> iterator() {
        return new MyListIterator();
    }
}