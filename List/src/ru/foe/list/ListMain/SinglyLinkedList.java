package ru.foe.list.ListMain;



public class SinglyLinkedList<T> {
    private ListItem head;
    private int size;

    public int getSize() {
        return size;
    }

    public ListItem getFirst() {
        if (head == null) {
            throw new NullPointerException("first element can't be null");
        }
        return head;
    }

    public SinglyLinkedList copy() {
        SinglyLinkedList newList = new SinglyLinkedList();

        ListItem current = head;

        while (current != null) {
            newList.addFront(current.getData());
            current = current.getNext();
        }
        newList.reverse();
        return newList;
    }


    public T getItem(int index) {
        ListItem<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }


    public T setItem(int index, T data) {
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
        ListItem current = head;
        ListItem<T> parentItem = null;

        for (int i = 0; i < index; i++) {
            parentItem = current;
            current = current.getNext();
        }
        if (parentItem != null) {
            parentItem.setNext(current.getNext());
        }
        return (T) current.getData();
    }

    public void addFront(T data) {
        ListItem<T> newItem = new ListItem<>(data);

        if (head == null) {
            head = newItem;
        } else {
            newItem.setNext(head);
            head = newItem;
        }
    }

    public void insertByIndex(int index, T data) {
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
        ListItem<T> next = null;
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
            sb.append(current.getData() + "\n");
            current = current.getNext();
        }
        return sb.toString();
    }
}