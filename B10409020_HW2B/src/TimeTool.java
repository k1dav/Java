
/**
 *
 * @author k1dav
 */
import java.util.Date;

public class TimeTool {

    /**
     * showCurrentTime：顯示目前時間
     */
    public static void showCurrentTime() {
        Date now = new Date(); // 建立 Date 物件會記錄目前的時間(初始化)
        System.out.println(now); // 可直接印出 Date 物件所記錄的時間資訊
    }

    /**
     * isLeapYear：判斷指定年份是否為閏年
     *
     * @param int year
     * @return boolean
     */
    public static boolean isLeapYear(int year) {
        boolean isLeapYear = false;
        /*
		 * 判斷是否為閏年的規則如下，滿足其中一個即為閏年：
		 * 1. 西元年是 4 的倍數，但不是 100 的倍數，例如：1996 年。
		 * 2. 西元年是 400 的倍數，例如：2000 年。
         */
        if ((year % 4) == 0 && (year % 100) != 0 || (year % 400) == 0) {
            isLeapYear = true;
        }

        return isLeapYear;
    }

    public static void ShowCalendar(int year, int month) {
        int[] mon = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        for (int i = 1; i < year; i++) {//every year days+
            if (isLeapYear(i)) {
                days += 366;
            } else {
                days += 365;
            }
        }
        if (isLeapYear(year)) {//month days +
            mon[1] = 29;        //leap year Feb
        } else {
            mon[1] = 28;
        }
        for (int i = 1; i < month; i++) {
            days += mon[i-1];
        }
        days += 1; //first day of month
        System.out.printf("\n%s%s%s%s%s%s%s\n", " Sun", " Mon", " Tue", " Wed", " Thu", " Fri", " Sat");

        int d = days % 7;
        for (int i = 1; i <= d; i++) {
            System.out.printf("    ");
        }
        for (int i = 1; i <= mon[month - 1]; i++) {
            System.out.printf("%4d", i);
            d++;
            if (d % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n");

    }
}
