package com.bitcoin;

public class BitCoinPricer {
	
	static BitCoinValueService b = new BitCoinValueService();

	
	public BitCoinPricer(BitCoinValueService b){
		this.b = b; 
	}
	
public static  double convertEuro (double result){
		
		double euroVal = 1.227481; 
		
		result = b.findPrice() * euroVal;
		
		return result;
		
	}
	
}
