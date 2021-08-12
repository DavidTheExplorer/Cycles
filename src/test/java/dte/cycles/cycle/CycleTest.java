package dte.cycles.cycle;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import dte.cycles.factory.CycleFactory;

public class CycleTest 
{
	@Test
	public void testOrderedCycle() 
	{
		Cycle<Integer> cycle = CycleFactory.ordered(1, 2, 3, 4);
		
		Integer[] elements = cycle.getElements().toArray(new Integer[0]);
		
		assertArrayEquals(elements, new Integer[] {1, 2, 3, 4});
	}
}