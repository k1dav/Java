package arrayfile;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;

class dataArray{
    String country;
    int[] number=new int[13];
    
    dataArray(String s){
        country=s;
    }
    
    dataArray(){
    }
    
    public void input(String s,int index){
        s=s.trim();
        number[index]=Integer.parseInt(s);
    }
    
    public void sum(){
        int sum=0;
        for(int i=0;i<number.length;i++){
            sum+=number[i];
        }
        number[12]=sum;
    }
}

public class ArrayFile {
    public static String eraser(String s){
        if(s.contains(",")){
            char[] c=s.toCharArray();
            for(int i=0;i<c.length;i++){
                if(c[i]==','){
                    for(int j=i;j<c.length;j++){
                        if(j!=c.length-1){
                            c[j]=c[j+1];
                        }
                        else{
                            c[j]=0;
                        }
                    }
                }
            }
            return new String(c);
        }
        else if(s.contains("\n")){
            char[] c=s.toCharArray();
            for(int i=0;i<c.length;i++){
                if(c[i]=='\n'){
                    for(int j=i;j<c.length;j++){
                        if(j!=c.length-1){
                            c[j]=c[j+1];
                        }
                        else{
                            c[j]=0;
                        }
                        
                    }
                }
            }
            return new String(c);
        }
        else if (s.contains("-")){
            return new String("0");
        }
        return s;
    }
    public static void sort(dataArray[] data,int index){
        dataArray temp=new dataArray();
        for(int i=0;i<data.length;i++){
           for(int j=i+1;j<data.length;j++){
               if(data[i].number[index]<data[j].number[index]){
                   temp = data[i];
                   data[i]=data[j];
                   data[j]=temp;
               }
           }
        }
    }
    
    public static void main(String[] args)throws IOException{
        String csv="travel.csv";
        DataInputStream in = new DataInputStream(new FileInputStream(new File(csv)));
        CSVReader reader = new CSVReader(new InputStreamReader(in,"big5"),',');
        dataArray[] arr=new dataArray[36];
        String[] head=new String[13];

        int counter=-1;
        try{
            String[] line;
            
            while ((line = reader.readNext()) != null) {
                int countertext=0;
                for(String s :line){
                    s=eraser(s);
                    if(counter==-1){
                        head[countertext]=s;
                    }
                    else{
                        if(countertext==0){
                            arr[counter]=new dataArray(s);
                        }
                        else{
                            if(!line[0].contains("Total")){
                                arr[counter].input(s,countertext-1);
                            }
                            
                        }
                    }
                    countertext++;
                }
                if(counter!=-1){
                    arr[counter].sum();
                }
                counter++;
            }
        }
        catch (IOException e){
            e.printStackTrace(); 
        }
        System.out.println("2002~2013年各年份的旅遊人數最多的前五名地區");
        for(int i=0;i<head.length-1;i++){
            sort(arr,i);
            System.out.println(head[i+1]);
            for(int j=0;j<5;j++){
            System.out.println("No."+(j+1)+"\t"+arr[j].country+"\t"+arr[j].number[i]);
            }
        }
        System.out.println("\n2002~2013年加總人數最多的前五名地區");
        sort(arr,12);
        for(int i=0;i<5;i++){
            System.out.println("No."+(i+1)+"\t"+arr[i].country+"\t"+arr[i].number[12]);
        }
        
    }
}
