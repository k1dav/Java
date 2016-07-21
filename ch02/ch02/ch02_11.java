package ch02;

public class ch02_11 {
	public static void main(String args[]){
		int a=15,b=3;
		System.out.println("(a>10)&&(b>5) is "+(a>10&&b>5));
		System.out.println("(a>10)||(b>5) is "+(a>10||b>5));
		System.out.println("(a>10)&(b>5) is "+(a>10&b>5));
		System.out.println("(a>10)|(b>5) is "+(a>10|b>5));
		System.out.println("(a>10)^(b>5) is "+(a>10^b>5));
		System.out.println("15&3 is "+(a&b));
		System.out.println("15|3 is "+(a|b));
		System.out.println("15^3 is "+(a^b));
		System.out.println("~3 is "+(~b));
	}
}
