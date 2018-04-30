package com.bitcoin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class BitCoinValueService {

	public  double findPrice() {
		
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






/*

package com.bitcoin;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import org.testng.annotations.DataProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junitparams.JUnitParamsRunner;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.mockito.Mockito;


import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(JUnitParamsRunner.class)
public class BitcoinPricerTest {
	
	private BitCoinPricer bcp; 
	
	@Mock
	private BitCoinValueService mockService; 
	
	@Before
	public void beforeMethod() {
		mockService = mock(BitCoinValueService.class);
	}
	
	@After
	public void afterMethod() {
		mockService = null; 
	}
	

	@DataProvider
	public List<Object[]> dp(){
		final List<Object[]> result = new ArrayList<>();
	    result.add( new Object[] {6000.00} );
	    return result; 
	}
	
	@Test 
	@UseDataProvider("dp")
	public void testMock (double expectedVal) throws Exception{
	
		when(mockService.findPrice()).thenReturn(expectedVal);
		
		// Instantiate the object
		bcp = new BitCoinPricer (mockService);
		
		
		//Test begins 
		bcp.convertEuro(0);
		
		//checking condition
		assertEquals(bcp.convertEuro(expectedVal), 6000.00,0.1);
		
		verify(mockService, times(1)).findPrice();
	}
	

	
	//at the time of testing the euro to dollar conversion rate was 1.227481 and 
	//Bitcoin price in euros was 7,257.08.
	
	/*
	@Test
	public void AssertEquals_Expected_Output() {
		assertEquals(8955.56, BitCoinPricer.convertEuro(service.findPrice()), 0.10);
	}

	@Test
	public void AssertNull_BitCoinPricer_Output() {
		assertNull(null, BitCoinPricer.convertEuro(service.findPrice()));
	}
	
	@Test(expected=NullPointerException.class)
	public void AssertEquals_Null_Ex() {
		assertEquals(8955.56, BitCoinPricer.convertEuro((Double) null), 0.10);
	}

	// integration testing
	@Test
	public void testAssertEqualsSameObjects() {
		bitCoinPricer.convertEuro(bitCoinValueService.findPrice());
		assertEquals("The same object", bitCoinValueService.findPrice(),this.bitCoinValueService.findPrice(), 5.00);
	}
	
	@Test
	public void testAssertEqualsFalseDiffObject() {
		BitCoinValueService s = new BitCoinValueService();
		BitCoinPricer b = new BitCoinPricer(bitCoinValueService);
		s.findPrice();
		b.convertEuro(s.findPrice());
		assertEquals("The object is not the same",s.findPrice(),b.convertEuro(s.findPrice()),5.00);
	}
	*/
