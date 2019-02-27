package ru.fou.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public Range getIntersection(Range range) {
        if (this.from <= range.getTo() && this.to >= range.getFrom()) {
            double from = Math.max(this.from, range.getFrom());
            double to = Math.min(this.to, range.getTo());
            return new Range(from, to);
        } else
            return null;
    }

    public String toString() {
        return "Range: " + this.from + " " + this.to;
    }

    public Range[] getSum(Range range) {
        if (this.from <= range.getTo() && this.to >= range.getFrom()) {
            double from = Math.min(this.from, range.getFrom());
            double to = Math.max(this.to, range.getTo());
            return new Range[]{new Range(from, to)};
        } else {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        }
    }

    public Range[] getDifference(Range range) {
        if ((this.from > range.getFrom() && this.to > range.getFrom()) || (this.from < range.getFrom() && this.to < range.getFrom())) {
            return null;
        }
        if ((this.from < range.getFrom() && (this.to > range.getTo()))) {
            return new Range[]{new Range(from, range.getFrom()), new Range(range.getTo(), this.to)};
        } else if ((this.from < range.getFrom())) {
            return new Range[]{new Range(from, range.getFrom())};
        } else {
            return new Range[]{new Range(range.getTo(), this.to)};
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