package com.factory.abstracted;

public class FactoryProduce {

    static <T extends AbstractFactory> AbstractFactory produceFactory(Class<T> factoryCalzz) throws IllegalAccessException, InstantiationException {
        return factoryCalzz.newInstance();
    }

}
