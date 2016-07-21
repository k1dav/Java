package ch03;

public class ch03_07 {
	public static void main(String args[]){
		int math_score=70;
		System.out.println("Michael's math is "+math_score);
		String str;
		str=(math_score>80)?"Good":"+U";
		System.out.println(str+"\n");
		
		math_score=90;
		System.out.println("Jane's math is "+math_score);
		str=(math_score>80)?"Good":"+U";
		System.out.println(str+"\n");
	}
}
