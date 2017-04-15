
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author k1dav
 */
public class GameLauncher {

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        String again = "Y";

        while (again.equals("Y")) {
            ttt.gameReset();
            int i ;
            for (i=1; i <= 9; i++) {
                if (ttt.getPlayer()) {
                    System.out.print("Player-O, enter your move (row[1-3],column[1-3]):");
                } else {
                    System.out.print("Player-X, enter your move (row[1-3],column[1-3]):");
                }
                String ans = sc.next();

                while (!ans.matches("[1-3],[1-3]") || ttt.checkPosition(ans.charAt(0), ans.charAt(2))) {
                    System.out.println("The value you entered is invalid! Please try again.");
                    if (ttt.getPlayer()) {
                        System.out.print("Player-O, enter your move (row[1-3],column[1-3]):");
                    } else {
                        System.out.print("Player-X, enter your move (row[1-3],column[1-3]):");
                    }
                    ans = sc.next();
                }
                ttt.gameSet(ans.charAt(0), ans.charAt(2));
                ttt.gamePrint();
                if(ttt.checkGame()){
                    if(!ttt.getPlayer()){
                        System.out.println("Player-O is the winner!");
                    }else{
                        System.out.println("Player-X is the winner!");
                    }
                    break;
                }
            }
            if(i==10){
                System.out.println("It's a Draw!");
            }
            System.out.println("********** Game Over **********\nPlay again(Y/N)? ");
            again=sc.next();
        }

    }
}
