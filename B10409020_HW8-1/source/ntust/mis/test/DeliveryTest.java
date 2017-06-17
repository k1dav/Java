package ntust.mis.oo;

import ntust.mis.oo.*;

public class DeliveryTest {
    public static void main(String[] args) {
        Person[] senders ={
            new Person("Apple","0912345678",City.HSINCHU),
            new Person("Banana","0987456321",City.HUALIEN),
            new Person("Cat","0952368741",City.KAOHSIUNG),
            new Person("Dog","0964785132",City.TAICHUNG)};

        Person[] receivers ={
            new Person("Elephant","0954786213",City.TAIPEI),
            new Person("Frog","0925687431",City.HSINCHU),
            new Person("Goat","0963521478",City.HSINCHU),
            new Person("Hippo","0952361478",City.HUALIEN)};

        Goods[] goods={
            new Goods("Insect", 30, Type.BUSSINESS),
            new Goods("Juice", 30, Type.HOUSEWARES),
            new Goods("Kate", 30, Type.BUSSINESS),
            new Goods("Lemon",30,Type.HOUSEWARES)};

        
        for(int i=0;i<senders.length;i++){
            Delivery delivery = new Delivery(senders[i], receivers[i], goods[i]);
            
            int sentNo=delivery.send();
            System.out.println("No:"+sentNo);
            System.out.println(delivery.toString()+"\n");
        }
    }
}