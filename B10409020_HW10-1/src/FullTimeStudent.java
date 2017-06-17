/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public class FullTimeStudent extends UndergraduateStudent {

    private String social;
    private String socialLeader;

    public FullTimeStudent(String name, String id, String department, String grade, String classes,
             String social, String socialLeader) {
        super(name, id, department, grade, classes);
        this.social = social;
        this.socialLeader = socialLeader;
    }
    
    @Override
    public String toString() {
        return String.format(
                "*****FullTimeStudent*****\nName: %s\nStudent ID: %s\nMajor: %s\n"
                + "Grade: %s\nClass: %s\nClub: %s\nRole: %s\n", 
                getName(), getId(), getDepartment(), getGrade(), getClasses(), social, socialLeader);
    }

}
