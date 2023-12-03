package dte.cycles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class CycleTest 
{
	@Test
	public void testCyclicBehaviour() 
	{
		Cycle<Integer> cycle = Cycle.of(1, 2, 3);
		
		//removing Integer#intValue causes a compilation error
		assertEquals(2, cycle.after(1).intValue());
		assertEquals(3, cycle.after(2).intValue());
		assertEquals(1, cycle.after(3).intValue());
	}
	
	@Test
	public void testMissingElement() 
	{
		Cycle<Integer> cycle = Cycle.of(1, 2, 3);
		
		assertThrows(IllegalArgumentException.class, () -> cycle.after(4));
	}
}
