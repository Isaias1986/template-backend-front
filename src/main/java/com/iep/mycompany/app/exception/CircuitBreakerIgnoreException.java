package com.iep.mycompany.app.exception;

import com.iep.commons.exception.BaseCustomException;

import java.util.function.Predicate;

public class CircuitBreakerIgnoreException implements Predicate<Throwable> {
    @Override
    public boolean test(Throwable throwable) {
        if(throwable instanceof BaseCustomException){
            return true;
        }
        return false;
    }
}
