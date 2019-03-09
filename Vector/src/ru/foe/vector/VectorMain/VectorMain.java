package ru.foe.vector.VectorMain;

import ru.foe.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new double[]{1.0, 3.0, 4.0, 5.0});
        Vector vector2 = new Vector(new double[]{-1.0, 3.0, -4.0, 5.0, 4.1, -3.1});
        Vector vector3 = new Vector(8, new double[]{1.0, 4.0, -4.0, 12.0, 5.8});
        Vector vector4 = new Vector(new double[]{1.7, 3.2, -10.0, 5.0});
        Vector vector5 = new Vector(new double[]{4.4, 1.1, 12.0, 4.0, -0.3});
        Vector vector6 = new Vector(new double[]{4.7, 1.2, -10.0, 5.0});
        Vector vector7 = new Vector(new double[]{1.0, 6.0, -4.0, 5.3, 4.1, -3.1});
        Vector vector8 = new Vector(8, new double[]{2.0, 2.0, -5.0, 12.1, 5.8});
        Vector vector9 = new Vector(8, new double[]{2.0, 2.0, -5.0, 12.1, 5.8});
        Vector vector10 = new Vector(10);

        System.out.println("Размер вектора 2: " + vector2.getSize());
        vector2.multiplyByScalar(5);
        System.out.println("Умножение вектора на скаляр: " + vector2);
        vector3.reverse();
        System.out.println("Разворот вектора: " + vector3);
        System.out.println("Длина вектора: " + vector1.getLength());
        System.out.println("Компонента вектора по заданному индексу: " + vector4.getComponent(3));
        vector7.add(vector8);
        System.out.println("Прибавление к заданному вектору другой вектор: " + vector7);
        System.out.println("Разность векторов: " + Vector.getDifference(new Vector(new double[]{1.0, 3.0, 4.0, 5.0}), new Vector(new double[]{-1.0, 3.0, -4.0, 5.0, 4.1, -3.1})));
        System.out.println("Скалярное произведение векторов: " + Vector.getScalarMultiplication(new Vector(new double[]{1.0, 3.0, 4.0, 5.0}), new Vector(new double[]{-1.0, 3.0, -4.0, 5.0, 4.1, -3.1})));
        vector4.subtract(vector6);
        System.out.println("Вычитание из одного вектора другой: " + vector4);
        System.out.println("Сумма векторов: " + Vector.getSum(vector5, vector1));
        System.out.println("Проверка на равенство векторов: " + vector8.equals(vector9));
        System.out.println(vector8.hashCode());
        System.out.println(vector9.hashCode());
        vector9.setComponent(3, 10.0);
        System.out.println("Замена компонента по заданному индексу " + vector9);
        System.out.println(vector10);
    }
}
