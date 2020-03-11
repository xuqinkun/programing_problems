package leetcode.medium.arrays;

public class Exc_079_WordSearch {

    int row, col;
    int len;
    boolean[][] flags;
    char [][]board;
    String word;

    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return false;
        row = board.length;
        if (row == 0) return false;
        col = board[0].length;
        flags = new boolean[row][col];
        len = word.length();
        this.board = board;
        this.word = word;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (exist(i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(int i, int j, int startS) {
        if (startS == len - 1) {
            return board[i][j] == word.charAt(startS);
        }
        char c = word.charAt(startS);
        boolean exists = false;
        if (i >= 0 && i < row && j >= 0 && j < col) {
            if (!flags[i][j] && board[i][j] == c) {
                flags[i][j] = true;
                if (i > 0 && !flags[i - 1][j])
                    exists = exist(i - 1, j, startS + 1); // up
                if (j > 0 && !flags[i][j - 1])
                    exists |= exist(i, j - 1, startS + 1); // left
                if (i < row - 1 && !flags[i + 1][j])
                    exists |= exist(i + 1, j, startS + 1); // bottom
                if (j < col - 1 && !flags[i][j + 1])
                    exists |= exist(i, j + 1 , startS + 1); // right
                if (exists) {
                    return true;
                }
                flags[i][j] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Exc_079_WordSearch ws = new Exc_079_WordSearch();
//        char[][] board = {{'a','b','b','a','b'},{'a','a','b','b','a'},{'a','a','a','a','b'},
//                {'a','a','a','b','a'},{'a','a','a','a','a'},{'a','b','a','b','b'},{'a','b','b','a','b'}};
//        String word = "abbbbaababaa";
        char[][] board = {{'a'}};
        String word = "a";
        System.out.println(ws.exist(board, word));
//        word = "SEE";
//        System.out.println(ws.exist(board, word));
//        word = "ABCD";
//        System.out.println(ws.exist(board, word));
//        word = "FBAS";
//        System.out.println(ws.exist(board, word));
    }
}
