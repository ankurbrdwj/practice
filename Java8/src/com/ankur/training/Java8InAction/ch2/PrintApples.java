package com.ankur.java.Java8InAction.ch2;

import java.util.ArrayList;
import java.util.List;

public class PrintApples {

	public PrintApples() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Apple>inventory=new ArrayList<Apple>();
List<Apple> list=prettyPrintApples(inventory,(ApplePredicate a)->a.test(inventory.));
	}
	public List<T> prettyPrintApples(List<T> inventory,ApplePredicate<T> applePredicate){
	for(Apple apple: inventory){
		String output=applePredicate.test(apple);
		System.out.println(output);
	}
}
}
