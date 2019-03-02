package ru.foe.vector.VectorMain;

import ru.foe.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector vector = new Vector(new double[]{1.0, 3.0, 4.0, 5.0});
        Vector vector1 = new Vector(new double[]{1.0, 3.0, 4.0, 5.0});
        System.out.println(vector.toString());
        System.out.println(vector.getSum(vector1));
    }
}
