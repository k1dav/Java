/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dav
 */
public class TicTacToe {

    private int[] check;
    private boolean player = false; //false X -> -1 , true O ->1

    TicTacToe() {
        System.out.println("********** Game Start **********");
        this.gameReset();
    }

    public void gameReset() {
        check = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public void gameSet(char row, char col) {
        int position = (Character.getNumericValue(row) - 1) * 3 + (Character.getNumericValue(col) - 1);
        if (player) {
            check[position] = 1;
            player = false;
        } else {
            check[position] = -1;
            player = true;
        }
    }

    public void gamePrint() {
        int position = 0;

        for (int i = 1; i <= 5; i++) {
            if (i % 2 == 0) {
                System.out.println("----------");
                continue;
            }
            for (int j = 1; j <= 11; j++) {
                if (j % 4 == 0) {
                    System.out.print("|");
                    continue;
                } else if (j % 2 == 0) {
                    if (check[position] == 1) {
                        System.out.print("O");
                    } else if (check[position] == -1) {
                        System.out.print("X");
                    }
                    position++;
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public boolean getPlayer() {
        return this.player;
    }

    public boolean checkPosition(char row, char col) {
        int position = (Character.getNumericValue(row) - 1) * 3 + (Character.getNumericValue(col) - 1);
        if (check[position] != 0) {
            return true;
        }
        return false;
    }

    public boolean checkGame() {
        if (check[0] == check[1] && check[1] == check[2] && check[0] != 0) {
            return true;
        }

        if (check[3] == check[4] && check[4] == check[5] && check[3] != 0) {
            return true;
        }

        if (check[6] == check[7] && check[7] == check[8] && check[6] != 0) {
            return true;
        }

        if (check[0] == check[3] && check[3] == check[6] && check[0] != 0) {
            return true;
        }

        if (check[1] == check[4] && check[4] == check[7] && check[1] != 0) {
            return true;
        }

        if (check[2] == check[5] && check[5] == check[8] && check[2] != 0) {
            return true;
        }

        if (check[0] == check[4] && check[4] == check[8] && check[8] != 0) {
            return true;
        }

        if (check[2] == check[4] && check[4] == check[6] && check[2] != 0) {
            return true;
        }

        return false;
    }
}
