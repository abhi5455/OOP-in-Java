abstract class Shape {
    abstract int numberOfSides();
}

class Rectangle extends Shape {
    int numberOfSides() {
        return 4;
    }
}

class Triangle extends Shape {
    int numberOfSides() {
        return 3;
    }
}

class Hexagon extends Shape {
    int numberOfSides() {
        return 6;
    }
}

public class Pgm2B {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        Triangle tri = new Triangle();
        Hexagon hex = new Hexagon();

        System.out.println("Number of sides of:\n- Rectangle: " + rect.numberOfSides() + "\n- Triangle: " + tri.numberOfSides() + "\n- Hexagon: " + hex.numberOfSides());
    }
}
