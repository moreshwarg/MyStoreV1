package demo;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class D {
	static int b=111;
	static int a=10;
	
	public void demo() {
		int a=11;
		int b = 22;
	}
	public static void demo1() {
	System.out.println("static method");
	}
	public  void demo2() {
		System.out.println("Non-static method");
		}

	public static void main(String[] args) {
		//System.out.println();
		D d= new D();
		demo1();
		D.demo1();
		d.demo2();
}
}