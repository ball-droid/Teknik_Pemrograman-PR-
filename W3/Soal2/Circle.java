package Soal2;

// Class Circle adalah turunan dari Shape
public class Circle extends Shape {

    // Radius lingkaran
    private double radius;

    // Constructor default
    // radius = 1.0
    public Circle() {
        super(); // memanggil constructor Shape
        this.radius = 1.0;
    }

    // Constructor dengan parameter radius
    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    // Constructor lengkap
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    // Getter radius
    public double getRadius() {
        return radius;
    }

    // Setter radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Menghitung luas lingkaran
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Menghitung keliling lingkaran
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Representasi object Circle dalam bentuk String
    @Override
    public String toString() {
        return "Circle[" + super.toString() + ",radius=" + radius + "]";
    }
}