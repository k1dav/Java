
/**
 *
 * @author k1dav
 */
public class Account {

    private float balance = 0;
    private boolean status = false;
    
    public void OpenAc(float money) {   //open account
        if (money >= 1000) {
            this.status =true;
            this.balance += money;
            System.out.println("�}�ᦨ�\�A�w�s�J " + money + " ��");
        } else if (money < 1000) {
            System.out.println("�}�ᥢ�ѡA���B���~");
            return;
        } else {
            System.out.println("�s�ڥ��ѡI�п�J���B�I");
        }
    }

    public void Deposit(float money) {      //put money
        if (money >= 0) {
            this.balance += money;
            System.out.println("���\�s�J " + money + " ��");
        } else if (money < 0) {
            System.out.println("�s�ڥ��ѡI�п�J�D�t�ƭȡI");
        } else {
            System.out.println("�s�ڥ��ѡI�п�J���B�I");
        }
    }

    public void WithDraw(float money) {     //take money
        if (money > this.balance) {
            System.out.println("���ڥ��ѡI���ڪ��B�j��ثe�l�B�I");
        } else if (money < 0) {
            System.out.println("���ڥ��ѡI�п�J�D�t�ƭȡI");
        } else if (money <= this.balance) {
            this.balance -= money;
            System.out.println("���\��X " + money + " ��");
        } else {
            System.out.println("���ڥ��ѡI�п�J���B�I");
        }
    }

    public void GetBalancec() {      //get money balance
        System.out.println("�ثe�l�B�G " + this.balance + " ��");
    }

    public boolean GetStatus(){
        return this.status;
    }
}
