package ru.foe.vector;

import java.util.Arrays;


public class Vector {
    private double[] components;

    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("vector length must be > 0");
        }
        this.components = components;
    }

    public Vector(int dimension, double[] components) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("vector length must be > 0");
        }
        this.components = Arrays.copyOf(components, dimension);
        Arrays.fill(this.components, components.length, components.length, 0);
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

    public Vector add(Vector vector) {
        if (this.components.length < vector.components.length) {
            double[] temp = this.components;
            this.components = new double[vector.components.length];

            for (int i = 0; i < vector.components.length; i++) {
                if (i < temp.length) {
                    this.components[i] = temp[i] + vector.components[i];
                } else {
                    this.components[i] = vector.components[i];
                }
            }
        }
        for (int i = 0; i < this.components.length; i++) {
            if (i < vector.components.length) {
                this.components[i] = this.components[i] + vector.components[i];
            }
        }
        return new Vector(this);
    }

    public Vector subtract(Vector vector) {
        if (this.components.length < vector.components.length) {
            double[] temp = this.components;
            this.components = new double[vector.components.length];
            for (int i = 0; i < vector.components.length; i++) {
                if (i < temp.length) {
                    this.components[i] = temp[i] - vector.components[i];
                } else {
                    this.components[i] = -vector.components[i];
                }
            }
        }
        for (int i = 0; i < this.components.length; i++) {
            if (i < vector.components.length) {
                this.components[i] = this.components[i] - vector.components[i];
            }
        }
        return new Vector(this);
    }

    public void multiplyByScalar(int scalar) {
        for (int i = 0; i < components.length; i++) {
            this.components[i] = this.components[i] * scalar;
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
            throw new IndexOutOfBoundsException();
        }
        components[index] = component;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        return vector1.subtract(vector2);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        return vector1.add(vector2);
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