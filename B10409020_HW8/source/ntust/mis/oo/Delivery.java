package ntust.mis.oo;

public class Delivery{
    private Person sender;
    private Person receiver;
    private Goods goods;
    private static final double MAX_WEIGHT = 100;
    private static double currentWeight = 0;
    private int no = -1;

    public Delivery(Person Sender,Person Receiver,Goods Goods){
        this.sender=Sender;
        this.receiver=Receiver;
        this.goods=Goods;
    }

    private static double getAvailableWeight(){
        return MAX_WEIGHT-currentWeight;
    }

    public int send(){
        System.out.println("Before Weight:"+getAvailableWeight());
        if(this.goods.getWeight()>getAvailableWeight()||this.goods.getWeight()==(double)-1){
            System.out.println("After Weight:"+getAvailableWeight());
            return -1;
        }else{
            currentWeight+=this.goods.getWeight();
            no =  (int)(Math.random()*10000+1);
            System.out.println("After Weight:"+getAvailableWeight());
            return no;
        }
    }

    public String toString(){
        return "Sender:\t"+this.sender.toString()+"\nReceiver:"+
        this.receiver.toString()+"\nGoods:\t"+this.goods.toString();
    }
}