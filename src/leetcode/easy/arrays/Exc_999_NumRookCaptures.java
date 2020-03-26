package leetcode.easy.arrays;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_999_NumRookCaptures
 * Author:   Xu Qinkun
 * Date:     2020/3/26 7:13
 * Description:
 */

public class Exc_999_NumRookCaptures {

    public int numRookCaptures(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return 0;
        int row = board.length, col = board[0].length;
        int posI = -1, posJ = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'R') {
                    posI = i;
                    posJ = j;
                    break;
                }
            }
        }
        return count(board, row, col, posI, posJ);
    }

    private int count(char[][] board, int row, int col, int posI, int posJ) {
        if (posI < 0 || posJ < 0) return 0;
        int count = 0;
        for (int i = posI - 1; i >= 0; i--) {
            if (board[i][posJ] == 'B') break;
            if (board[i][posJ] == 'p') {
                count++;
                break;
            }
        }
        for (int i = posI + 1; i < row; i++) {
            if (board[i][posJ] == 'B') break;
            if (board[i][posJ] == 'p') {
                count++;
                break;
            }
        }
        for (int j = posJ - 1; j >= 0; j--) {
            if (board[posI][j] == 'B') break;
            if (board[posI][j] == 'p') {
                count++;
                break;
            }
        }
        for (int j = posJ + 1; j < col; j++) {
            if (board[posI][j] == 'B') break;
            if (board[posI][j] == 'p') {
                count++;
                break;
            }
        }
        return count;
    }

}
