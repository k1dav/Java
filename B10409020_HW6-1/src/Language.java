/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dav
 */
public class Language {

    private String rank;
    private String programming;
    private String rating;

    Language(String r, String p, String rate) {
        this.rank = r;
        this.programming = p;
        this.rating = rate;
    }

    public String getRank() {
        return this.rank;
    }

    public String getProgramming() {
        return this.programming;
    }

    public String getRate() {
        return this.rating;
    }
}
