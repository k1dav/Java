
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
                System.out.println("1)�}��");
                System.out.println("2)�s��");
                System.out.println("3)����");
                System.out.println("4)�ثe�l�B");
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
                            System.out.print("�п�J�}����B�G");

                            money = sc.nextFloat();

                            ac.OpenAc(money);
                        } else {
                            System.out.println("��x�A�w�}��I");
                        }
                        break;
                    case 2:
                        if (ac.GetStatus()) {
                            System.out.print("�п�J�s�ڪ��B�G");

                            money = sc.nextFloat();

                            ac.Deposit(money);
                        } else {
                            System.out.println("���}��I");
                        }
                        break;
                    case 3:
                        if (ac.GetStatus()) {
                            System.out.print("�п�J���ڪ��B�G");

                            money = sc.nextFloat();

                            ac.WithDraw(money);
                        } else {
                            System.out.println("���}��I");
                        }
                        break;
                    case 4:
                        if (ac.GetStatus()) {
                            ac.GetBalancec();
                        } else {
                            System.out.println("���}��I");
                        }
                        break;
                    default:
                        System.out.println("�п�J�ﶵ�Ʀr�I");
                        break;
                }

            } catch (Exception e) {
                System.out.println("�п�J���T���Ʀr�Ϊ��B");
            }
        } while (doloop);
        System.out.println("���¥��{�I");
    }
}
