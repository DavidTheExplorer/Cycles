package dte.cycles.factory;

import java.util.HashMap;
import java.util.LinkedHashMap;

import dte.cycles.cycle.Cycle;
import dte.cycles.cycle.MapCycle;

public class CycleFactory
{
	//Container of static factory methods
	private CycleFactory(){}
	
	/**
	 * Creates a cycle from the provided {@code elements} that doesn't have a guaranteed iteration order(which is more efficient).
	 * 
	 * @param <E> The type of the cycle's elements.
	 * @param elements The elements to add to the cycle; {@code elements[n]} will link to {@code elements[n+1]}.
	 * @return The created unordered cycle.
	 * @see #ordered(E[])
	 */
	@SafeVarargs
	public static <E> Cycle<E> unordered(E... elements)
	{
		return MapCycle.of(new HashMap<>(), elements);
	}
	
	/**
	 * Creates a cycle whose iteration order is guaranteed to be the order of the provided {@code elements}.
	 * 
	 * @param <E> The type of the cycle's elements.
	 * @param elements The elements to add to the cycle; {@code elements[n]} will link to {@code elements[n+1]}.
	 * @return The created ordered cycle.
	 * @see #unordered(E[])
	 */
	@SafeVarargs
	public static <E> Cycle<E> ordered(E... elements) 
	{
		return MapCycle.of(new LinkedHashMap<>(), elements);
	}
}
