package ru.fou.shapes;

public class Triangle implements Shape {
    class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point point1, point2, point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public double getWidth() {
        double width = Math.max(Math.max(point1.x, point2.x), point3.x) - Math.min(Math.min(point1.x, point2.x), point3.x);
        return width;
    }

    public double getHeight() {
        double height = Math.max(Math.max(point1.y, point2.y), point3.y) - Math.min(Math.min(point1.y, point2.y), point3.y);
        return height;
    }

    public double getArea() {
        return (getWidth() * getHeight()) / 2;
    }

    public double getPerimeter() {
        double sideLength1 = Math.sqrt(Math.pow((point2.x - point1.x), 2) + Math.pow((point2.y - point1.y), 2));
        double sideLength2 = Math.sqrt(Math.pow((point3.x - point1.x), 2) + Math.pow((point3.y - point1.y), 2));
        double sideLength3 = Math.sqrt(Math.pow((point3.x - point2.x), 2) + Math.pow((point3.y - point2.y), 2));

        return sideLength1 + sideLength2 + sideLength3;
    }
}

