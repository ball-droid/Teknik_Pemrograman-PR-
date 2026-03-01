package Soal2;

// Class Rectangle adalah turunan dari Shape
public class Rectangle extends Shape {

    // Lebar dan panjang rectangle
    protected double width;
    protected double length;

    // Constructor default
    // width dan length bernilai 1.0
    public Rectangle() {
        super();
        this.width = 1.0;
        this.length = 1.0;
    }

    // Constructor dengan parameter width dan length
    public Rectangle(double width, double length) {
        super();
        this.width = width;
        this.length = length;
    }

    // Constructor lengkap
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    // Getter width
    public double getWidth() {
        return width;
    }

    // Setter width
    public void setWidth(double width) {
        this.width = width;
    }

    // Getter length
    public double getLength() {
        return length;
    }

    // Setter length
    public void setLength(double length) {
        this.length = length;
    }

    // Menghitung luas rectangle
    public double getArea() {
        return width * length;
    }

    // Menghitung keliling rectangle
    public double getPerimeter() {
        return 2 * (width + length);
    }

    // Representasi object Rectangle dalam bentuk String
    @Override
    public String toString() {
        return "Rectangle[" + super.toString() +
                ",width=" + width +
                ",length=" + length + "]";
    }
}