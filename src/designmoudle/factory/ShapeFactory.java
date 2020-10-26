package com.factory;

public class ShapeFactory {


    static <T extends Shape> Shape create(Class<T> clazss) throws IllegalAccessException, InstantiationException {
        return clazss.newInstance();
    }

}
