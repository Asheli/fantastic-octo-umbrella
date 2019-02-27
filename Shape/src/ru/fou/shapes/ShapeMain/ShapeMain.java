package ru.fou.shapes.ShapeMain;

import ru.fou.shapes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ShapeMain {
    public static void main(String[] args) {
        ArrayList<Shape> shapesArrayList = new ArrayList<Shape>();

        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(5.0, 5.0);
        Point point3 = new Point(0.0, 5.0);
        Point point4 = new Point(1.0, 1.0);
        Point point5 = new Point(6.0, 5.0);
        Point point6 = new Point(1.0, 3.0);
        Triangle triangle1 = new Triangle(point1, point2, point3);
        Triangle triangle2 = new Triangle(point4, point5, point6);
        Circle circle1 = new Circle(10.0);
        Circle circle2 = new Circle(4.6);
        Rectangle rectangle1 = new Rectangle(4.0, 5.9);
        Rectangle rectangle2 = new Rectangle(10.0, 4.3);
        Square square1 = new Square(10.0);
        Square square2 = new Square(3.9);

        shapesArrayList.add(triangle1);
        shapesArrayList.add(triangle2);
        shapesArrayList.add(circle1);
        shapesArrayList.add(circle2);
        shapesArrayList.add(rectangle1);
        shapesArrayList.add(rectangle2);
        shapesArrayList.add(square1);
        shapesArrayList.add(square2);
        

    }
}
