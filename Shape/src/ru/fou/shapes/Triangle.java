package ru.fou.shapes;

public class Triangle implements Shape {
    private double x1, x2, x3, y1, y2, y3;

    public Triangle(double x1, double x2, double x3, double y1, double y2, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public double getWidth() {
        double width = Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
        return width;
    }

    public double getHeight() {
        double height = Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
        return height;
    }

    public double getArea() {
        return (getWidth() * getHeight()) / 2;
    }

    public double getPerimeter() {
        double sideLength1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double sideLength2 = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
        double sideLength3 = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));

        return sideLength1 + sideLength2 + sideLength3;
    }
}

