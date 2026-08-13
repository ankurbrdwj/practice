package com.ankur.interview.practice.graphs;

import java.util.ArrayList;
import java.util.List;

// Models a set of currencies and their bilateral exchange rates as a directed
// weighted graph, then delegates arbitrage detection to BellmanFord.
//
// Usage:
//   Currency usd = new Currency(0, "USD");
//   Currency eur = new Currency(1, "EUR");
//   Currency gbp = new Currency(2, "GBP");
//
//   CurrencyMarket market = new CurrencyMarket(3);
//   market.addRate(new ExchangeRate(usd, eur, 0.90));
//   market.addRate(new ExchangeRate(eur, gbp, 0.85));
//   market.addRate(new ExchangeRate(gbp, usd, 1.35));  // 0.90×0.85×1.35=1.03 → profit!
//
//   market.hasArbitrage(); // → true
public class CurrencyMarket {

    private final int                numCurrencies;
    private final List<ExchangeRate> rates;

    public CurrencyMarket(int numCurrencies) {
        this.numCurrencies = numCurrencies;
        this.rates         = new ArrayList<>();
    }

    public void addRate(ExchangeRate rate) {
        rates.add(rate);
    }

    // Builds the n×n adjacency matrix from the registered ExchangeRate objects,
    // then calls BellmanFord.detectArbitrage() which applies the -log(rate)
    // transformation and looks for a negative-weight cycle.
    public boolean hasArbitrage() {
        double[][] matrix = buildMatrix();
        return BellmanFord.detectArbitrage(matrix);
    }

    // Returns the exchange rates as a human-readable list (useful for debugging).
    public List<ExchangeRate> getRates() {
        return rates;
    }

    // Converts the list of ExchangeRate POJOs into the double[][] adjacency
    // matrix expected by BellmanFord.detectArbitrage().
    // matrix[i][j] = rate from currency-i to currency-j; 0 = no direct path.
    private double[][] buildMatrix() {
        double[][] matrix = new double[numCurrencies][numCurrencies];
        for (ExchangeRate er : rates) {
            matrix[er.getFrom().getId()][er.getTo().getId()] = er.getRate();
        }
        return matrix;
    }
}