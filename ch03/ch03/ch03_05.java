package ch03;

public class ch03_05 {
	public static void main(String args[]){
		int a=0,b=0;
		System.out.println("AND = ("+a+","+b+")");
		if(a==1){
			if(b==1){
				System.out.println(a+" AND "+b+"=1\n");
			}
			else{
				System.out.println(a+" AND "+b+"=0\n");
			}
		}
		else{
			System.out.println(a+" AND "+b+"=0\n");
		}
		a=1;
		System.out.println("AND = ("+a+","+b+")");
		if(a==1){
			if(b==1){
				System.out.println(a+" AND "+b+"=1\n");
			}
			else{
				System.out.println(a+" AND "+b+"=0\n");
			}
		}
		else{
			System.out.println(a+" AND "+b+"=0\n");
		}
		b=1;
		System.out.println("AND = ("+a+","+b+")");
		if(a==1){
			if(b==1){
				System.out.println(a+" AND "+b+"=1\n");
			}
			else{
				System.out.println(a+" AND "+b+"=0\n");
			}
		}
		else{
			System.out.println(a+" AND "+b+"=0\n");
		}
	}
}
