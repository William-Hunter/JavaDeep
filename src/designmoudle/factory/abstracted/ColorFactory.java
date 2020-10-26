package com.factory.abstracted;

import com.factory.Shape;

public class ColorFactory extends AbstractFactory {
    @Override
    <T extends Color> Color getColor(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    @Override
    <T extends Shape> Shape getShape(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return null;
    }
}
