package com.lozanov;

import java.util.List;
import java.util.stream.Collectors;

public class Container <T extends Shape> {
    private List<T> shapes;

    public List<T> getShapes() {
        return shapes;
    }

    public Container(List<T> shapes) {
        this.shapes = shapes;
    }

    public void add(T item) {
        shapes.add(item);
    }

    public T get(int index) {
        return shapes.get(index);
    }

    public List<T> getAllByArea(double area) {
        return shapes.stream().filter((shape) -> shape.calculateArea() == area).collect(Collectors.toList());
    }

    public double getTotalArea(double area) {
        return shapes.stream().mapToDouble(Shape::calculateArea).sum();
    }

    public List<T> getAllContaining(Point p) {
        return shapes.stream().filter((shape) -> shape.contains(p)).collect(Collectors.toList());
    }

    public T getBiggest() {
        T biggestFigure = null;

        for(T shape : shapes) {
            if(biggestFigure == null) {
                biggestFigure = shape;
            } else {
                if(biggestFigure.calculateArea() < shape.calculateArea()) {
                    biggestFigure = shape;
                }
            }
        }
        return biggestFigure;
    }

    public T getSmallest() {
        T smallestFigure = null;

        for(T shape : shapes) {
            if(smallestFigure == null) {
                smallestFigure = shape;
            } else {
                if(smallestFigure.calculateArea() > shape.calculateArea()) {
                    smallestFigure = shape;
                }
            }
        }
        return smallestFigure;
    }

    public void orderDescending() {
        shapes.sort((shape1, shape2) -> shape1.calculateArea() < shape2.calculateArea() ? 1 : -1);
    }
}
