package com.demo.test;

public class RotateArray {

	public void Rotate(int[] nums, int k)
	{
	    if (nums == null || nums.length <= 1) 
	        return;
	    
	    int n = nums.length;
	    k = k % n;  // Handle cases where k > n

	    // Reverse entire array
	    Reverse(nums, 0, n - 1);
	    // Reverse first k elements
	    Reverse(nums, 0, k - 1);
	    // Reverse the rest
	    Reverse(nums, k, n - 1);
	}

	private void Reverse(int[] nums, int start, int end)
	{
	    while (start < end)
	    {
	        int temp = nums[start];
	        nums[start] = nums[end];
	        nums[end] = temp;
	        start++;
	        end--;
	    }
	}
	 public static void printArray(int[] arr) {
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	        System.out.println();
	    }
	
	public static void main(String []args) {
		 int[] arr = {1, 2, 3, 4, 5, 6, 7}; 
	        
	        System.out.println("Original array:");
	        printArray(arr);

	        int k = 3;

	        RotateArray rs = new RotateArray();
	        rs.Rotate(arr, k);

	        System.out.println("Array after rotating right by " + k + " steps:");
	        printArray(arr);
	}
}
