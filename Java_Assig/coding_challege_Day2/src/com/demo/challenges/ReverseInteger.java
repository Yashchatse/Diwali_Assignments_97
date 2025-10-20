package com.demo.challenges;

public class ReverseInteger {
public int Reverse(int val) {
	int rev = 0;
	while(val != 0) {
		rev = rev * 10 + val % 10;
		val /=10;
	}
	return rev;
}
public static void main(String[] args) {
	ReverseInteger ri = new ReverseInteger();
	System.out.println(ri.Reverse(2531));
}
}
