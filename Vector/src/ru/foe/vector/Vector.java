package ru.foe.vector;

import java.util.Arrays;


public class Vector {
    private double[] components;

    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("vector length must be > 0");
        }
        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int dimension, double[] components) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("vector length must be > 0");
        }
        this.components = Arrays.copyOf(components, dimension);
    }

    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("vector length must be > 0");
        }
        components = new double[dimension];
    }

    private Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.getSize());
    }

    public int getSize() {
        return components.length;
    }

    public void add(Vector vector) {
        Vector temp = new Vector(this);
        this.components = new double[Math.max(temp.getSize(), vector.getSize())];

        for (int i = 0; i < this.getSize(); i++) {
            if (i < temp.getSize()) {
                components[i] += temp.getComponent(i);
            }
            if (i < vector.getSize()) {
                components[i] += vector.getComponent(i);
            }
        }
    }

    public void subtract(Vector vector) {
        Vector temp = new Vector(this);
        this.components = new double[Math.max(temp.getSize(), vector.getSize())];

        for (int i = 0; i < this.getSize(); i++) {
            if (i < temp.getSize()) {
                components[i] += temp.getComponent(i);
            }
            if (i < vector.getSize()) {
                components[i] -= vector.getComponent(i);
            }
        }
    }

    public void multiplyByScalar(int scalar) {
        for (int i = 0; i < components.length; i++) {
            this.components[i] *= scalar;
        }
    }

    public void reverse() {
        multiplyByScalar(-1);
    }

    public double getLength() {
        double lengthResult = 0;

        for (double component : this.components) {
            lengthResult += Math.pow(component, 2);
        }
        return Math.sqrt(lengthResult);
    }

    public double getComponent(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException();
        }
        return components[index];
    }

    public void setComponent(int index, double component) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds [ " + 0 + " ; " + (this.getSize() - 1) + " ].");
        }
        components[index] = component;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector result = new Vector(Math.max(vector1.getSize(), vector2.getSize()));
        result.add(vector1);
        result.subtract(vector2);
        return result;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector result = new Vector(Math.max(vector1.getSize(), vector2.getSize()));
        result.add(vector1);
        result.add(vector2);
        return result;
    }

    public static double getScalarMultiplication(Vector vector1, Vector vector2) {
        int minLength = Math.min(vector1.getSize(), vector2.getSize());
        double result = 0;

        for (int i = 0; i < minLength; i++) {
            result += vector1.components[i] * vector2.components[i];
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vector vector = (Vector) o;
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        for (double component : this.components) {
            sb.append(component);
            sb.append(", ");
        }
        sb.replace(sb.length() - 2, sb.length() - 1, " }");
        return sb.toString();
    }
}