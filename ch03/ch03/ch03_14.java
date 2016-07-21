package ch03;

public class ch03_14 {
	public static void main(String args[]){
		int ans=sum(10);
		System.out.println("Sum of 1~10");
		System.out.println("Ans="+ans);
	}
	
	static int sum(int n){
		int sum=0;
		for(int i=1;i<=n;i++){
			sum+=i;
		}
		return sum;
	}
}
