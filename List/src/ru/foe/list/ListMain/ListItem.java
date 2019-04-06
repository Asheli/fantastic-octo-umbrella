package ru.foe.list.ListMain;

import java.util.Iterator;

public class ListItem<T> {
    private T data;
    private ListItem<T> next;

    public ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }


    public ListItem(ListItem<T> next) {
        this.next = next;
    }

    ListItem(T data) {
        this.data = data;
    }

    ListItem<T> getNext() {
        return next;
    }

    void setNext(ListItem<T> next) {
        this.next = next;
    }

    T getData() {
        return data;
    }

    private void setData() {
        setData();
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

