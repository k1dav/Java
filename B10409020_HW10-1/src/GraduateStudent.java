/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public class GraduateStudent extends Student {

    private String lab;
    private String teacher;

    public GraduateStudent(String name, String id, String department, String lab, String teacher) {
        super(name, id, department);
        this.lab = lab;
        this.teacher = teacher;
    }

    public String getLab() {
        return this.lab;
    }

    public String getTeacher() {
        return this.teacher;
    }

}
