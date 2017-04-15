/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dav
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("***********************\n"
                    + "1.    驗證身份證字號\n"
                    + "2.    產生身份證字號\n"
                    + "0.    離開\n"
                    + "***********************\n"
                    + "請選擇:");

            String again = sc.nextLine();
            if (again.equals("0")) {
                break;
            } else if (again.equals("1")) {
                System.out.print("請輸入身份證字號：");
                String id = sc.nextLine();
                System.out.println();

                String patternStr = "^[a-zA-Z][1|2][0-9]{8}$";
                Pattern pattern = Pattern.compile(patternStr);
                Matcher matcher = pattern.matcher(id);
                if (matcher.find()) {
                    ID myId = new ID();
                    myId.check(id, 0);
                } else {
                    System.out.println("是位連身份證都不會打der朋友呢！");
                }
            } else if (again.equals("2")) {
                System.out.print("請輸入縣市：");
                String reg = sc.nextLine();
                System.out.print("請輸入性別：");
                String gen = sc.nextLine();
                System.out.println();
                ID newID = new ID();
                newID.generate(gen, reg);

            } else {
                System.out.println("是位連選項都不會打der朋友呢！");
            }

        }
    }

}
