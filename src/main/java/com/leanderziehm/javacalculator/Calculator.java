// this code was written mostly by chatgpt I just setup the structure with GetMapping, RequestParam, RestController and added the space to + line and public record CalculateResponse(double result, String status) {}
package com.leanderziehm.javacalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class Calculator {

    @GetMapping(path = "/calculate")
    public CalculateResponse calculate(@RequestParam String formula) {
        formula = formula.replace(" ", "+"); // convert spaces back to plus because of url encoding.
        try {
            double result = evaluate(formula);
            return new CalculateResponse(result, "success");
        } catch (Exception e) {
            return new CalculateResponse(0, "error: " + e.getMessage());
        }
    }

    public record CalculateResponse(double result, String status) {}

    // --- Method to evaluate arithmetic expressions using regex ---
    private double evaluate(String expr) {
        expr = expr.replaceAll("\\s+", ""); // Remove whitespace

        // Pattern for multiplication/division first
        Pattern mdPattern = Pattern.compile("(-?\\d+(?:\\.\\d+)?)([*/])(-?\\d+(?:\\.\\d+)?)");

        // Process all * and / first
        Matcher matcher;
        while ((matcher = mdPattern.matcher(expr)).find()) {
            double left = Double.parseDouble(matcher.group(1));
            double right = Double.parseDouble(matcher.group(3));
            String op = matcher.group(2);
            double tempResult = op.equals("*") ? left * right : left / right;
            expr = matcher.replaceFirst(String.valueOf(tempResult));
        }

        // Pattern for addition/subtraction
        Pattern asPattern = Pattern.compile("(-?\\d+(?:\\.\\d+)?)([+-])(-?\\d+(?:\\.\\d+)?)");

        // Process all + and -
        while ((matcher = asPattern.matcher(expr)).find()) {
            double left = Double.parseDouble(matcher.group(1));
            double right = Double.parseDouble(matcher.group(3));
            String op = matcher.group(2);
            double tempResult = op.equals("+") ? left + right : left - right;
            expr = matcher.replaceFirst(String.valueOf(tempResult));
        }

        return Double.parseDouble(expr);
    }
}
