package ru.fou.shapes;

public class Rectangle implements Shape, Comparable<Rectangle> {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (getHeight() + getWidth());
    }

    @Override
    public int compareTo(Rectangle o) {
        if (this.getArea() == o.getArea()){
            return 0;
        } else if (this.getArea() < o.getArea()){
            return -1;
        } else {
            return 1;
        }
    }
}
