package ru.fou.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public Range getIntersection(Range rangeTwo) {
        if (this.from <= rangeTwo.getTo() && this.to >= rangeTwo.getFrom()) {
            double from = Math.max(this.from, rangeTwo.getFrom());
            double to = Math.min(this.to, rangeTwo.getTo());
            return new Range(from, to);
        } else
            return null;
    }

    public String toString() {
        return "Range: " + this.from + " " + this.to;
    }

    public Range[] getSum(Range rangeTwo) {
        if (this.from <= rangeTwo.getTo() && this.to >= rangeTwo.getFrom()) {
            double from = Math.min(this.from, rangeTwo.getFrom());
            double to = Math.max(this.to, rangeTwo.getTo());
            return new Range[]{new Range(from, to)};
        } else {
            return new Range[]{this, rangeTwo};
        }
    }

    public Range[] getDifference(Range rangeTwo) {
        double epsilon = 1.0e-10;

        if ((this.from - rangeTwo.getFrom()) < epsilon || (this.to - rangeTwo.getTo()) > epsilon) {
            if ((this.from - rangeTwo.getFrom()) < epsilon && (this.to - rangeTwo.getTo()) > epsilon) {
                return new Range[]{new Range(from, rangeTwo.getFrom() - epsilon), new Range(rangeTwo.getTo() + epsilon, this.to)};
            } else if ((this.from - rangeTwo.getFrom()) < epsilon) {
                return new Range[]{new Range(from, rangeTwo.getFrom() - epsilon)};
            } else {
                return new Range[]{new Range(rangeTwo.getTo() + epsilon, this.to)};
            }
        } else {
            return null;
        }
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double x) {
        return (x >= this.from && x <= this.to);
    }
}