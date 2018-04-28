package com.bitcoin;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
	
		BitCoinValueService t = new BitCoinValueService();
		BitCoinPricer b = new BitCoinPricer(t);
		
		double  result = b.convertEuro(t.findPrice());
		
		System.out.println("The value of bitcoin in dolllars is "+ "$"+ result);

	}

}
