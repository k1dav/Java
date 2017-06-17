package ntust.mis.oo;

public class Goods{
    private String name;
    private double weight;
    private Type type;
    
    public Goods(String Name,double Weight,Type Type){
        this.name=Name;
        this.setWeight(Weight);
        this.type=Type;
    }

    private void setWeight(double Weight){
        if(Weight<=(double)30){
            this.weight=Weight;
        }else{
            this.weight=-1;
        }
    }

    public double getWeight(){
        return this.weight;
    }

    public String toString(){
        String output = String.format("%s-%.1f-%s", this.name, this.weight, this.type);
        return output;
    }
}