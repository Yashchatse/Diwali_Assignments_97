package com.demo.test;

import java.util.Arrays;

public class MergeSortedArr {
	public int[] merge(int[] A , int[] B) {
		int n = A.length;
		int m = B.length;
		int[] result = new int[n + m];
		int i = 0, j =0, k =0;
		while(i< n && j < m) {
			if(A[i]<= B[j]) {
				result[k++]= A[i++];
			}else {
				result[k++]= B[j++];
			}
		}
		while(i <n) {
			result[k++] = A[i++];
		}
		while(j < m) {
			result[k++] = B[j++];
		}
		return result;
	}

	
	public static void main(String [] args) {
		MergeSortedArr aM= new MergeSortedArr();
		 int[] nums1 = {1, 3, 5, 7};
	        int[] nums2 = {2, 4, 6, 8, 9};
	        int[] merged = aM.merge(nums1, nums2);
	        
	        System.out.println(Arrays.toString(merged));	
	
	}
}
