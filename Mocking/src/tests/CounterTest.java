package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import code.Counter;
import static org.mockito.Mockito.*;

public class CounterTest {
	
	@Test
	public void test() {
		
		Integer first,mockedFirst;
		
		Counter count = new Counter();
		
		Counter mockedCounter = mock(Counter.class);
		when(mockedCounter.getValue()).thenReturn(1);
		
		first = count.getValue();
		mockedFirst = mockedCounter.getValue();
		
		assertEquals("Wrong Answer!", first, mockedFirst);
	}	

	@Test
	public void test2() {
		
		Integer first,mockedFirst;
		Integer expectedFirst = 1;
		
		Counter count = new Counter();
		
		Counter mockedCounter = mock(Counter.class);
		when(mockedCounter.getValue()).thenReturn(2);
		
		first = count.getValue();
		mockedFirst = mockedCounter.getValue();
		
		assertEquals("Wrong Answer!", first, expectedFirst);
		
		first = count.getValue();mockedFirst = mockedCounter.getValue();
		
		assertEquals("Wrong Answer!", first, mockedFirst);
	}
	
	@Test
	public void test3() {
		
		Integer first,mockedFirst;
		
		Counter count = new Counter();
		
		Counter mockedCounter = mock(Counter.class);
		when(mockedCounter.getValue()).thenReturn(1).thenReturn(2).thenReturn(3);
		
		first = count.getValue();
		mockedFirst = mockedCounter.getValue();
		assertEquals("Wrong Answer!", first, mockedFirst);
		
		first = count.getValue();
		mockedFirst = mockedCounter.getValue();
		assertEquals("Wrong Answer!", first, mockedFirst);
		
		first = count.getValue();
		mockedFirst = mockedCounter.getValue();		
		
		verify(mockedCounter,atLeast(3)).getValue();
		assertEquals("Wrong Answer!", first, mockedFirst);
		
		mockedFirst = mockedCounter.getValue();	
		verify(mockedCounter,atLeast(3)).getValue();
	}
	
	@Test
	public void atMostTest() {
		
		Integer mockedFirst;

		Counter mockedCounter = mock(Counter.class);
		when(mockedCounter.getValue()).thenReturn(1).thenReturn(2).thenReturn(3);
		
		mockedFirst = mockedCounter.getValue();
		mockedFirst = mockedCounter.getValue();
		mockedFirst = mockedCounter.getValue();
		
		verify(mockedCounter,atMost(3)).getValue();
				
		mockedFirst = mockedCounter.getValue();
		//verify(mockedCounter,atMost(3)).getValue();
	}
	
	@Test
	public void atLeastOnceTest() {
		
		Integer mockedFirst = 0;

		Counter mockedCounter = mock(Counter.class);
		when(mockedCounter.getValue()).thenReturn(1).thenReturn(2).thenReturn(3);
		
		//verify(mockedCounter,atLeastOnce()).getValue();
		
		mockedFirst = mockedCounter.getValue();

		verify(mockedCounter,atLeastOnce()).getValue();	
		
	}	
	
	@Test
	public void neverTest() {
		
		Integer mockedFirst = 0;

		Counter mockedCounter = mock(Counter.class);
		when(mockedCounter.getValue()).thenReturn(1).thenReturn(2).thenReturn(3);
		
		verify(mockedCounter,never()).getValue();
		
		mockedFirst = mockedCounter.getValue();

		verify(mockedCounter,never()).getValue();	
		
	}		
	
}
