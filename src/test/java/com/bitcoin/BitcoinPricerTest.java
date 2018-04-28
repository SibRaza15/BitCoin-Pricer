package com.bitcoin;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;


import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BitcoinPricerTest {
	
	
	BitCoinPricer b = null; 
	BitCoinValueService service = Mockito.mock(BitCoinValueService.class);
	
	private BitCoinValueService bitCoinValueService;
	private BitCoinPricer bitCoinPricer;
	
	
	@Before
	public void setData(){
		bitCoinValueService = new BitCoinValueService();
		bitCoinPricer = new BitCoinPricer(bitCoinValueService);
		
	}
	
	@Before
	public void setUp(){
		b = new BitCoinPricer(service);
	}
	
	//at the time of testing the euro to dollar conversion rate was 1.227481 and 
	//Bitcoin price in euros was 7,257.08.
	
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

}

