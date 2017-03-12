
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
            System.out.println("開戶成功，已存入 " + money + " 元");
        } else if (money < 1000) {
            System.out.println("開戶失敗，金額錯誤");
            return;
        } else {
            System.out.println("存款失敗！請輸入金額！");
        }
    }

    public void Deposit(float money) {      //put money
        if (money >= 0) {
            this.balance += money;
            System.out.println("成功存入 " + money + " 元");
        } else if (money < 0) {
            System.out.println("存款失敗！請輸入非負數值！");
        } else {
            System.out.println("存款失敗！請輸入金額！");
        }
    }

    public void WithDraw(float money) {     //take money
        if (money > this.balance) {
            System.out.println("提款失敗！提款金額大於目前餘額！");
        } else if (money < 0) {
            System.out.println("提款失敗！請輸入非負數值！");
        } else if (money <= this.balance) {
            this.balance -= money;
            System.out.println("成功領出 " + money + " 元");
        } else {
            System.out.println("提款失敗！請輸入金額！");
        }
    }

    public void GetBalancec() {      //get money balance
        System.out.println("目前餘額： " + this.balance + " 元");
    }

    public boolean GetStatus(){
        return this.status;
    }
}
