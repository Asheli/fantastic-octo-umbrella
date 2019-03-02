package ru.foe.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;
    private int n;

    public Vector(double[] components) {
        this.components = components;
    }

    public Vector(double[] components, int n) {
        this.components = components;
        this.n = n;
    }

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Длина вектора должна быть > нуля");
        }
        this.n = n;
        components = new double[n];
    }

    private Vector(Vector vector) {
        this.components = vector.components;
        this.n = vector.n;
    }

    public int getSize(Vector vector) {
        return components.length;
    }

    public Vector getSum(Vector vector) {
        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] + vector.components[i];
        }
        return new Vector(this);
    }

    @Override
    public String toString() {
        return "Vector " + "components = " + Arrays.toString(components);
    }

}
