
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
public class BookOrder {

    private long orderNo;
    private String name, phone, createTime;

    BookOrder(String n, String p) {
        Date dateTime = new Date();
        long timestamp = dateTime.getTime() / 1000;
        this.orderNo = timestamp;
        this.name = n;
        this.phone = p;
        this.createTime = dateTime.toString();
    }

    public void printOrder() {
        System.out.println("********** �q�ʩ��� **********");
        System.out.printf("�q��s��: %10d\t �R�a�m�W: %s\t�p���q��: %s\n", this.orderNo, this.name, this.phone);
        System.out.println("--------------------------------------------------");
        System.out.printf("%-4s\t%8s%8s%10s\n", "���y�W��", "���", "�ƶq", "�p�p");

        int sum = 0;
        for (Book b : Book.values()) {
            if (b.getNumber() != 0) {
                int total = b.getPrice() * b.getNumber();
                System.out.printf("%-4s\t%10s%10s%12s\n", b.getName(), b.getPrice(), b.getNumber(), total);
                sum += total;
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("%5s\t%24s\n", "���I���B: ", sum);
        System.out.println("�q�榨�߮ɶ�: " + this.createTime);
    }

}
