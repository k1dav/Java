
import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author k1dav
 */
public class ABGuess {

    private String ans = "";
    private int count = 0;

    ABGuess() {
        System.out.println("********** 猜數字遊戲 **********");
        int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};      //random int array
        for (int i = 0; i < num.length; i++) {
            int temp = num[i];
            int random = (int) (Math.random() * 10);
            num[i] = num[random];
            num[random] = temp;
        }

        ans = Arrays.toString(num).replaceAll("\\[|\\]|,|\\s", "");
        ans = ans.substring(0, 4);
    }

    public String getAns() {
        return this.ans;
    }

    public boolean checkAns(String guess) {
        count += 1;
        int a = 0, b = 0;
        for (int i = 0; i < ans.length(); i++) {
            if (guess.charAt(i) == this.ans.charAt(i)) {
                a += 1;
            } else if (guess.indexOf(ans.charAt(i)) != -1) {
                b += 1;
            }
        }
        System.out.printf("%dA%dB\n", a, b);
        if (a == 4) {
            System.out.println("恭喜您答對了!\n *********** 遊戲結束 ***********");
            System.out.printf("您總共猜了 %d 次\n",this.count);
            return true;
            
        }
        return false;
    }
}
