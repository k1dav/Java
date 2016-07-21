package ch03;

public class ch03_04 {
	public static void main(String args[]){
		int score=88;
		System.out.println("Your grade is "+score);
		if(score>=90){
			System.out.println("Your level is A\n");
		}
		else if ((score >=70)&&(score<90)){
			System.out.println("Your level is B\n");
		}
		else{
			System.out.println("Your level is C\n");
		}
		score=60;
		System.out.println("Your grade is "+score);
		if(score>=90){
			System.out.println("Your level is A\n");
		}
		else if ((score >=70)&&(score<90)){
			System.out.println("Your level is B\n");
		}
		else{
			System.out.println("Your level is C\n");
		}
	}
}
