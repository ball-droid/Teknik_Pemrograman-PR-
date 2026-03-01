public class Cylinder extends Circle { // Save as "Cylinder.java"
    private double height; // private variable

    // Constructor with default color, radius and height
    public Cylinder() {
        super(); // call superclass no-arg constructor Circle()
        this.height = 1.0;
    }

    // Constructor with default radius, color but given height
    public Cylinder(double height) {
        super(); // call superclass no-arg constructor Circle()
        this.height = height;
    }

    // Constructor with default color, but given radius, height
    public Cylinder(double radius, double height) { // string color ditambah untuk memnuhi parameter TestCylinder.java
        super(radius); // call superclass constructwaor Circle(radius)
        this.height = height;
    }

    // Constructor dengan dradius, color, dan height, buat memnuhi c4 di
    // TestCylinder.java
    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    // A public method for retrieving the height
    public double getHeight() {
        return height;
    }

    // Setter height, agar code testcyliunder.java tidak error dan bisa mengubah
    // nilai height
    public void setHeight(double height) {
        this.height = height;
    }

    // A public method for computing the volume of cylinder
    // use superclass method getArea() to get the base area

    public double getVolume() {
        return super.getArea() * height; // getArea dari Circle, bukan yang sudah dioverride di Cylinder, jawabanB
    }

    @Override
    public double getArea() {
        // luas permukaan tabung buat bagian B
        return 2 * Math.PI * getRadius() * height
                + 2 * super.getArea();
    }

    @Override
    public String toString() {
        return "Cylinder: subclass of " + super.toString()
                + " height=" + height;
    }
}
