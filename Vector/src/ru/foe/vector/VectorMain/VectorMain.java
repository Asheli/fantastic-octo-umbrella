package ru.foe.vector.VectorMain;

import ru.foe.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new double[]{1.0, 3.0, 4.0, 5.0});
        Vector vector2 = new Vector(new double[]{-1.0, 3.0, -4.0, 5.0, 4.1, -3.1});
        Vector vector3 = new Vector(new double[]{1.0, 4.0, -4.0, 12.0, 5.8}, 8);
        Vector vector4 = new Vector(new double[]{1.7, 3.2, -10.0, 5.0});
        Vector vector5 = new Vector(new double[]{4.4, 1.1, 12.0, 4.0, -0.3});
        Vector vector6 = new Vector(new double[]{4.7, 1.2, -10.0, 5.0});
        Vector vector7 = new Vector(new double[]{1.0, 6.0, -4.0, 5.3, 4.1, -3.1});
        Vector vector8 = new Vector(new double[]{2.0, 2.0, -5.0, 12.1, 5.8}, 8);
        Vector vector9 = new Vector(new double[]{2.0, 2.0, -5.0, 12.1, 5.8}, 8);

        System.out.println("Размер вектора 2: " + vector2.getSize());
        vector2.multiplyByScalar(5);
        System.out.println("Умножение вектора на скаляр: " + vector2);
        System.out.println("Разворот вектора: " + vector3.expandVector());
        System.out.println("Длина вектора: " + vector1.getVectorLength());
        System.out.println("Компонента вектора по заданному индексу: " + vector4.getComponent(3));
        System.out.println("Прибавление к заданному вектору другой вектор: " + vector7.addVector(vector8));
        System.out.println("Разность векторов: " + Vector.getDifferenceVectors(new Vector(new double[]{1.0, 3.0, 4.0, 5.0}), new Vector(new double[]{-1.0, 3.0, -4.0, 5.0, 4.1, -3.1})));
        System.out.println("Скалярное произведение векторов: " + Vector.getVectorsScalarMultiplication(new Vector(new double[]{1.0, 3.0, 4.0, 5.0}), new Vector(new double[]{-1.0, 3.0, -4.0, 5.0, 4.1, -3.1})));
        System.out.println("Вычитание из одного вектора другой: " + vector4.subtractVector(vector6));
        System.out.println("Сумма векторов: " + Vector.SumVectors(vector5, vector1));
        System.out.println("Проверка на равенство векторов: "+ vector8.equals(vector9));
        System.out.println(vector8.hashCode());
        System.out.println(vector9.hashCode());
    }
}