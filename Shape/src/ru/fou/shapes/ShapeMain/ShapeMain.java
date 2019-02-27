package ru.fou.shapes.ShapeMain;

import ru.fou.shapes.*;

import java.util.Arrays;


public class ShapeMain {
    public static void main(String[] args) {
        Point point1 = new Point(0.0, 0.0);
        Point point2 = new Point(5.0, 5.0);
        Point point3 = new Point(0.0, 5.0);
        Point point4 = new Point(1.0, 1.0);
        Point point5 = new Point(6.0, 5.0);
        Point point6 = new Point(1.0, 3.0);
        Point point7 = new Point(0.0, 0.0);
        Point point8 = new Point(-5.0, -5.0);
        Point point9 = new Point(0.0, -5.0);
        Triangle triangle1 = new Triangle(point1, point2, point3);
        Triangle triangle2 = new Triangle(point4, point5, point6);
        Triangle triangle3 = new Triangle(point7, point8, point9);

        Circle circle1 = new Circle(10.0);
        Circle circle2 = new Circle(4.6);
        Rectangle rectangle1 = new Rectangle(4.0, 5.9);
        Rectangle rectangle2 = new Rectangle(10.0, 4.3);
        Square square1 = new Square(10.0);
        Square square2 = new Square(3.9);

        Shape[] shapes = new Shape[]{triangle1, triangle2, circle1, circle2, rectangle1, rectangle2, square1, square2};
        System.out.println("Фигура с максимальной площадью: " + getShapeWithMaxArea(shapes));
        System.out.println("Фигура со вторым по величине периметром:" +  getShapeWithSecondPerimeter(shapes));
        System.out.println("Проверка на равенство треугольников = " + triangle1.equals(triangle3));
        System.out.println(triangle1.hashCode());
        System.out.println(triangle3.hashCode());

    }

    private static Shape getShapeWithSecondPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, new PerimeterComparator());
        return shapes[1];
    }

    private static Shape getShapeWithMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, new AreaComparator());
        return shapes[0];
    }
}

