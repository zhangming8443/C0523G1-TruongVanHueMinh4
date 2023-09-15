package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculate(String calculate, double number1, double number2) {
        double result = 0;

        switch (calculate) {
            case "addition":
                result = number1 + number2;
                return "Result: " + result;
            case "subtraction":
                result = number1 - number2;
                return "Result: " + result;
            case "multiplication":
                result = number1 * number2;
                return "Result: " + result;
            case "division":
                if (number2 != 0) {
                    result = number1 / number2;
                    return "Result: " + result;
                } else {
                    return "Number 2 is not valid";
                }
            default:
                return "Please enter the number !";
        }
    }
}
