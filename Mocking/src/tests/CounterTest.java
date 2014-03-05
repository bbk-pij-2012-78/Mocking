package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import code.Counter;
import static org.mockito.Mockito.*;

public class CounterTest {
	
	@Test
	public void test() {
		
		Integer first;
		Integer expectedFirst = 1;
		
		Counter count = new Counter();
		
		first = count.getValue();
		
		assertEquals("Wrong Answer!", expectedFirst, first);
	}	
}
