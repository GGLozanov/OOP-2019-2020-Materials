package main.java;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Double> arguments = new ArrayList<>(args.length*2); // dynamic handling
        for(int i = 0; i < args.length; i++) {
            String[] innerArgs = args[i].split(",", 2);
            for(int j = 0; j < innerArgs.length; j++) {
                arguments.add(Double.parseDouble(innerArgs[j]));
            }
        }

        arguments.trimToSize();

        switch(arguments.size()) {
            case 3:
                Circle circle = new Circle(new Point[]{new Point(arguments.get(0), arguments.get(1)),
                        new Point(arguments.get(2), 0)}); // second point is radius

                System.out.println("---------------");
                System.out.println("Circle");
                System.out.println("---------------");
                System.out.println(circle.getArea());
                System.out.println(circle.getPerimeter());
                break;
            case 4:
                Rectangle rectangle = new Rectangle(new Point[]{new Point(arguments.get(0), arguments.get(1)),
                        new Point(arguments.get(2), arguments.get(3))});

                System.out.println("---------------");
                System.out.println("Rectangle");
                System.out.println("---------------");
                System.out.println(rectangle.getArea());
                System.out.println(rectangle.getPerimeter());
                break;
            case 6:
                Triangle triangle = new Triangle(new Point[]{new Point(arguments.get(0), arguments.get(1))},
                        new Point(arguments.get(2), arguments.get(3)), new Point(arguments.get(4), arguments.get(5)));

                System.out.println("---------------");
                System.out.println("Triangle");
                System.out.println("---------------");
                System.out.println(triangle.getArea());
                System.out.println(triangle.getPerimeter());
                break;
            default:
                break;
        }
	// write your code here
    }
}
