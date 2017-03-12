
import java.util.Scanner;

/**
 *
 * @author k1dav
 */
public class AccountTest {

    public static void main(String[] args) {
        boolean doloop = true;
        Account ac = new Account();

        do {//loop
            try {

                System.out.println("***Main Menu***");
                System.out.println("1)開戶");
                System.out.println("2)存款");
                System.out.println("3)提款");
                System.out.println("4)目前餘額");
                System.out.println("0)Exit");

                System.out.print("\nPlease enter a number in [1,2,3,4,0]:");
                Scanner sc = new Scanner(System.in);
                int input = sc.nextInt();

                float money = 0;
                switch (input) {        //function switch
                    case 0:
                        doloop = false;
                        break;
                    case 1:
                        if (!ac.GetStatus()) {
                            System.out.print("請輸入開戶金額：");

                            money = sc.nextFloat();

                            ac.OpenAc(money);
                        } else {
                            System.out.println("賣鬧，已開戶！");
                        }
                        break;
                    case 2:
                        if (ac.GetStatus()) {
                            System.out.print("請輸入存款金額：");

                            money = sc.nextFloat();

                            ac.Deposit(money);
                        } else {
                            System.out.println("未開戶！");
                        }
                        break;
                    case 3:
                        if (ac.GetStatus()) {
                            System.out.print("請輸入提款金額：");

                            money = sc.nextFloat();

                            ac.WithDraw(money);
                        } else {
                            System.out.println("未開戶！");
                        }
                        break;
                    case 4:
                        if (ac.GetStatus()) {
                            ac.GetBalancec();
                        } else {
                            System.out.println("未開戶！");
                        }
                        break;
                    default:
                        System.out.println("請輸入選項數字！");
                        break;
                }

            } catch (Exception e) {
                System.out.println("請輸入正確的數字或金額");
            }
        } while (doloop);
        System.out.println("謝謝光臨！");
    }
}
