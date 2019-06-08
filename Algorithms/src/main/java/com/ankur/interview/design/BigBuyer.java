package com.ankur.interview.design;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class BigBuyer implements Observer 
{      
private String symbol; 
private float close; 
private float high; 
private float low; 
private long volume; 
public BigBuyer(StockData stockData) 
{ 
	System.out.println("Attaching :  "+this.toString());

      stockData.attach(this);      
} 
public void update(String symbol,float close,float high,float low,long volume) 
{ 
      this.symbol      =      symbol;      
      this.close      =      close;      
      this.high      =      high;      
      this.low      =      low;      
      this.volume      =      volume;      
      display();      
} 
public void display() 
{ 
      DecimalFormatSymbols dfs = new DecimalFormatSymbols(); 
      DecimalFormat volumeFormat = new DecimalFormat("###,###,###,###",dfs); 
      DecimalFormat priceFormat = new DecimalFormat("###.00",dfs); 
      System.out.println("Big Buyer reports... "); 
      System.out.println("\tThe lastest stock quote for " + symbol + " is:"); 
      System.out.println("\t$" + priceFormat.format(close) + " per share (close)."); 
      System.out.println("\t$" + priceFormat.format(high) + " per share (high)."); 
      System.out.println("\t$" + priceFormat.format(low) + " per share (low)."); 
      System.out.println("\t" + volumeFormat.format(volume) + " shares traded."); 
      System.out.println();      
}
@Override
public String toString() {
	return "BigBuyer [symbol=" + symbol + ", close=" + close + ", high=" + high + ", low=" + low + ", volume=" + volume
			+ "]";
} 

}