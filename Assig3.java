import java.util.Scanner;

public interface CalculateArea {
    double calculateArea();
    double pi = 3.1416;
}

public interface CalculatePerimeter {
    double calculatePerimeter();
}

public interface Displayable {
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

public class Assig3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\nENTER 1 TO CALCULATE AREA AND PERIMETER FOR SQUARE");
            System.out.println("ENTER 2 TO CALCULATE AREA AND PERIMETER FOR RECTANGLE");
            System.out.println("ENTER 3 TO CALCULATE AREA AND CIRCUMFERENCE FOR CIRCLE");
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

                    case 0:
                        System.out.println("EXITING...");
                        break;

                    default:
                        System.out.println("INVALID INPUT! PLEASE TRY AGAIN.");
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
                
            }

        } while (ch != 0);

   
    }
}
