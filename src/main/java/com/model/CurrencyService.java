package com.model;

import com.entity.Currency;

public interface CurrencyService {
    double convertFromUah(double price, Currency currency);
}
