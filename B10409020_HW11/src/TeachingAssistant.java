/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public class TeachingAssistant extends Student implements Work{

    private String department;
    private double salary;
    private String course;

    TeachingAssistant(String name, String major, String degree, String department, double salary, String course) {
        super(name, major, degree);
        this.department = department;
        this.salary = salary;
        this.course = course;
    }

    @Override
    public String getDepartment() {
        return this.department;
    }

    @Override
    public void setDepartment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public void setSalary() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "TA name = "+this.getName()+",\nwho studies in "+this.getMajor()+",\nwhose degree is "+this.getDegree()+",\nwho works in "+this.getDepartment()+",\nwhose salary is "+this.getSalary()+".\n";
    }
}
