/**
 * 
 */
package com.ankur.interview.trees.binary;

/**
 * @author ankurbrdwj
 *
 */
public class RecursiveFibonacci {

	/**
	 * 
	 */
	public RecursiveFibonacci() {
		// TODO Auto-generated constructor stub
	}
public static int fibonacci2(int number){
    if(number == 1 || number == 2){
        return 1;
    }
    int fibo1=1, fibo2=1, fibonacci=1;
    for(int i= 3; i<= number; i++){
       
        //Fibonacci number is sum of previous two Fibonacci number
        fibonacci = fibo1 + fibo2;             
        fibo1 = fibo2;
        fibo2 = fibonacci;
      
    }
    return fibonacci; //Fibonacci number
  
}   




	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //input to print Fibonacci series upto how many numbers
        System.out.println("Enter number upto which Fibonacci series to print: ");
        //int number = new Scanner(System.in).nextInt();
        int number = 10;
        System.out.println("Fibonacci series upto " + number +" numbers : ");
        //printing Fibonacci series upto number
        for(int i=1; i<=number; i++){
            System.out.print(fibonacci2(i) +" ");
        }
	}

}
