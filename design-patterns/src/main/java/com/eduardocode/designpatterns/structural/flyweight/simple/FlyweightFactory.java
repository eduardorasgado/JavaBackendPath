package com.eduardocode.designpatterns.structural.flyweight.simple;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<FlyWeightType, Flyweight> flyweightPool;

    public FlyweightFactory() {
        this.flyweightPool = new HashMap<>();
    }

    public Flyweight getFlyweight(FlyWeightType flyWeightType) {
        if(flyweightPool.containsKey(flyWeightType)) {
           return flyweightPool.get(flyWeightType);
        }

        Flyweight flyweight = new ConcreteFlyweight(flyWeightType);
        flyweightPool.put(flyWeightType, flyweight);

        return flyweight;
    }
}
