package ch02;
import java.io.*;

public class ch02_07 {
	private static char myData;

	public static void main(String args[]) throws IOException{
		/*System.out.print("[Basic IO practice]\n");
		System.out.print("Please Enter the char.");
		myData=(char)System.in.read();
		System.out.println("You Enter:"+myData);*/
		
		java.util.Scanner input_obj=new java.util.Scanner(System.in);
		System.out.print("Please input the string:");
		String str=input_obj.nextLine();
		System.out.println("You Input :"+str);
		
		System.out.print("Please input the integer:");
		int inta=input_obj.nextInt();
		System.out.println("You Input :"+inta);
		
		System.out.print("Please input the Double:");
		double d=input_obj.nextDouble();
		System.out.println("You Input :"+d);

	}
}
