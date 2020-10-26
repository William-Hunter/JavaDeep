package com.factory.abstracted;

import com.factory.Shape;

public class ShapeFactory extends AbstractFactory{

    @Override
    <T extends Color> Color getColor(Class<T> clazz) {
        return null;
    }

    @Override
    <T extends Shape> Shape getShape(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
}
