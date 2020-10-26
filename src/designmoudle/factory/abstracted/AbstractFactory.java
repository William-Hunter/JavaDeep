package com.factory.abstracted;

import com.factory.Shape;

public abstract class AbstractFactory {

    abstract  <T extends Color> Color getColor(Class<T> clazz) throws IllegalAccessException, InstantiationException;

    abstract <T extends Shape> Shape getShape(Class<T> clazz) throws IllegalAccessException, InstantiationException;
}
