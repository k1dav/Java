
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
public class TimeLengthTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TimeLength time = null;
        String choose = "1";

        while (!choose.equals("0")) {
            System.out.print("\n***Convert Length of Time***\n" //Menu
                    + "1) Set a length of time.\n"
                    + "2) Adjuset the Length of time.\n"
                    + "3) Show the length of time in different units.\n"
                    + "\n"
                    + "Please enter a number in [1,2,3,0]:");

            choose = sc.nextLine();

            Pattern pattern;
            Matcher matcher;
            switch (Integer.parseInt(choose)) {                 //switch
                case 1:
                    System.out.print("Please enter a time (seconds or hh:mm:ss):");
                    String input = sc.nextLine();

                    pattern = Pattern.compile("^[-+]?[0-9]*:[0-9]*:[0-9]*$");       //input hh:mm:ss
                    matcher = pattern.matcher(input);
                    if (matcher.find()) {                                                   //is hh:mm:ss
                        String[] AfterInput = input.split(":");
                        time = new TimeLength(Integer.parseInt(AfterInput[0]), Integer.parseInt(AfterInput[1]), Integer.parseInt(AfterInput[2]));
                        break;
                    }

                    pattern = Pattern.compile("^[-+]?[0-9]*$");                             //input seconds
                    matcher = pattern.matcher(input);                                       // is seconds
                    if (matcher.find()) {
                        time = new TimeLength(Integer.parseInt(input));
                        break;
                    }

                    System.out.println("Input Error");

                case 2:
                    if (time == null) {
                        System.out.println("Object isn' exist.");
                        break;
                    }
                    System.out.print("Please enter a time (seconds or hh:mm:ss):");
                    input = sc.nextLine();

                    pattern = Pattern.compile("^[-+]?[0-9]*:[0-9]*:[0-9]*$");       //input hh:mm:ss
                    matcher = pattern.matcher(input);
                    if (matcher.find()) {                                                   //is hh:mm:ss
                        String[] AfterInput = input.split(":");
                        time.setTime(Integer.parseInt(AfterInput[0]), Integer.parseInt(AfterInput[1]), Integer.parseInt(AfterInput[2]));
                        break;
                    }

                    pattern = Pattern.compile("^[-+]?[0-9]*$");                             //input seconds
                    matcher = pattern.matcher(input);                                       // is seconds
                    if (matcher.find()) {
                        time.setTime(Integer.parseInt(input));
                        break;
                    }

                    System.out.println("Input Error");
                    break;
                case 3:
                    if (time == null) {
                        System.out.println("Object isn' exist.");
                        break;
                    }
                    time.showTime();
                    break;

                default:
                    choose = "0";
                    break;
            }
        }
    }
}
