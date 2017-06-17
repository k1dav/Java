/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public class UndergraduateStudent extends Student {

    private String grade;
    private String classes;

    public UndergraduateStudent(String name, String id, String department, String grade, String classes) {
        super(name, id, department);
        this.grade = grade;
        this.classes = classes;
    }

    public String getGrade() {
        return this.grade;
    }

    public String getClasses() {
        return this.classes;
    }

}
