package gangoffour.classic.behavioral.observer;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class TradingFool implements Observer 
{      
private String symbol; 
private float close; 
public TradingFool(StockData stockData) 
{ 
	System.out.println("Attaching :  "+this.toString());
          stockData.attach(this);      
} 
    public void update(String symbol,float close,float high,float low,long volume) 
{ 
          this.symbol      =      symbol;      
          this.close      =      close;      
          display();      
} 
    public void display() 
{ 
          DecimalFormatSymbols dfs = new DecimalFormatSymbols(); 
          DecimalFormat priceFormat = new DecimalFormat("###.00",dfs); 
          System.out.println("Trading Fool says... "); 
          System.out.println("\t" + symbol + " is currently trading at $" + 
                priceFormat.format(close) + " per share."); 
          System.out.println();      
}
	@Override
	public String toString() {
		return "TradingFool [symbol=" + symbol + ", close=" + close + "]";
	} 
    
    }      