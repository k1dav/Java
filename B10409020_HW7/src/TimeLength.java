/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public class TimeLength {

    final static int TIME_MIN_TO_SEC = 60;
    final static int TIME_HOUR_TO_MIN = 60;
    final static int TIME_HOUR_TO_SEC = 3600;

    private int seconds;

    TimeLength(int sec) {
        this.seconds = sec;
        System.out.println("Time:" + sec);
    }

    TimeLength(int h, int m, int s) {
        this.seconds = h * TIME_HOUR_TO_SEC + m * TIME_MIN_TO_SEC + s;
        System.out.printf("Time:%02d:%02d:%02d", h, m, s);
    }

    public void setTime(int sec) {
        this.seconds += sec;
        System.out.println("Time:" + sec);
    }

    public void setTime(int h, int m, int s) {
        this.seconds += h * TIME_HOUR_TO_SEC + m * TIME_MIN_TO_SEC + s;
        System.out.printf("Time:%02d:%02d:%02d", h, m, s);

    }

    public void showTime() {
        int tmp = this.seconds;
        System.out.println("The current length of time (seconds): " + tmp);

        if (tmp >= 0) {
            System.out.print("The current length of time (hh:mm:ss): ");
        } else {
            System.out.print("The current length of time (hh:mm:ss): -");
            tmp = -this.seconds;
        }

        System.out.printf("%02d", tmp / TIME_HOUR_TO_SEC);
        tmp %= TIME_HOUR_TO_SEC;
        System.out.printf(":%02d", tmp / TIME_MIN_TO_SEC);
        tmp %= TIME_MIN_TO_SEC;
        System.out.printf(":%02d\n", tmp);
    }
}
