package ru.foe.vector.VectorMain;

import ru.foe.vector.Vector;


public class VectorMain {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new double[]{1.0, 3.0, 4.0, 5.0});
        Vector vector2 = new Vector(new double[]{-1.0, 3.0, -4.0, 5.0, 4.1, -3.1});
        Vector vector3 = new Vector(new double[]{1.0, 4.0, -4.0, 12.0, 5.8}, 8);
        Vector vector4 = new Vector(new double[]{1.7, 3.2, -10.0, 5.0});
        System.out.println(vector1.toString());
        System.out.println(vector2.getSize());
        System.out.println(vector1.subtractVector(vector2));
        vector2.multiplyByScalar(5);
        System.out.println(vector2);
        System.out.println(vector3.expandVector());
        System.out.println(vector3.getVectorLength());
        System.out.println(vector4.getComponent(3));
        System.out.println(vector2.toString());

        System.out.println(Vector.SumVectors(new Vector(new double[]{1.0, 3.0, 4.0, 5.0}), new Vector(new double[]{-1.0, 3.0, -4.0, 5.0, 4.1, -3.1})));
    }
}