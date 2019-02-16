package ru.fou.range;

import java.util.Arrays;

public class RangeMain {
    public static void main(String[] args) {
        Range numericalRange = new Range(2.5, 8.0);
        numericalRange.getLength();

        System.out.println("Пересечение двух интервалов равно: " + numericalRange.getIntersection(new Range(2.0, 5.1)));
        System.out.println("Объединение двух интервалов равно: " + Arrays.toString(numericalRange.getSum(new Range(2.0, 5.1))));
        System.out.println("Разница двух интервалов равна: " + Arrays.toString(numericalRange.getDifference(new Range(3.0, 4.0))));
        System.out.println("Разница двух интервалов равна: " + Arrays.toString(numericalRange.getDifference(new Range(3.0, 8.0))));
        System.out.println(numericalRange.isInside(5.7));
        System.out.println(numericalRange.getFrom());
        numericalRange.setFrom(4.5);
        System.out.println(numericalRange.getFrom());
        System.out.println(numericalRange.getTo());
        numericalRange.setTo(10.6);
        System.out.println(numericalRange.getTo());
    }
}
