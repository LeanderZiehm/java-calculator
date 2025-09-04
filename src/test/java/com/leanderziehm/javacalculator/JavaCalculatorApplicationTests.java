package com.leanderziehm.javacalculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JavaCalculatorApplicationTests {

    private final Calculator calculator = new Calculator();

    @Test
    void testSimpleAddition() {
        Calculator.CalculateResponse response = calculator.calculate("2+2");
        assertEquals(4.0, response.result());
        assertEquals("success", response.status());
    }

    @Test
    void testComplexExpression() {
        Calculator.CalculateResponse response = calculator.calculate("3+5*2-4/2");
        assertEquals(9.0, response.result());
        assertEquals("success", response.status());
    }

    @Test
    void testDivisionByZero() {
        Calculator.CalculateResponse response = calculator.calculate("5/0");
        assertEquals("error: / by zero", response.status());
    }

    @Test
    void testInvalidExpression() {
        Calculator.CalculateResponse response = calculator.calculate("3++2");
        assertTrue(response.status().startsWith("error"));
    }


}
