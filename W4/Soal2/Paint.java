package Soal2;

// ===== Paint.java =====
public class Paint {
    private double coverage;

    public Paint(double c) {
        coverage = c;
    }

    public double amount(Shape s) {
        System.out.println("Computing amount for " + s);
        return s.area() / coverage; // diperbaiki dari return 0
    }
}
