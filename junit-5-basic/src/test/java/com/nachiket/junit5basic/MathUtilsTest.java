package com.nachiket.junit5basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    MathUtils mathUtils = new MathUtils();

    @Test
    void testAdd(){
//        MathUtils mathUtils = new MathUtils();
        int exp = 6;
        int act = mathUtils.add(5,1);
        assertEquals(exp, act, "The add method should add two numbers");
    }

    @Test
    void testCircleArea(){
//        MathUtils mathUtils = new MathUtils();
        double exp = 314.15926535897932384626433832795;
        double act = mathUtils.computeCircleArea(10);
        assertEquals(exp,act);
    }

    @Test
    void testDivide(){
//        MathUtils mathUtils = new MathUtils();
        assertThrows(ArithmeticException.class, ()-> mathUtils.divide(5,0), "Divide by zero");
    }

}