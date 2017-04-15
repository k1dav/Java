
/**
 *
 * @author k1dav
 */
public class Guess {

    private int ans;

    Guess(int min, int max) {
        System.out.println("*********** ¹CÀ¸¶}©l ***********");
        this.ans = (int) (Math.random() * (max - min + 1) + min);
    }

    public int numCheck(int num) {
        if (num > this.ans) {
            return 1;
        } else if (num == this.ans) {
            return 0;
        }
        return -1;
    }

    public int getAns() {
        return this.ans;
    }
}
