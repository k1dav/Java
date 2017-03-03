/**
 *
 * @author k1dav
 */
public class Caesar {
    private String Alpha = "qwertyuiopasdfghjklzxcvbnm";  //Alphabat
    private String Plaintext,Ciphertext;
    private int Key;
    
    //build
    public Caesar(String input,int key){    
        this.Plaintext=input;
        this.Key=key;
        this.Ciphertext=Offset(input,key);
    }
    
    //Caeser Cipher
    public String Offset(String input,int key){
        char[] output=new char[input.length()]; //new array for char
        input =input.toLowerCase();             // to lowercase
        for (int i=0;i<input.length();i++){     //Caesar Cipher function
            output[i]=Alpha.charAt((Alpha.indexOf(input.charAt(i))+key)%26);
        }
        /*
        A = input.charAt(i) = No.i 's char
        B = Alpha.indexOf(A)+key = Cipher
        Ans = Alpha.charAt(B%26);    if over the alphabat
        */
        return new String(output);
    }
    
    public String GetCiphertext(){
        return Ciphertext;
    }
}
