package com.nachiket.junit5basic;

public class MathUtils {
    public int add(int a, int b){
        return a+b;
    }

    public double computeCircleArea(double radius){
        return Math.PI*Math.pow(radius,2);
    }

    public double divide(int a, int b){
        return a/b;
    }

    public int multiply(int a, int b){ return a * b; };
}
