package com.amazon.adtech;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class WebAnalyzer {
		//Struct to maintain heap
		public class PageStruct{
			Integer count;
			String name;
			public PageStruct(String name, Integer count) {
				// TODO Auto-generated constructor stub
				this.name = name;
				this.count = count;
			}
		}
		
	// you may declare and use other variables or
	 // other helper methods you may need
	
	//We have a hashmap to store the list of pageurls.
	// We define a maxheap wherein the corresponding values are the integer 
	//vales of the hashmap and we retrieve as many maxheap as possible.
		
	// I wanted to dfine a maxheap with delete functionality but thought to use 
		//priority queue as library. Using comparator
	HashMap<String, Integer> pages = new HashMap<String, Integer>();
	PriorityQueue<PageStruct> queue = new PriorityQueue<>(1000, // this limits the top "n" to 1000 and
	//can be build using heap implementation in tress.
	//this is the drawback of using util's priorityqueue.
			new Comparator<PageStruct>() {
		public int compare(PageStruct page1, PageStruct page2) {
            return page1.count >= page2.count ? -1:1;
        }
	}
	);
	PriorityQueue<PageStruct> deleted = new PriorityQueue<>(1000,
			new Comparator<PageStruct>() {
		public int compare(PageStruct page1, PageStruct page2) {
            return page1.count >= page2.count ? -1:1;
        }
	}
	);
	
	 public void reportPageAccess(String pageUrl) {
		 if (pages.containsKey(pageUrl))
		 {
			 pages.put(pageUrl, pages.get(pageUrl)+1); 
			 //Heapify
			 while (queue.size() > 0)
			 {
				 PageStruct temp = queue.poll();
				 if (temp.name.equals(pageUrl))
				 {
					 deleted.add(new PageStruct(temp.name,temp.count+1));
					 	break; 
				 }
				 else
				 {
					 deleted.add(new PageStruct(temp.name, temp.count));
				 }
				 	
			 }
			 while (deleted.size() > 0)
			 {
				 queue.add(deleted.poll());
			 }
		 }
		 else
		 {
			 pages.put(pageUrl, 1);
			 queue.add(new PageStruct(pageUrl, 1));
		 }
		 
	 // your pre here
	 }
	 // the size of the list returned must be n
	 public ArrayList<String> getTopNPages(int n) {
		 ArrayList<String> result = new ArrayList<>();
		 String temp;
		
		 for (int i=n; i >0; i--)
		 {
			 if(queue.size() > 0)
			 {
				 PageStruct ps = queue.poll();
				 result.add(ps.name);
				 System.out.println(ps.name);
			 }
		 }
		return result;
	 // your pre here
	 }
}
