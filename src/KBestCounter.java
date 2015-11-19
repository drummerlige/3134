import java.util.PriorityQueue;
import java.util.List;
import java.util.LinkedList;

public class KBestCounter<T extends Comparable<T>> 
{

	private PriorityQueue<T> heap;
	private int k;
	private int counter;

	public KBestCounter(int k) 
	{
		heap = new PriorityQueue<T>();
		this.k = k;
		counter = k;
	}

	public void count(T x) 
	{
		if(counter != 0) 
		{
			heap.add(x);
			counter--;
		}
		if (x.compareTo(heap.peek()) < 0) 
		{
			heap.add(x);
			heap.poll();
		}

	}

	public List<T> kbest() 
	{
		List<T> list = new LinkedList<T>();
		
		for(int i = 0; i < k; i++) 
		{
			list.add(heap.poll());
		}
		
		for (int i = 0; i < k; i++) 
		{
			heap.add(list.get(i));
		}
		return list;
	}
	
} 


