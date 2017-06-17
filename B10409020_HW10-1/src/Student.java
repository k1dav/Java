/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dave6412
 */
public class Student {

    private String name;
    private String id;
    private String department;

    Student(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getDepartment() {
        return this.department;
    }
}
