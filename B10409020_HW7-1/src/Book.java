/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public enum Book {
    ACCOUNT(1, "會計學", 360), STATIC(2, "統計學", 245), PROGRAMMING(3, "程式語言", 600),
    ECO(4, "經濟學", 445), HISTORY(5, "本國史", 180), ENGLISH(6, "英文", 350);

    private int index, price, number;
    private String name;

    private Book(int i, String n, int p) {
        this.index = i;
        this.name = n;
        this.price = p;
        this.number = 0;
    }

    public void buyBook(int n) {
        this.number += n;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return this.index + ")" + this.name + "    \t\t" + this.price + " 元";
    }

}
