package ch02;

public class ch02_14 {
	public static void main(String args[]){
		int a=7,b=8,c=9;
		System.out.println("a<b && b<c || c<a = "+(a<b && b<c ||c<a));
		System.out.println("!(a<b) && b<c || c<a = "+(!(a<b) && b<c ||c<a));
	}
}
