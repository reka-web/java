package com.example.collections;

import java.util.*;

public class CollectionsExample 
{
  
	 enum Game { CRICKET, HOCKEY, TENNIS, FOOTBALL, RUGBI }
	 
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>();
		list.add("H.. ");
		list.add( "demo");
		list.add("list");
		list.add(1,"Hello..");
		List<String> list2 = new ArrayList(Arrays.asList("list","demo"));
		list2.add("test");
		list2.add("final");
		list.addAll(list2); Collections.sort(list);System.out.println(list); 
		
		//list.removeAll(list2); System.out.println(list);
		list.set(1, "dude"); //update index
		list.remove("test");
		ListIterator<String> itr = list.listIterator();
		while(itr.hasNext())
		{
			if(itr.next() == ("demo")) itr.remove();
		}
		 System.out.println(list);
		 		 
		 //remove odd numbers  - shows only even.
		 Set<Integer>  s = new HashSet<>();
		 s.add(2);	 s.add(1);
		 s.add(3);	 s.add(4);
		 s.add(2);	 s.add(5);
		 s.add(3);	 s.add(7);
		 s.add(9); System.out.println(s);
		 System.out.println(Collections.max(s));
		 System.out.println(Collections.min(s));
		 
		 Iterator<Integer> iter1 =  s.iterator();
		 while(iter1.hasNext())
		 {
			 if(iter1.next() % 2 != 0 )  iter1.remove();
		 }
		 System.out.println(s); 
				 
		EnumSet<Game> es = EnumSet.allOf(Game.class);	 System.out.println(es);
		
		Queue<String> pq = new PriorityQueue<>();
		pq.add("fifo");
		pq.add("first in ");
		pq.add("first out");
		System.out.println(pq);
		System.out.println(pq.peek());System.out.println(pq);
		System.out.println(pq.poll());System.out.println(pq);
		
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "ONE");map.put(2, "TWO");
		map.put(3, "THREE");System.out.println(map);
		map.remove(3);
		for(Map.Entry element : map.entrySet())
		{
			System.out.println(element.getKey() +" " + element.getValue());
		}
		
		String[] names = {"bala", "madhu", "reka", "amala" };
		for(String name : names) System.out.println(name.toString());
		
		Arrays.sort(names);
		for(String name : names) System.out.println(name.toString());
	
		
		
	}
}

		