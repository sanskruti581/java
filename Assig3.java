import java.util.Scanner;

interface CalculateArea {
    double calculateArea();
    double pi = 3.1416;
}

interface CalculatePerimeter {
    double calculatePerimeter();
}

interface Displayable {
    void toDisplay();
}

class Square implements CalculateArea, CalculatePerimeter, Displayable {
    private int side;

    Square(int side) {
        this.side = side;
    }

    public double calculateArea() {
        return side * side;
    }

    public double calculatePerimeter() {
        return 4 * side;
    }

    public void toDisplay() {
        System.out.println("SHOWING CALCULATIONS:");
        System.out.println("PERIMETER IS: " + calculatePerimeter());
        System.out.println("AREA IS: " + calculateArea());
    }
}

class Rectangle implements CalculateArea, CalculatePerimeter, Displayable {
    private int length, width;

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    public void toDisplay() {
        System.out.println("SHOWING CALCULATIONS:");
        System.out.println("PERIMETER IS: " + calculatePerimeter());
        System.out.println("AREA IS: " + calculateArea());
    }
}

class Circle implements CalculateArea, CalculatePerimeter, Displayable {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return pi * radius * radius;
    }

    public double calculatePerimeter() {
        return new Circumference().calculate();
    }

    class Circumference {
        double calculate() {
            return 2 * pi * radius;
        }
    }

    public void toDisplay() {
        System.out.println("SHOWING CALCULATIONS:");
        System.out.println("CIRCUMFERENCE IS: " + calculatePerimeter());
        System.out.println("AREA IS: " + calculateArea());
    }
}

// New Parallelogram Class
class Parallelogram implements CalculateArea, CalculatePerimeter, Displayable {
    private int base, side, height;

    Parallelogram(int base, int side, int height) {
        this.base = base;
        this.side = side;
        this.height = height;
    }

    public double calculateArea() {
        return base * height;
    }

    public double calculatePerimeter() {
        return 2 * (base + side);
    }

    public void toDisplay() {
        System.out.println("SHOWING CALCULATIONS:");
        System.out.println("PERIMETER IS: " + calculatePerimeter());
        System.out.println("AREA IS: " + calculateArea());
    }
}

public class Assig3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int ch = -1; // Initialize ch to a non-zero value

        do {
            System.out.println("\nENTER 1 TO CALCULATE AREA AND PERIMETER FOR SQUARE");
            System.out.println("ENTER 2 TO CALCULATE AREA AND PERIMETER FOR RECTANGLE");
            System.out.println("ENTER 3 TO CALCULATE AREA AND CIRCUMFERENCE FOR CIRCLE");
            System.out.println("ENTER 4 TO CALCULATE AREA AND PERIMETER FOR PARALLELOGRAM");
            System.out.println("ENTER 0 TO EXIT");

            try {
                ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.println("Enter the length of the side of the square:");
                        int side = sc.nextInt();
                        if (side <= 0) throw new Exception("Side length must be positive.");
                        Square sqObj = new Square(side);
                        sqObj.toDisplay();
                        break;

                    case 2:
                        System.out.println("Enter the length and width of the rectangle:");
                        int length = sc.nextInt();
                        int width = sc.nextInt();
                        if (length <= 0 || width <= 0) throw new Exception("Length and width must be positive.");
                        Rectangle recObj = new Rectangle(length, width);
                        recObj.toDisplay();
                        break;

                    case 3:
                        System.out.println("Enter the radius of the circle:");
                        double radius = sc.nextDouble();
                        if (radius <= 0) throw new Exception("Radius must be positive.");
                        Circle cObj = new Circle(radius);
                        cObj.toDisplay();
                        break;

                    case 4:
                        System.out.println("Enter the base, side length, and height of the parallelogram:");
                        int base = sc.nextInt();
                        int sideLen = sc.nextInt();
                        int height = sc.nextInt();
                        if (base <= 0 || sideLen <= 0 || height <= 0) 
                            throw new Exception("Base, side length, and height must be positive.");
                        Parallelogram pObj = new Parallelogram(base, sideLen, height);
                        pObj.toDisplay();
                        break;

                    case 0:
                        System.out.println("EXITING...");
                        break;

                    default:
                        System.out.println("INVALID INPUT! PLEASE TRY AGAIN.");
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
                sc.nextLine(); // Clear buffer
            }

        } while (ch != 0);

        sc.close();
    }
}
