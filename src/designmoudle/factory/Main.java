package com.factory;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        Shape circle=ShapeFactory.create(Circle.class);
        circle.draw();

        Shape square=ShapeFactory.create(Square.class);
        square.draw();

        Shape bubble=ShapeFactory.create(Bubble.class);
        bubble.draw();

    }
}
