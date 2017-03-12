
/**
 *
 * @author k1dav
 */
import java.util.Scanner;

public class TimeToolTest {

    public static void main(String[] args) {
        boolean doloop = true;

        do {
            try {
                System.out.println("***Main Menu***");
                System.out.println("1) Show The Current Time");
                System.out.println("2) Leap Year");
                System.out.println("3) Show the Calendar");
                System.out.println("0) Exit");
                System.out.println();
                System.out.print("Please enter a number in [1,2,3,0]: ");

                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt(); // ����Τ��J(String)

                switch (input) {
                	case 0:
                		doloop = false;
                		break;
                    case 1:
                        TimeTool.showCurrentTime(); // ��ܥثe�ɶ�
                        break;
                    case 2:
                        System.out.print("Please enter the number of year: ");
                        int year = scanner.nextInt(); // ����Τ��J(Integer)
                        if (TimeTool.isLeapYear(year)) // �P�_���w�~���O�_���|�~
                        {
                            System.out.println(year + " is a leap year.");
                        } else {
                            System.out.println(year + " is not a leap year.");
                        }
                        break;
                    case 3:
                        System.out.print("Year: ");
                        int y = scanner.nextInt();
                        System.out.print("Month: ");
                        int m = scanner.nextInt();
                        TimeTool.ShowCalendar(y,m);
                        break;
                    default:
                        System.out.println("�п�J���T���ƭ�");
                        break;
                }
            } catch (Exception e) {
                System.out.println("�п�J���T���ƭ�");
            }
        } while (doloop); // �Y input ���� 0 �h�~�����j��
    }
}
