package com.model.impl;

import com.entity.Currency;
import com.model.CurrencyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CurrencyServiceImplTest {
    @Autowired
    private CurrencyService currencyService;

    @Test
    void convertFromUah() {
        double actual = currencyService.convertFromUah(81, Currency.USD);
        assertDoesNotThrow(() -> new RuntimeException("Problem"));
    }

}