package Soal2;

public class Main {
    public static void main(String[] args) {

        // Membuat object Shape
        Shape shape = new Shape();

        // Membuat object Circle
        Circle circle = new Circle(2.5, "blue", true);

        // Membuat object Rectangle
        Rectangle rectangle = new Rectangle(3, 4, "green", false);

        // Membuat object Square
        Square square = new Square(5, "yellow", true);

        // Menampilkan hasil
        System.out.println(shape);
        System.out.println(circle);
        System.out.println("Luas Circle: " + circle.getArea());

        System.out.println(rectangle);
        System.out.println("Keliling Rectangle: " + rectangle.getPerimeter());

        System.out.println(square);
        System.out.println("Luas Square: " + square.getArea());
    }
}