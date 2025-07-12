package dte.cycles;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A connected list of objects where the last element is linked to the first - forming an infinite cycle.
 *
 * @param <E> The type of this cycle's elements.
 */
public interface Cycle<E> extends Iterable<E>
{
	/**
	 * Returns the next element after the provided {@code element}.
	 * 
	 * @param element Any element in this cycle.
	 * @return The next element.
	 */
	E after(E element);

	/**
	 * Returns the distinct elements that compose this cycle.
	 * 
	 * @return This cycle's elements.
	 */
	Set<E> getElements();
	
	/**
	 * Converts this cycle into a {@code Map} representation - where each entry points to the one afterwards.
	 * 
	 * @return This cycle as a {@link java.util.Map Map}.
	 */
	default Map<E, E> toMap()
	{
		return getElements().stream().collect(Collectors.toMap(Function.identity(), this::after));
	}
	
	@Override
	default Iterator<E> iterator() 
	{
		return getElements().iterator();
	}
	
	
	
	/**
	 * Creates a cycle from the provided {@code elements} that doesn't have a guaranteed iteration order(more efficient).
	 * 
	 * @param <E> The type of the cycle's elements.
	 * @param elements The elements to add to the cycle; {@code elements[n]} will be linked to {@code elements[n+1]}.
	 * @return The created unordered cycle.
	 * @see #ordered(E[])
	 */
	@SafeVarargs
	static <E> Cycle<E> of(E... elements)
	{
		return MapCycle.of(new HashMap<>(), elements);
	}
	
	/**
	 * Creates a cycle whose iteration order is guaranteed to be the order of the provided {@code elements}.
	 * 
	 * @param <E> The type of the cycle's elements.
	 * @param elements The elements to add to the cycle; {@code elements[n]} will be linked to {@code elements[n+1]}.
	 * @return The created ordered cycle.
	 */
	@SafeVarargs
	static <E> Cycle<E> ordered(E... elements)
	{
		return MapCycle.of(new LinkedHashMap<>(), elements);
	}
}