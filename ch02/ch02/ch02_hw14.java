package ch02;
import java.io.*;

public class ch02_hw14 {
	public static void main(String args[])throws IOException{
		java.util.Scanner input_obj=new java.util.Scanner(System.in);
		System.out.println("Please input the up-side of Trapezoid");
		float up_side = input_obj.nextFloat();
		System.out.println("Please input the down-side of Trapezoid");
		float down_side = input_obj.nextFloat();
		System.out.println("Please input the height of Trapezoid");
		float height = input_obj.nextFloat();
		System.out.println("The area of Trapezoid is "+(up_side+down_side)*height/2);
	}
}
