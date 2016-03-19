package com.amazon.adtech;

import java.util.ArrayList;

public class MaxSum {
	public int getMaxSum(int[]arr)
	{
		int n = arr.length;
		//Case only when one size array is input
		if(n==1)
		{
			
			return arr[0];
		}
		int Max = arr[0]>arr[1]? arr[0]:arr[1];
		//Case only when two ssize array is input
		if(n ==2)
			return Max;
		//Here we check for if the last element is selected or not.
		boolean lastSel=arr[0]>arr[1]?false:true;
		//Here we copy the value of the last removed item.
		int lastremoved = 0;
		for(int i=2; i <n;i++)
		{
			//Condition for the current item to be selected and last item to be removed.
			if(arr[i] + arr[i-2] > arr[i-1])
			{
				if(lastSel)
				{
					Max= Max-arr[i-1]+arr[i] + lastremoved;
					lastremoved =arr[i-1];
					lastSel = true;
				}
				else
				{
					Max = Max+arr[i];
					lastSel = true;
				}
			}
			else
				lastSel= false;
			
						
		}
		return Max;
	}
}
