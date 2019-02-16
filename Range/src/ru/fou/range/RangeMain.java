package ru.fou.range;

public class RangeMain {
    public static void main(String[] args) {
        Range numericalRange = new Range(2.5, 8.0);
        numericalRange.getLength();


        System.out.println(numericalRange.isInside(5.7));
        System.out.println(numericalRange.getFrom());
        numericalRange.setFrom(4.5);
        System.out.println(numericalRange.getFrom());
        System.out.println(numericalRange.getTo());
        numericalRange.setTo(10.6);
        System.out.println(numericalRange.getTo());
    }
}
