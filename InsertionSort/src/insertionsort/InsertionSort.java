package insertionsort;
import java.util.Scanner;

class Insertion{
    static int counter=0;
    public static <T extends Comparable>void sort(T x[],T value){
        
        int i=0;
        
        while(x[i]!=null){
            if(value.compareTo(x[i])<0){
                for(int c = counter;c>i;c--){
                    x[c]=x[c-1];
                }
                x[i]=value;
                return;
            }
            i++;
        }
        x[i]=value;
    }  
    public static <T extends Comparable>void printarray(T x[]){
        System.out.println("After Sorting...");
        for(T a:x){
            if(a!=null){
                System.out.print(a+" ");
            }
        }
        System.out.println();
    }
}

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] num=new Integer[1000];
        Scanner sc =new Scanner(System.in);
        
        System.out.println("Please input the number:(-1 to quit)");
        Integer x=sc.nextInt();
        while(x!=-1){
            Insertion.sort(num, x);
            Insertion.counter++;
            Insertion.printarray(num);
            System.out.println("Please input the number:(-1 to quit)");
            x=sc.nextInt();
        }
        
        String[] str=new String[1000];
        System.out.println("Please input the string:(q to quit)");
        String s=sc.next();

        while(s.equals('q')){
            Insertion.sort(str, s);
            Insertion.counter++;
            Insertion.printarray(str);
            System.out.println("Please input the string:(q to quit)");
            s=sc.next();
        }
    }
}
