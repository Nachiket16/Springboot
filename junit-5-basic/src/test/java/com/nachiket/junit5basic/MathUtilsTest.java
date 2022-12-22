package com.nachiket.junit5basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void test(){
        MathUtils mathUtils = new MathUtils();
        int exp = 2;
        int act = mathUtils.add(5,1);
        assertEquals(exp, act);
    }

}