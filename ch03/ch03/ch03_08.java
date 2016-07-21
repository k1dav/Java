package ch03;

public class ch03_08 {
	public static void main(String args[]){
		System.out.println("sum of odd (1~10)");
		int sum =0;
		System.out.println("All odd");
		for (int i=1;i<=10;i++){
			if(i%2!=0){
				sum+=i;
				System.out.print(i+" ");
			}
		}
		System.out.println("\nSum is "+sum);
	}
}
