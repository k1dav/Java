package b10409020_hw1;
/**
 *
 * @author k1dav
 */
public class Student {
    private String stu_name;
    private String stu_ID;
    private String stu_class;
    
    public Student (String s_name,String s_number,String s_class){
        this.stu_name=s_name;
        this.stu_ID=s_number;
        this.stu_class=s_class;
    }
    public Student (){
    }
    
    public void SetName(String s_name){
        this.stu_name=s_name;
    }
    public void SetID(String s_ID){
        this.stu_ID=s_ID;
    }
    public void SetClass(String s_class){
        this.stu_class=s_class;
    }

    public String GetName(){
        return this.stu_name;
    }
    public String GetID(){
        return this.stu_ID;
    }
    public String GetClass(){
        return this.stu_class;
    }
    
}
