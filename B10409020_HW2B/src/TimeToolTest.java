
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
                int input = scanner.nextInt(); // 獲取用戶輸入(String)

                switch (input) {
                	case 0:
                		doloop = false;
                		break;
                    case 1:
                        TimeTool.showCurrentTime(); // 顯示目前時間
                        break;
                    case 2:
                        System.out.print("Please enter the number of year: ");
                        int year = scanner.nextInt(); // 獲取用戶輸入(Integer)
                        if (TimeTool.isLeapYear(year)) // 判斷指定年份是否為閏年
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
                        System.out.println("請輸入正確的數值");
                        break;
                }
            } catch (Exception e) {
                System.out.println("請輸入正確的數值");
            }
        } while (doloop); // 若 input 不為 0 則繼續執行迴圈
    }
}
