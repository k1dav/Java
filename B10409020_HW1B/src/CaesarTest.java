/**
 *
 * @author k1dav
 */
import java.util.Scanner;
public class CaesarTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        
        System.out.print("Plaintext: ");
        input=sc.next();
        System.out.print("Key: ");
        Caesar caeser = new Caesar (input,sc.nextInt());  //new a caeser class
        System.out.println("Clphertext: "+caeser.GetCiphertext());
    }
    
}
