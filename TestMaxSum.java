package com.amazon.adtech;

public class TestMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSum ms = new MaxSum();
		int[] arr ={4, 1, 3,6};
		int max = ms.getMaxSum(arr);
		System.out.println(max);
		
		WebAnalyzer wa = new WebAnalyzer();
		wa.reportPageAccess("a");
		wa.reportPageAccess("b");
		wa.reportPageAccess("b");
		wa.reportPageAccess("b");
		wa.reportPageAccess("b");
		wa.reportPageAccess("b");
		
		wa.reportPageAccess("c");
		wa.reportPageAccess("c");
		wa.reportPageAccess("c");
		wa.reportPageAccess("c");
		
		wa.reportPageAccess("d");
		wa.reportPageAccess("d");
		wa.reportPageAccess("d");
		wa.reportPageAccess("d");
		wa.reportPageAccess("d");
		
		wa.getTopNPages(20);
	}

}
