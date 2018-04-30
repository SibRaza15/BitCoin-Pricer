package com.bitcoin;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
	
		BitCoinValueService t = new BitCoinValueService();
		BitCoinPricer b = new BitCoinPricer(t);
		
		// removed semi-colon - should cause program not to run. 
		double  result = b.convertEuro()
		
		System.out.println("The value of bitcoin in dolllars is "+ "$"+ result);

	}

}
