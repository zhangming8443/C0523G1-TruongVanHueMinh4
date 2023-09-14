package com.example.currency_conversion.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    public double currencyConversion(double rate, double usd) {
        return rate * usd;
    }
}
