package ch03;

public class ch03_15 {
	public static void main(String args[]){
		int a[]={1,2,3,4,5,6,7,8,9};
		char b[]={'H','A','P','P','Y'};
		System.out.println("Int array");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println(" ");
		
		System.out.println("char array");
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]+" ");
		}
		System.out.println(" ");
		
		System.out.println("Int array");
		for(int i:a){
			System.out.print(i+" ");
		}
		System.out.println(" ");
		
		System.out.println("char array");
		for(char i:b){
			System.out.print(i+" ");
		}
		System.out.println(" ");
	}
}
