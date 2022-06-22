package com.ankur.interview.hackerrank;

public class BinarySearch {

	public BinarySearch() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int [] arr={1,2,3,4,5,6,7,8,9};
int start=0;
int end=arr.length-1;
int index=binarySearch(arr,5, start, end);
 System.out.println(index);
	}

	private static int binarySearch(int[] arr, int key,int start,int end) {
		// TODO Auto-generated method stub
		if(start>end)
			return -1;
		int middle=(start+end)/2;
		if(arr[middle]==key)
		return middle;
		else if(arr[middle]>key)
			binarySearch(arr,key,start,middle-1);
		return binarySearch(arr,key,middle+1,end);
	}
}
