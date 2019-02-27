package ru.fou.shapes;

import java.util.Arrays;

public class Triangle implements Shape {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    private double getLength(Point point1, Point point2) {
        return Math.sqrt(Math.pow((point2.x - point1.x), 2) + Math.pow((point2.y - point1.y), 2));
    }

    public double getWidth() {
        return Math.max(Math.max(point1.x, point2.x), point3.x) - Math.min(Math.min(point1.x, point2.x), point3.x);
    }

    public double getHeight() {
        return Math.max(Math.max(point1.y, point2.y), point3.y) - Math.min(Math.min(point1.y, point2.y), point3.y);
    }

    public double getArea() {
        return 0.5 * Math.abs(point1.x * point2.y + point2.x * point3.y + point3.x * point1.y - point2.x * point1.y - point3.x * point2.y - point1.x * point3.y);
    }

    public double getPerimeter() {
        return getLength(point1, point2) + getLength(point1, point3) + getLength(point2, point3);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ", " + "Width = " + getWidth() + ", " + "Height = " + getHeight() + ", " + " Area = " + getArea() + ", " + "Perimeter = " + getPerimeter();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        double[] lengths = new double[]{getLength(this.point1, this.point2), getLength(this.point1, this.point3), getLength(this.point2, this.point3)};
        Arrays.sort(lengths);
        Triangle triangle = (Triangle) o;
        double[] triangleLengths = new double[]{getLength(triangle.point1, triangle.point2), getLength(triangle.point1, triangle.point3), getLength(triangle.point2, triangle.point3)};
        Arrays.sort(triangleLengths);
        return Arrays.equals(lengths, triangleLengths);
    }

    @Override
    public int hashCode() {
        double[] lengths = new double[]{getLength(this.point1, this.point2), getLength(this.point1, this.point3), getLength(this.point2, this.point3)};
        final int prime = 17;
        int hash = 1;

        for (double length : lengths) {
            hash = prime * hash + Double.hashCode(length);
        }
        return hash;
    }
}

