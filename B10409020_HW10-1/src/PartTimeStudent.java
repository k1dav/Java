/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public class PartTimeStudent extends UndergraduateStudent {

    private String company;
    private String position;

    public PartTimeStudent(String name, String id, String department, String grade, String classes,
             String company, String position) {
        super(name, id, department, grade, classes);
        this.company = company;
        this.position = position;
    }
    
    @Override
    public String toString() {
        return String.format(
                "*****FullTimeStudent*****\nName: %s\nStudent ID: %s\nMajor: %s\n"
                + "Grade: %s\nClass: %s\nCompany: %s\nPosition: %s\n", 
                getName(), getId(), getDepartment(), getGrade(), getClasses(), company, position);
    }

}
