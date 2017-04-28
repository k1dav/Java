
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
public class BookStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book account = Book.ACCOUNT;
        Book statics = Book.STATIC;
        Book programming = Book.PROGRAMMING;
        Book eco = Book.ECO;
        Book history = Book.HISTORY;
        Book english = Book.ENGLISH;

        String again = "y";
        Scanner sc = new Scanner(System.in);

        while (again.equals("Y") | again.equals("y")) {
            System.out.println("********** Welcome to Book Store **********");
            for (Book b : Book.values()) {
                System.out.println(b.toString());
            }

            System.out.print("請輸入訂購書籍[1-6]: ");
            String choose = sc.nextLine();
            Pattern pattern = Pattern.compile("^[1-6]{1}$");
            Matcher matcher = pattern.matcher(choose);
            if (matcher.find()) {
                System.out.print("數量:");
                String number = sc.nextLine();
                pattern = Pattern.compile("^[0-9]+$");
                matcher = pattern.matcher(number);

                if (matcher.find()) {
                    for (Book b : Book.values()) {
                        if (Integer.parseInt(choose) == b.getIndex()) {
                            b.buyBook(Integer.parseInt(number));
                            break;
                        }
                    }
                } else {
                    System.out.println("請輸入數量");
                }

            } else {
                System.out.println("請輸入正確書籍代碼!");
            }

            System.out.print("繼續選購嗎(Y/N):");
            again = sc.nextLine();
        }

        while (true) {
            System.out.print("請輸入您的姓名: ");
            String name = sc.nextLine();
            Pattern pattern = Pattern.compile("[a-zA-Z_]+[0-9]*");
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                System.out.print("請輸入您的電話: ");
                String phone = sc.nextLine();
                pattern = Pattern.compile("^[0-9]{4}-[0-9]{6}$");
                matcher = pattern.matcher(phone);

                if (matcher.find()) {
                    BookOrder Order =  new BookOrder(name,phone);
                    Order.printOrder();
                    break;
                } else {
                    System.out.println("電話格式有誤! (格式: 0000-000000)");
                }
            } else {
                System.out.println("請輸入正確姓名!");
            }
        }

    }

}
