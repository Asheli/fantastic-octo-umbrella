package ru.foe.list.ListMain.ListMain;

import ru.foe.list.ListMain.ListItem;
import ru.foe.list.ListMain.SinglyLinkedList;

import java.util.Iterator;

public class ListMain {
    public static void main(String[] args) {
        SinglyLinkedList<Object> list = new SinglyLinkedList<>();
        SinglyLinkedList<Object> list1 = list.copy();
       // Iterator<String> iterator = list.iterator();
        list.addFront(1);
        list.addFront(2);
        list.addFront(3);
        list.addFront(4);
        list.addFront(5);
        list.addFront(6);
        list.copy();
        ListItem<Integer> listItem = new ListItem<>(10,null);
        ListItem<Integer> listItem1 = new ListItem<>(11,listItem);
        ListItem<Integer> listItem2 = new ListItem<>(listItem1);
        list.addFront(listItem);

        System.out.println(list);
        System.out.println("Значение первого элемента листа " + list.getFirst());
        System.out.println("Получение значения по индексу " + list.getItem(3));
        System.out.println("Изменение значения по индексу(выдает старое значение) " + list.setItem(3, 10));
        System.out.println("Удаление элемента по индексу(выдает значение элемента)" + list.removeByIndex(4));
        System.out.println(list);
        list.insertByIndex(5, 15);
        System.out.println("Удаление узла по значению " + list.remove(10));
        System.out.println("Удаление первого значения(выдает значение элемента) " + list.removeFirst());
        list.reverse();
        System.out.println(list1);
        System.out.println(list.getSize());
    }
}