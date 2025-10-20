package com.demo.QuickSort;

public class QuickSort {

	
	    public static void quickSort(String[] arr, int low, int high) {
	        if (low < high) {
	            int pi = partition(arr, low, high);
	            quickSort(arr, low, pi - 1);
	            quickSort(arr, pi + 1, high);
	        }
	    }

	    private static int partition(String[] arr, int low, int high) {
	        String pivot = arr[high];
	        int i = low - 1;

	        for (int j = low; j < high; j++) {
	         
	            if (arr[j].compareTo(pivot) <= 0) {
	                i++;
	                swap(arr, i, j);
	            }
	        }
	        swap(arr, i + 1, high);
	        return i + 1;
	    }

	    private static void swap(String[] arr, int i, int j) {
	        String temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }

	    
	    public static void main(String[] args) {
	        String[] words = {"banana", "apple", "cherry", "date", "elderberry"};
	        System.out.println("Before: " + java.util.Arrays.toString(words));
	        quickSort(words, 0, words.length - 1);
	        System.out.println("After:  " + java.util.Arrays.toString(words));
	    }
	}

