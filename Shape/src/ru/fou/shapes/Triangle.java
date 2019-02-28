package ru.fou.shapes;


public class Triangle implements Shape {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    private static double getLength(Point point1, Point point2) {
        return Math.sqrt(Math.pow((point2.getX() - point1.getX()), 2) + Math.pow((point2.getY() - point1.getY()), 2));
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(point1.getX(), point2.getX()), point3.getX()) - Math.min(Math.min(point1.getX(), point2.getX()), point3.getX());
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(point1.getY(), point2.getY()), point3.getY()) - Math.min(Math.min(point1.getY(), point2.getY()), point3.getY());
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs(point1.getX() * point2.getY() + point2.getX() * point3.getY() + point3.getX() * point1.getY() - point2.getX() * point1.getY() - point3.getX() * point2.getY() - point1.getX() * point3.getY());
    }

    @Override
    public double getPerimeter() {
        return getLength(point1, point2) + getLength(point1, point3) + getLength(point2, point3);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ", " + "Width = " + getWidth() + ", " + "Height = " + getHeight() + ", " + " Area = " + getArea() + ", " + "Perimeter = " + getPerimeter() + ", " + "Point 1: " + point1 + ", " + "Point 2: " + point2 + ", " + "Point 3: " + point3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return point1 == triangle.point1 && point2 == triangle.point2 && point3 == triangle.point3;
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;
        hash = prime * hash + (point1 != null ? point1.hashCode() : 0);
        hash = prime * hash + (point2 != null ? point2.hashCode() : 0);
        hash = prime * hash + (point3 != null ? point3.hashCode() : 0);
        return hash;
    }
}


