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
}

