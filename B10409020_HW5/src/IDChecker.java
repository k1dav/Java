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
                    + "1.    ���Ҩ����Ҧr��\n"
                    + "2.    ���ͨ����Ҧr��\n"
                    + "0.    ���}\n"
                    + "***********************\n"
                    + "�п��:");

            String again = sc.nextLine();
            if (again.equals("0")) {
                break;
            } else if (again.equals("1")) {
                System.out.print("�п�J�����Ҧr���G");
                String id = sc.nextLine();
                System.out.println();

                String patternStr = "^[a-zA-Z][1|2][0-9]{8}$";
                Pattern pattern = Pattern.compile(patternStr);
                Matcher matcher = pattern.matcher(id);
                if (matcher.find()) {
                    ID myId = new ID();
                    myId.check(id, 0);
                } else {
                    System.out.println("�O��s�����ҳ����|��der�B�ͩO�I");
                }
            } else if (again.equals("2")) {
                System.out.print("�п�J�����G");
                String reg = sc.nextLine();
                System.out.print("�п�J�ʧO�G");
                String gen = sc.nextLine();
                System.out.println();
                ID newID = new ID();
                newID.generate(gen, reg);

            } else {
                System.out.println("�O��s�ﶵ�����|��der�B�ͩO�I");
            }

        }
    }

}
