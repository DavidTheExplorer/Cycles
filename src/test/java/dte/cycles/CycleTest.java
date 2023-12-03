package dte.cycles;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CycleTest 
{
	@Test
	public void testOrderedCycle() 
	{
		Cycle<Integer> cycle = Cycle.ordered(1, 2, 3, 4);
		
		Integer[] elements = cycle.getElements().toArray(new Integer[0]);
		
		assertArrayEquals(elements, new Integer[] {1, 2, 3, 4});
	}
}
