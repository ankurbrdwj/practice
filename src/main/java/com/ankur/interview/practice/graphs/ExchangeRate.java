package com.ankur.interview.practice.graphs;

// POJO representing a directed exchange between two currencies.
// rate = how many units of `to` you receive for 1 unit of `from`.
// e.g. USD → EUR at rate 0.90 means $1 buys €0.90.
public class ExchangeRate {

    private final Currency from;
    private final Currency to;
    private final double   rate; // must be > 0

    public ExchangeRate(Currency from, Currency to, double rate) {
        this.from = from;
        this.to   = to;
        this.rate = rate;
    }

    public Currency getFrom() { return from; }
    public Currency getTo()   { return to; }
    public double   getRate() { return rate; }

    @Override
    public String toString() {
        return from.getCode() + " → " + to.getCode() + " @ " + rate;
    }
}