package b10409020_hw1;
/**
 *
 * @author k1dav
 */
import java.util.Scanner;
public class StudenTest {
    public static void main(String[] args) {
        int number = 2;
        Student[] stu=new Student[number];
        stu[0] = new Student(args[0],args[1],args[2]);
        
        Scanner sc = new Scanner(System.in);
        stu[1] = new Student();
        System.out.print("Name:");
        stu[1].SetName(sc.nextLine());
        System.out.print("ID:");
        stu[1].SetID(sc.nextLine());
        System.out.print("Class:");
        stu[1].SetClass(sc.nextLine());
        
        for (int i=0;i<stu.length;i++){
            System.out.println("-------- Student "+i+" --------");
            System.out.println("Name:"+stu[i].GetName());
            System.out.println("ID:"+stu[i].GetID());
            System.out.println("Class:"+stu[i].GetClass());
        }
    }
}
