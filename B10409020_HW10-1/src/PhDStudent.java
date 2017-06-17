/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public class PhDStudent extends GraduateStudent {

    private boolean test;
    private boolean paper;

    public String getTest(){
        if(test){
            return "Passed";
        }
        return "Unpassed";
    }
    
    public String getPaper(){
        if(paper){
            return "finished";
        }
        return "unfinished";
    }
    public PhDStudent(String name, String id, String department, String lab, String teacher,
             boolean test, boolean paper) {
        super(name, id, department, lab, teacher);
        this.test = test;
        this.paper = paper;
    }

    
    @Override
    public String toString() {
        return String.format(
                "*****PhdStudent*****\nName: %s\nStudent ID: %s\nMajor: %s\n"
                + "Lab: %s\nAdvisor: %s\nQualify: %s\nDissertation: %s\n", 
                getName(), getId(), getDepartment(), getLab(), getTeacher(), getTest(), getPaper());
    }
}
