package com.bitcoin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class BitCoinValueService {

	public static double findPrice() {
		
		double result = 0; 
		try{
		//final String SYM = "BTC";
		
		URL url = new URL("http://markets.businessinsider.com/currencies/btc-eur");
			
		
		URLConnection urlConn = url.openConnection();
		InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
		BufferedReader buff = new BufferedReader(inStream);
		String price = "not found";
		String line = buff.readLine();
		while(line != null){
			if(line.contains("data-field=\"Mid\"")){
				
				int target = line.indexOf("data-field=\"Mid\"");
				int deci = line.indexOf(",", target);
				
				int start = deci;
				while(line.charAt(start) != '\"'){
					start--;
				}
				price = line.substring(start+2, deci+7);
				
				
			}
			line = buff.readLine();
		
			
		}
		
		 result= Double.parseDouble(price.replace(",",""));
		
		
		
		}catch (IOException e){
			e.printStackTrace();
			
		}
		return result; 
	}
		
	}
