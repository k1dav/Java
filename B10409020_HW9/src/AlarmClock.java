
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author k1dave6412
 */
public class AlarmClock {

    private static Time time;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            time = new Time();
            try {
                System.out.print("請設定鬧鐘時間(HH:MM:SS): ");
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                setTime(input);
                break;
            } catch (TimeFormatException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static void setTime(String input) throws TimeFormatException {
        Pattern pattern = Pattern.compile("[\\d]+:[\\d]+:[\\d]+");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String times[] = input.split(":");
            if (Integer.parseInt(times[0]) <= 23) {
                if (Integer.parseInt(times[1]) <= 59) {
                    if (Integer.parseInt(times[2]) <= 59) {
                        time.showTime(Integer.parseInt(times[0]), Integer.parseInt(times[1]), Integer.parseInt(times[2]));
                    } else {
                        throw new TimeFormatException("SEC格式錯誤");
                    }
                } else {
                    throw new TimeFormatException("MIN格式錯誤");
                }
            } else {
                throw new TimeFormatException("HOUR格式錯誤");
            }
        } else {
            throw new TimeFormatException("請輸入正確的時間格式");
        }
    }

}
