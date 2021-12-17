package com.model.impl;

import com.entity.Currency;
import com.entity.Money;
import com.model.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final static String URL_TEMPLATE = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    private final RestTemplate restTemplate;
    private final Map<Currency, Double> currencyRates = new ConcurrentHashMap<>();

    @PostConstruct
    public void initCurrencyRates() {
        updateRates();
    }

    @Override
    public double convertFromUah(double price, Currency currency) {
        if (!currencyRates.containsKey(currency)) {
            throw new RuntimeException("Currency do not support");
        }
        return price / currencyRates.get(currency);
    }


    @Scheduled(cron = " 0 10 16 ? * * *")
    public void updateRates() {
        var response = restTemplate.exchange(URL_TEMPLATE,
                HttpMethod.GET, null, Money[].class);

        for (Currency currency : Currency.values()) {
            if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
                throw new RuntimeException("Can't get rates");
            }
            var moneyArray = response.getBody();
            var currentMoney = Arrays.stream(moneyArray)
                    .filter(money -> money.getCc().equalsIgnoreCase(currency.getCurrencyName()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Not supported currency " + currency.getCurrencyName()));
            currencyRates.put(Currency.getCurrencyIgnoreCase(currentMoney.getCc()), currentMoney.getRate());

        }
    }
}