package ch03;

public class ch03_01 {
	public static void main(String args[]){
		int Tim=20,Tracy=23;
		System.out.println("Tim = "+Tim+" Tracy = "+Tracy);
		if(Tim<Tracy){
			System.out.println("Tim is younger than Tracy");
		}
		
		Tim =25;
		System.out.println("Tim = "+Tim+" Tracy = "+Tracy);
		if(Tim>Tracy){
			System.out.println("Tim is older than Tracy");
		}
		
		Tim =23;
		System.out.println("Tim = "+Tim+" Tracy = "+Tracy);
		if(Tim==Tracy){
			System.out.println("Tim is as young as Tracy");
		}
	}
}
