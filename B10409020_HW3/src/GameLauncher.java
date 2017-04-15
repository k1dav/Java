
/**
 *
 * @author k1dav
 */
import java.util.ArrayList;
import java.util.Scanner;

public class GameLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int min = 0, max = 0, limit = 0, guessTimes = 0;
        String again = "Y";
        ArrayList<Integer> input = new ArrayList<Integer>();

        while (again.equals("Y")) {
            System.out.println("********** 猜數字遊戲 **********");
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("請輸入猜數字範圍最小值：");
                min = sc.nextInt();
                System.out.print("請輸入猜數字範圍最大值：");
                max = sc.nextInt();
                System.out.print("請輸入猜數字次數限制：");
                limit = sc.nextInt();
            } catch (Exception e) {
                System.out.println("輸入錯誤，將重新執行。");
            }

            Guess game = new Guess(min, max);

            for (int i = 1; i <= limit; i++) {
                int guessNum = 0;
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.printf("數字範圍： %d ~ %d \n", min, max);
                    System.out.print("請輸入您猜的數字：");
                    guessNum = sc.nextInt();

                    while (guessNum < min || guessNum > max) {
                        System.out.println("猜錯了! 您猜的數字超出答案範圍！請重新輸入！");
                        System.out.print("請輸入您猜的數字：");
                        guessNum = sc.nextInt();
                    }

                    input.add(guessNum);

                    switch (game.numCheck(guessNum)) {
                        case -1:
                            System.out.println("猜錯了! 您猜的數字比答案小!");
                            min = guessNum;
                            break;
                        case 0:
                            System.out.println("恭喜您猜對了!");
                            guessTimes = i;
                            i = limit;
                            break;
                        case 1:
                            System.out.println("猜錯了! 您猜的數字比答案大!");
                            max = guessNum;
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("輸入錯誤，將重新執行。");
                }
            }

            System.out.println("*********** 遊戲結束 ***********");
            int inputSize = input.size();
            for (int i = 0; i < inputSize; i++) {
                System.out.printf("第 %d 猜：%d\n", i + 1, input.remove(0));
            }
            System.out.printf("猜數字限制 %d 次\n", limit);
            System.out.printf("您總共猜了 %d 次\n", guessTimes);
            System.out.printf("正確答案： %d \n", game.getAns());

            System.out.println("******** 再玩一次(Y/N)? ********");
            System.out.println("請輸入 (Y/N) ：");
            Scanner sc = new Scanner(System.in);
            again = sc.next().toUpperCase();
        }

    }

}
