/**
 * 
 */
package com.ankur.interview.hackerrank;

/**
 * @author ankurbrdwj
 *
 */
public class TrapRainWater {

	/**
	 * 
	 */
	public TrapRainWater() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
		System.out.println(new TrapRainWater().trapWater(arr));

	}
	 public int trap(int[] height) {
	        if(height == null || height.length==0) return 0;
	        int leftMax = 0, rightMax = 0, left = 0, max = 0;
	        int right = height.length-1;
	        while(left < right) {
	            leftMax = leftMax > height[left] ? leftMax : height[left];
	            rightMax = rightMax > height[right] ? rightMax : height[right];
	            max += leftMax < rightMax ? leftMax - height[left++] : rightMax - height[right--];
	        }
	        return max;
	    }
	 public int trapWater(int[] height) {
		    int result = 0;
		    if(height==null || height.length<=2)
		        return result;
		    int left[] = new int[height.length];
		    int right[]= new int[height.length];
		 
		    //scan from left to right
		    int max = height[0];
		    left[0] = height[0];
		    for(int i=1; i<height.length; i++){
		        if(max>height[i]){
		            left[i]=max;
		        }else{
		            left[i]=height[i];
		            max = height[i];
		        }
		    }
		 
		    //scan from right to left
		    max = height[height.length-1];
		    right[height.length-1]=height[height.length-1];
		    for(int i=height.length-2; i>=0; i--){
		        if(height[i]<max){
		            right[i]=max;
		        }else{
		            right[i]=height[i];
		            max = height[i];
		        }
		    }
		 
		    //calculate totoal
		    for(int i=0; i<height.length; i++){
		        result+= Math.min(left[i],right[i])-height[i];
		    }
		 
		    return result;
		}
}
