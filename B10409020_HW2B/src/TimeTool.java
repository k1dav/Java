
/**
 *
 * @author k1dav
 */
import java.util.Date;

public class TimeTool {

    /**
     * showCurrentTime�G��ܥثe�ɶ�
     */
    public static void showCurrentTime() {
        Date now = new Date(); // �إ� Date ����|�O���ثe���ɶ�(��l��)
        System.out.println(now); // �i�����L�X Date ����ҰO�����ɶ���T
    }

    /**
     * isLeapYear�G�P�_���w�~���O�_���|�~
     *
     * @param int year
     * @return boolean
     */
    public static boolean isLeapYear(int year) {
        boolean isLeapYear = false;
        /*
		 * �P�_�O�_���|�~���W�h�p�U�A�����䤤�@�ӧY���|�~�G
		 * 1. �褸�~�O 4 �����ơA�����O 100 �����ơA�Ҧp�G1996 �~�C
		 * 2. �褸�~�O 400 �����ơA�Ҧp�G2000 �~�C
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
