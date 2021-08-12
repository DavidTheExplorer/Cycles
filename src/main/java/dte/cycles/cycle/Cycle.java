package dte.cycles.cycle;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface Cycle<E> extends Iterable<E>
{
	E after(E element);

	Set<E> getElements();

	default Stream<Entry<E, E>> pairStream() 
	{
		return StreamSupport.stream(spliterator(), false).map(element -> new SimpleEntry<>(element, after(element)));
	}
	
	@Override
	default Iterator<E> iterator() 
	{
		return getElements().iterator();
	}
}