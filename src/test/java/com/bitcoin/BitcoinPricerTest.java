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
import org.mockito.MockitoAnnotations;

import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(JUnitParamsRunner.class)
public class BitcoinPricerTest {
	

	@Test
	public void testMock1 (){
        //Arrange
        double price = 6000.00;
        BitCoinValueService bsp = Mockito.mock(BitCoinValueService.class);
        Mockito.when(bsp.findPrice()).thenReturn(price);
        BitCoinPricer bp = new BitCoinPricer(bsp);            
        double expected = price * 1.227481;

        //Act
        double actual = bp.convertEuro();

        //Assert
        assertEquals(expected, actual, 1.0);
        Mockito.verify(bsp).findPrice();
    }
	
	@Test
	public void testMock2 (){
        //Arrange
        double price = 5000.00;
        BitCoinValueService bsp = Mockito.mock(BitCoinValueService.class);
        Mockito.when(bsp.findPrice()).thenReturn(price);
        BitCoinPricer bp = new BitCoinPricer(bsp);            
        
        // bad logic 
        double expected = price * 1.227481;

        //Act
        double actual = bp.convertEuro();

        //Assert
        assertEquals(expected, actual, 1.0);
        Mockito.verify(bsp).findPrice();
    }
	@Test(expected=NullPointerException.class)
	public void testMock3 (){
        //Arrange
        double price = (Double) null;
        BitCoinValueService bsp = Mockito.mock(BitCoinValueService.class);
        Mockito.when(bsp.findPrice()).thenReturn(price);
     
        //Assert
        assertNull(bsp.findPrice());
        Mockito.verify(bsp).findPrice();
    }
	@Test
	public void testMock4 (){
        //Arrange
        double price = 0.00;
        BitCoinValueService bsp = Mockito.mock(BitCoinValueService.class);
        Mockito.when(bsp.findPrice()).thenReturn(price);
        BitCoinPricer bp = new BitCoinPricer(bsp);            
        double expected = price * 1.227481;

        //Act
        double actual = bp.convertEuro();

        //Assert
        assertEquals(expected, actual, 1.0);
        Mockito.verify(bsp).findPrice();
    }
	
	@Test
	public void testMock5 (){
        //Arrange
        double price = -1000.00;
        BitCoinValueService bsp = Mockito.mock(BitCoinValueService.class);
        Mockito.when(bsp.findPrice()).thenReturn(price);
        BitCoinPricer bp = new BitCoinPricer(bsp);   
        
        //fail this test on purpose 
        double expected = 5000.00 * 1.227481;

        //Act
        double actual = bp.convertEuro();

        //Assert
        assertEquals(expected, actual, 1.0);
        Mockito.verify(bsp).findPrice();
    }
	@Test
	public void testAssertEqualsSameObjects() {
		BitCoinValueService bsp = Mockito.mock(BitCoinValueService.class);
		BitCoinPricer bp = new BitCoinPricer(bsp);
		bp.convertEuro();
		assertEquals("These are two different object", bsp.findPrice(),bp.convertEuro(), 5.00);
	}

	// integration testing
	@Test
	public void testIntegration_TDD() {
		
		double price = 9000.00;
        BitCoinValueService bsp = Mockito.mock(BitCoinValueService.class);
        Mockito.when(bsp.findPrice()).thenReturn(price);
        BitCoinPricer bp = new BitCoinPricer(bsp);  
        
 
 
        assertEquals(11047.32,bp.convertEuro_TDD(bsp.findPrice()),1.00);
        Mockito.verify(bsp, times(2)).findPrice();
		
	}
@Test
public void testIntegration() {
		
		double price = 9000.00;
        BitCoinValueService bsp = Mockito.mock(BitCoinValueService.class);
        Mockito.when(bsp.findPrice()).thenReturn(price);
        BitCoinPricer bp = new BitCoinPricer(bsp);  
        
 
 
        assertEquals(11047.32,bp.convertEuro(),1.00);
        Mockito.verify(bsp, times(1)).findPrice();
		
	}

}


