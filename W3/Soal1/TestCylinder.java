public class TestCylinder { // save as "TestCylinder.java"
    private static void printCylinder(String label, Cylinder c) {
        System.out.println(label + ": "
                + "radius=" + c.getRadius()
                + ", color=" + c.getColor()
                + ", height=" + c.getHeight()
                + ", base area=" + c.getArea()
                + ", volume=" + c.getVolume());
    }

    public static void main(String[] args) {
        // Declare and allocate a new instance of cylinder
        // with default color, radius, and height
        Cylinder c1 = new Cylinder();
        printCylinder("c1 (default)", c1);

        // Declare and allocate a new instance of cylinder
        // specifying height, with default color and radius
        Cylinder c2 = new Cylinder(10.0);
        printCylinder("c2 (height only)", c2);

        // Declare and allocate a new instance of cylinder
        // specifying radius and height, with default color
        Cylinder c3 = new Cylinder(2.0, 10.0);
        printCylinder("c3 (radius + height)", c3);

        // Declare and allocate a new instance of cylinder
        // specifying radius, color, and height
        Cylinder c4 = new Cylinder(3.0, "blue", 5.0);
        printCylinder("c4 (radius + color + height)", c4);

        // Test setter for color and height
        c4.setColor("green");
        c4.setHeight(7.5);
        printCylinder("c4 (after setColor & setHeight)", c4);
    }
}
