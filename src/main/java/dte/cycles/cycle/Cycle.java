package dte.cycles.cycle;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Cycle<E> extends Iterable<E>
{
	E after(E element);

	Set<E> getElements();
	
	default Map<E, E> toMap()
	{
		return getElements().stream().collect(Collectors.toMap(Function.identity(), this::after));
	}
	
	@Override
	default Iterator<E> iterator() 
	{
		return getElements().iterator();
	}
}