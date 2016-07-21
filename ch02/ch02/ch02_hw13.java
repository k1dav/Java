package ch02;
import java.io.*;

public class ch02_hw13 {
	public static void main(String args[])throws IOException{
		final double pi=3.1415926;
		System.out.print("Please input r of circle:");
		java.util.Scanner input_obj=new java.util.Scanner(System.in);
		float r=input_obj.nextInt();
		System.out.println("You input "+r);
		System.out.println("The area of circle is "+pi*pi*r);
		System.out.println("The perimeter of circle is "+2*pi*r);
	}
}
