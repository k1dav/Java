/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dav
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDChecker {

    private static ID[] IDs;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("***********************\n"
                    + "1.    驗證身份證字號\n"
                    + "0.    離開\n"
                    + "***********************\n"
                    + "請選擇:");

            String again = sc.nextLine();
            if (again.equals("0")) {
                break;
            } else if (again.equals("1")) {
                System.out.print("請輸入檔案名稱：");
                String fileName = sc.nextLine();
                System.out.println();

                ReadFile(fileName);
            } else {
                System.out.println("是位連選項都不會打der朋友呢！");
            }

        }
    }

    public static void ReadFile(String FileName) {
        try {
            File file = new File(FileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            StringBuilder data = new StringBuilder();
            while ((line = br.readLine()) != null) {
                data.append(line + "@");
            }
            br.close();
            fr.close();

            setData(data.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setData(String str) {
        String line[] = str.split("@");
        IDs = new ID[line.length];

        for (int i = 0; i < line.length; i++) {
            String id = line[i];
            IDs[i] = new ID(id);
        }
        printID();
    }

    public static void printID() {
        StringBuilder correct = new StringBuilder();
        StringBuilder wrong = new StringBuilder();

        for (int i = 0; i < IDs.length; i++) {
            if (IDs[i].getErrorCode() == 0) {
                correct.append(IDs[i].getID() + "\t" + IDs[i].getRegion() + "\t" + IDs[i].getGender()+"@");
            } else {
                if (IDs[i].getErrorCode() == 1) {
                    wrong.append(IDs[i].getID() + "\t格式不符@");
                } else {
                    wrong.append(IDs[i].getID() + "\t身份證字號錯誤@");
                }
            }
        }
        writeFile("correct.txt",correct);
        writeFile("wrong.txt",wrong);
    }
    
    public static void writeFile(String FileName, StringBuilder input){
        try{
            String line[] = input.toString().split("@");
            
            FileWriter fw = new FileWriter(FileName);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i=0;i<line.length;i++){
                bw.write(line[i]);
                bw.newLine();
            }
            
            bw.close();
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
