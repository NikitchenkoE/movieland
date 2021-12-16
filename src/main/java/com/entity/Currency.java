package com.entity;

import java.util.Arrays;

public enum Currency {
    USD("usd"),
    EUR("eur");
    private final String currencyName;

    Currency(String currencyName) {
        this.currencyName = currencyName;
    }

    public static Currency getCurrencyIgnoreCase(String currencyValue) {
        return Arrays.stream(Currency.values())
                .filter(currency -> currency.currencyName.equalsIgnoreCase(currencyValue))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unsupported currency " + currencyValue));
    }

    public String getCurrencyName() {
        return currencyName;
    }
}
