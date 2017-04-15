/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dav
 */
public class Sudoku {

    private int[][] num;

    Sudoku() {
        num = new int[9][9];
    }

    public void setSudoku(int row, String input) {
        for (int i = 0; i < 9; i++) {
            String[] inputArray = input.split(" ");
            num[row][i] = Integer.parseInt(inputArray[i]);
        }
    }

    public void getSudoku() {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkSudokuRow() {
        for (int i = 0; i < 9; i++) {
            int[] check = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int j = 0; j < 9; j++) {
                if (check[num[i][j]] == 0) {
                    check[num[i][j]] = 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkSudokuCol() {
        for (int i = 0; i < 9; i++) {
            int[] check = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int j = 0; j < 9; j++) {
                if (check[num[j][i]] == 0) {
                    check[num[j][i]] = 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkSudokuBlock() {
        int row = 0;
        int col = 0;
        for (int k = 0; k < 9; k++) {
            if (k % 3 == 0) {
                row = k / 3;
            } else {
                col = k % 3;
            }
            for (int i = 0 + row * 3; i < 3 + row * 3; i++) {
                int[] check = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                for (int j = 0+col*3; j < 3+col*3; j++) {
                    if (check[num[i][j]] == 0) {
                        check[num[i][j]] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
