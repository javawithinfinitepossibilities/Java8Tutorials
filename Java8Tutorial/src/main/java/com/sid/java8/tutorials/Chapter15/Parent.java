/**
 * 
 */
package com.sid.java8.tutorials.Chapter15;

/**
 * @author Lenovo
 *
 */
public class Parent {
	private static int i = 0;

	public static void parentStaticMethod() {
		System.out.println("Parent Static method");
	}

	static {
		System.out.println("Parent Static block");
	}

	{
		System.out.println("Parent Instance block");
	}

	/**
	 * 
	 */
	public Parent() {
		System.out.println("Parent Constractor");
	}

}
