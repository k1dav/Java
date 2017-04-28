
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author k1dav
 */
public class Ranking {

    private Language[] language = new Language[20];

    public void read() throws Exception {
        File fin = new File("index.html");
        FileInputStream fis = new FileInputStream(fin);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        StringBuffer sb = new StringBuffer();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }

        String output = readTable(sb.toString());
        loadStr(output);

        br.close();
        fis.close();
    }

    public void write() throws Exception {
        File fout = new File("result.txt");
        
        Formatter fmt = new Formatter(fout);
        fmt.format("%-8s%-24s%10s\r\n", "Rank", "Programming Language", "Ratings");
        fmt.flush();
        for (int i = 0; i < language.length; i++) {
            fmt.format("%-8s%-24s%10s\r\n", language[i].getRank(), language[i].getProgramming(), language[i].getRate());
            fmt.flush();
        }
        fmt.close();
    }

    private String readTable(String input) {
        input = input.replaceAll("&lt;", "<");
        input = input.replaceAll("&gt;", ">");

        Pattern target = Pattern.compile("<table class=\"table table-striped table-top20\">.*?</table>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = target.matcher(input);
        String tmp = null;
        while (matcher.find()) {
            tmp = matcher.group();
            tmp = tmp.replaceAll("<{1}[^>]{1,}>{1}", "@").trim();
            tmp = tmp.replaceAll("\" alt=\"change\">", "@");
            tmp = tmp.replaceAll("/images/{1}.*?png", "@");
            tmp = tmp.replaceAll("@{1,}", "\n");
        }
        return tmp;
    }

    private void loadStr(String result) {
        String[] divStr = result.split("\n");
        int counter = 0;
        while (!divStr[counter].equals("1")) {
            counter++;
        }

        int number = 0;

        String rank = null;
        String programming = null;
        String rating = null;

        for (int i = counter; i < divStr.length; i++) {
            switch (i % 5) {
                case 2:
                    rank = divStr[i];
                    break;
                case 4:
                    programming = divStr[i];
                    break;
                case 0:
                    rating = divStr[i];
                    language[number] = new Language(rank, programming, rating);
                    number += 1;
                    break;
                default:
                    break;
            }
        }
    }
}
