/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1dav
 */
import java.util.Scanner;

public class Checker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sudoku sudoku = new Sudoku();
        System.out.println("Enter the sudoku:");

        for (int i = 0; i < 9; i++) {
            String input = sc.nextLine();
            sudoku.setSudoku(i, input);
        }
        sudoku.getSudoku();
        if(sudoku.checkSudokuBlock()&&sudoku.checkSudokuCol()&&sudoku.checkSudokuRow()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

}
