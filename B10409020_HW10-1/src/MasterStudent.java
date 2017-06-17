/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public class MasterStudent extends GraduateStudent {

    private String schoolSystem;
    private boolean paper;

    public MasterStudent(String name, String id, String department, String lab, String teacher,
            String schoolSystem, boolean paper) {
        super(name, id, department, lab, teacher);
        this.schoolSystem = schoolSystem;
        this.paper = paper;
    }

    public String getPaper() {
        if (paper) {
            return "finished";
        }
        return "unfinished";
    }

    @Override
    public String toString() {
        return String.format(
                "*****MasterStudent*****\nName: %s\nStudent ID: %s\nMajor: %s\n"
                + "Lab: %s\nAdvisor: %s\nSystem: %s\nThesis: %s\n", 
                getName(), getId(), getDepartment(), getLab(), getTeacher(), schoolSystem, getPaper());
    }

}
