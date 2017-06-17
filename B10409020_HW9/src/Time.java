
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author k1dave6412
 */
public class Time {

    final static int TIME_MIN_TO_SEC = 60;
    final static int TIME_HOUR_TO_MIN = 60;
    final static int TIME_HOUR_TO_SEC = 3600;

    private int seconds;

    Time() {
        Date date = new Date();
        System.out.println(date.toString());
        this.seconds = date.getHours() * TIME_MIN_TO_SEC + date.getMinutes() * TIME_MIN_TO_SEC + date.getSeconds();
    }

    public void showTime(int h, int m, int s) {
        int tmp = 0;
        int alarm = h * TIME_MIN_TO_SEC + m * TIME_MIN_TO_SEC + s;
        if (alarm >= this.seconds) {
            tmp = alarm - this.seconds;
        } else {
            tmp = alarm - this.seconds + 3600 * 24;
        }
        
        System.out.print("�w�N�x���]�w�b ");

        System.out.printf("%02d �p�ɤS ", tmp / TIME_HOUR_TO_SEC);
        tmp %= TIME_HOUR_TO_SEC;
        System.out.printf("%02d ���� ", tmp / TIME_MIN_TO_SEC);
        tmp %= TIME_MIN_TO_SEC;
        System.out.printf("%02d ������Ұ�\n", tmp);
    }

}
