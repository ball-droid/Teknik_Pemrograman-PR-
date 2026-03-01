package Soal2;

// Class Square adalah turunan dari Rectangle
// Pada Square, width dan length HARUS sama
public class Square extends Rectangle {

    // Constructor default
    public Square() {
        super(1.0, 1.0);
    }

    // Constructor dengan parameter side
    public Square(double side) {
        super(side, side);
    }

    // Constructor lengkap
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    // Mengambil nilai sisi
    public double getSide() {
        return width;
    }

    // Mengatur nilai sisi
    // width dan length harus selalu sama
    public void setSide(double side) {
        this.width = side;
        this.length = side;
    }

    // Override setWidth agar tetap square
    @Override
    public void setWidth(double side) {
        setSide(side);
    }

    // Override setLength agar tetap square
    @Override
    public void setLength(double side) {
        setSide(side);
    }

    // Representasi object Square dalam bentuk String
    @Override
    public String toString() {
        return "Square[" + super.toString() + "]";
    }
}