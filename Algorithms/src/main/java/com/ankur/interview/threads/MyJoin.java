package com.ankur.interview.threads;

public class MyJoin implements Runnable  {

	public MyJoin() {
		// TODO Auto-generated constructor stub
	}

	public void run() {
		// TODO Auto-generated method stub
		try{
			for(int i=0;i<10;i++){
				System.out.print(i+" : ");
				Thread.sleep(1000);
			}
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
public static void main(String[] args) {
	Thread t1=new Thread(new MyJoin());
	System.out.println("Inside the Main");
	t1.start();
	System.out.println("before join");
	try {
		t1.sleep(100);
		t1.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("after join");

}
}
