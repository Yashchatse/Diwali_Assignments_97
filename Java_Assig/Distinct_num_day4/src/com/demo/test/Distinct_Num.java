package com.demo.test;
public class Distinct_Num {
	public int missingNum(int [] nums) {
		int n = nums.length;
		int expSum= n*(n+1)/2;
		int actualNum =0;
		for(int num : nums) {
			actualNum += num;
		}
		return expSum - actualNum;
	}
	
	public static void main(String [] args) {
		 Distinct_Num dd = new Distinct_Num();
		 
		
        int[] nums2 = {0, 1};
        System.out.println("Missing number in [0, 1]: " + dd.missingNum(nums2)); 

      
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Missing number in [9,6,4,2,3,5,7,0,1]: " + dd.missingNum(nums3)); 

	}

}
