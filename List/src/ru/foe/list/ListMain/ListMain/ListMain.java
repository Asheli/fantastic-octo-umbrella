package ru.foe.list.ListMain.ListMain;

import ru.foe.list.ListMain.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class ListMain {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> list1 = list.copy();


        list.addFront(1);
        list.addFront(2);
        list.addFront(3);
        list.addFront(4);
        list.addFront(5);
        list.addFront(6);
        list.copy();
        Iterator<Integer> iterator = list.iterator();

        System.out.println(list);
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

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
