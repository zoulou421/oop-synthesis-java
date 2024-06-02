package com.formationkilo.business;

@FunctionalInterface
public interface Condition <T>{
    boolean test(T o);
}
