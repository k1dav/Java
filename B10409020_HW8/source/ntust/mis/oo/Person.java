package ntust.mis.oo;

public class Person {
    private String name;
    private String phoneNum;
    private City city;

    public Person(String Name, String Phone, City City) {
        this.name = Name;
        this.phoneNum = Phone;
        this.city = City;
    }

    public String toString(){
        String output = String.format("%s-%s-%s", this.name, this.phoneNum, this.city);
        return output;
    }
}