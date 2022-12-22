package com.nachiket.junit5basic;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)  //If this is used then no need to make static before all method . Else you have to make BeforeAll as a static
class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeAll
    static void beforeAll(){
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init(){
        mathUtils = new MathUtils();
    }

    @Nested
    class AddTest{
        @Test
        @DisplayName("Testing add for Positive No")
        void testAddPositive(){
            assertEquals(2, mathUtils.add(1,1), "The add method should add two numbers");
        }
        @Test
        @DisplayName("Testing add for Negative No")
        void testAddNegative(){
            assertEquals(-2, mathUtils.add(-1,-1), "The add method should add two numbers");
        }
    }


    @AfterEach
    void cleanup(){
        System.out.println("Cleaning up... ");
    }

    @Test
    @DisplayName("Testing add method")
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
        boolean isServerUp = false;
        assumeTrue(isServerUp);    //This is for the external factor eg-> if server is down then test will fail. It will assume the server is running if not then will skip the test.
        assertThrows(ArithmeticException.class, ()-> mathUtils.divide(5,0), "Divide by zero");
    }

    @Test
    @DisplayName("Multiply method test")
    void testMultiply(){
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2,2)),
                () -> assertEquals(0, mathUtils.multiply(0, 123)),
                () -> assertEquals(-1, mathUtils.multiply(-1, 1))
        );
    }

}