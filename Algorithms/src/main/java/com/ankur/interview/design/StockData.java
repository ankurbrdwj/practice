package com.ankur.interview.design;

import java.util.ArrayList;
import java.util.List;

public class StockData implements Subject {
	private String symbol;
	private float close;
	private float high;
	private float low;
	private long volume;
	private List<Observer> observers;

	public StockData() {
		observers = new ArrayList<Observer>();
	}

	public String getSymbol() {
		return symbol;
	}

	public float getClose() {
		return close;
	}

	public float getHigh() {
		return high;
	}

	public float getLow() {
		return low;
	}

	public long getVolume() {
		return volume;
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void detach(Observer observer) {
		int i = observers.indexOf(observer);
		if (i >= 0)
			observers.remove(i);
	}

	public void notifyObservers() {
		System.out.println("Inside Notify Observers");
		int n = observers.size();
		for (int i = 0; i < n; ++i) {
			Observer observer = (Observer) observers.get(i);
			observer.update(symbol, close, high, low, volume);
		}
	}

	public void sendStockData() {
		System.out.println("Inside Send Stock data");
		notifyObservers();
	}

	public void setStockData(String symbol, float close, float high, float low, long volume) {
		this.symbol = symbol;
		this.close = close;
		this.high = high;
		this.low = low;
		this.volume = volume;
		sendStockData();
	}
}