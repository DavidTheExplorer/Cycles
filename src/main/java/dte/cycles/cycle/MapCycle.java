package dte.cycles.cycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapCycle<E> implements Cycle<E>
{
	private final Map<E, E> links;

	private MapCycle(Map<E, E> links) 
	{
		this.links = links;
	}

	@SafeVarargs
	public static <E> MapCycle<E> of(Map<E, E> emptyBase, E... elements)
	{
		if(elements == null || elements.length == 0) 
			throw new IllegalArgumentException("Can't create an empty cycle!");
		
		linkArrayElements(emptyBase, elements);
		
		return new MapCycle<>(emptyBase);
	}

	@Override
	public E after(E element)
	{
		return this.links.get(element);
	}

	@Override
	public Set<E> getElements() 
	{
		return new HashSet<>(this.links.keySet());
	}
	
	@Override
	public Map<E, E> toMap() 
	{
		return new HashMap<>(this.links);
	}

	@Override
	public Iterator<E> iterator() 
	{
		return this.links.keySet().iterator();
	}
	
	private static <E> void linkArrayElements(Map<E, E> base, E[] elements)
	{
		for(int i = 0, untilLast = (elements.length-2); i <= untilLast; i++)
			link(base, elements, i, i+1);

		//map the last to the first element
		link(base, elements, elements.length-1, 0);
	}

	private static <E> void link(Map<E, E> links, E[] elements, int sourceIndex, int targetIndex)
	{
		links.put(elements[sourceIndex], elements[targetIndex]);
	}
}