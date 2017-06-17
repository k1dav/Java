/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public class Staff extends Person implements Work{

    private String department;
    private double salary;

    Staff(String name, String department, double salary) {
        super(name);
        this.department = department;
        this.salary = salary;
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
        return "Staff name = "+this.getName()+",\nwho works in "+this.getDepartment()+",\nwhose salary is "+this.getSalary()+".\n";
    }
}
