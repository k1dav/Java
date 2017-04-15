
/**
 *
 * @author k1dav
 */
import java.util.Scanner;

public class ABGuessLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String guess = "";
        Scanner sc = new Scanner(System.in);
        String again = "Y";

        while (again.equals("Y")) {
            ABGuess game = new ABGuess();

            System.out.print("���T���סG" + game.getAns() + "\n");

            System.out.println("*********** �C���}�l ***********");

            do {
                System.out.print("�п�J�z�q���Ʀr�G");
                guess = sc.next();

                while (checkNumber(guess)) {
                    System.out.println("�п�J 4 �Ӥ����ƼƦr�� 4 �ӼƦr�I");
                    System.out.print("�п�J�z�q���Ʀr�G");
                    guess = sc.next();
                }
            } while (!game.checkAns(guess));

            System.out.println("******** �A���@��(Y/N)? ********");
            again = sc.next().toUpperCase();
        }
    }

    public static boolean checkNumber(String input) {
        if (input.length() != 4) {                     //four digits
            return true;
        }
        for (int i = 0; i < input.length(); i++) {     //check isNumber
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                return true;
            }
        }
        for (int i = 0; i < input.length(); i++) {  //check repeat
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
