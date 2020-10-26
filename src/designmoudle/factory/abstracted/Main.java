package com.factory.abstracted;

import com.factory.Bubble;
import com.factory.Circle;
import com.factory.Shape;
import com.factory.Square;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        AbstractFactory colorfactory =FactoryProduce.produceFactory(ColorFactory.class);
        Color red=colorfactory.getColor(Red.class);
        red.draw();
        Color green=colorfactory.getColor(Green.class);
        green.draw();

        AbstractFactory shapeFactory =FactoryProduce.produceFactory(ShapeFactory.class);
        Shape           circle       =shapeFactory.getShape(Circle.class);
        circle.draw();
        Shape squre=shapeFactory.getShape(Square.class);
        squre.draw();
    }
}
