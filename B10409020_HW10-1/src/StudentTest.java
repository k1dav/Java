/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public class StudentTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MasterStudent stu1 = new MasterStudent("David Tsai","M10009001","Information Management","Integrated Digital Services Lab","Professor Lo","EMBA",false);
        System.out.println(stu1);
        PhDStudent stu2 = new PhDStudent("Peter Yang","D10015001","Computer Science","Software Engineering Lab","Professor Lee",true,false);
        System.out.println(stu2);
        FullTimeStudent stu3 = new FullTimeStudent("Jack Chen","B10005001","Contruction Engineering","Sophomore","Class A","Baseball Club","Leader");
        System.out.println(stu3);
        PartTimeStudent stu4 = new PartTimeStudent("Michelle Lin","B10008001","Business Administration","Freshman","Class B","7-ELEVEN","Clerk");
        System.out.println(stu4);
    }
    
}
