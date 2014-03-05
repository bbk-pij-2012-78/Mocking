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
}
