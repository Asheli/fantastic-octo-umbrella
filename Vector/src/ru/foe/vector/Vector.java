package ru.foe.vector;

import java.util.Arrays;
import java.util.Objects;

public class Vector {
    private double[] components;
    private int n;

    public Vector(double[] components) {
        this.components = components;
        this.n = components.length;
    }

    public Vector(double[] components, int n) {
        this.n = n;
        this.components = new double[n];

        for (int i = 0; i < n; i++) {
            if (i < components.length) {
                this.components[i] = components[i];
            } else {
                this.components[i] = 0;
            }
        }
    }

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("vector length must be > 0");
        }
        this.n = n;
        components = new double[n];
    }

    private Vector(Vector vector) {
        this.components = vector.components;
        this.n = vector.n;
    }

    public int getSize() {
        return n;
    }

    public Vector addVector(Vector vector) {
        if (this.n < vector.n) {
            double[] temp = this.components;
            this.components = new double[vector.n];

            for (int i = 0; i < vector.n; i++) {
                if (i < temp.length) {
                    this.components[i] = temp[i] + vector.components[i];
                } else {
                    this.components[i] = vector.components[i];
                }
            }
        } else {
            for (int i = 0; i < this.n; i++) {
                if (i < vector.components.length) {
                    this.components[i] = this.components[i] + vector.components[i];
                }
            }
        }
        return new Vector(this);
    }


    public Vector subtractVector(Vector vector) {
        if (this.n < vector.n) {
            double[] temp = this.components;
            this.components = new double[vector.n];

            for (int i = 0; i < vector.n; i++) {
                if (i < temp.length) {
                    this.components[i] = temp[i] - vector.components[i];
                } else {
                    this.components[i] = -vector.components[i];
                }
            }
        }
        for (int i = 0; i < this.n; i++) {
            if (i < vector.components.length) {
                this.components[i] = components[i] - vector.components[i];
            }
        }
        return new Vector(this);
    }

    public void multiplyByScalar(int scalar) {
        for (int i = 0; i < this.n; i++) {
            this.components[i] = this.components[i] * scalar;
        }
    }

    public Vector expandVector() {
        for (int i = 0; i < this.n; i++) {
            this.components[i] = this.components[i] * (-1);
        }
        return new Vector(this);
    }

    public double getComponent(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index can't be < 0");
        }
        return components[index];
    }

    public double getVectorLength() {
        double lengthResult = 0;

        for (int i = 0; i < this.n; i++) {
            lengthResult += Math.pow(components[i], 2);
        }
        return Math.sqrt(lengthResult);
    }

    public static Vector SumVectors(Vector vector1, Vector vector2) {
        if (vector1.n < vector2.n) {
            double[] temp = vector1.components;
            vector1.components = new double[vector2.n];

            for (int i = 0; i < vector2.n; i++) {
                if (i < temp.length) {
                    vector1.components[i] = temp[i] + vector2.components[i];
                } else {
                    vector1.components[i] = vector2.components[i];
                }
            }
        } else {
            for (int i = 0; i < vector1.n; i++) {
                if (i < vector2.components.length) {
                    vector1.components[i] = vector1.components[i] + vector2.components[i];
                }
            }
        }
        return new Vector(vector1);
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
        return n == vector.n && Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(components);
        return hash;
    }

    @Override
    public String toString() {
        String result = "{";
        for (int i = 0; i < this.n; i++) {
            result += this.components[i];
            for (i = 1; i < this.n; i++) {
                result += ", " + this.components[i];
            }
        }
        return result + "}";
    }
}



