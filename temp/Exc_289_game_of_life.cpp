#include<stdio.h>
#include<stdlib.h>

int max(int a, int b) {
	return a > b ? a : b;
}

int min(int a, int b) {
	return a < b ? a : b;
}

/**
* 0: stay dead
* 1: stay alive
* 2: alive to dead
* 3: dead to alive
*/
int countNeighbors(int board[][3], int row, int col, int i, int j) {
	int startRow = max(0, i - 1), endRow = min(row - 1, i + 1), 
		startCol = max(0, j - 1), endCol = min(col - 1, j + 1);
	int p, q, count = 0;
	for (p = startRow; p <= endRow; p++) {
		for (q = startCol; q <= endCol; q++) {
			if (p == i && q == j) continue;
			if ((board[p][q] == 1 || board[p][q] == 2)) {
				count++;
			}
		}
	}
	return count;
}

void gameOfLife(int board[][3], int row, int* col) {
	int i, j, count;
	for (i = 0; i < row; i++) {
		for (j = 0; j < *col; j++) {
			count = countNeighbors(board, row, *col, i, j);
			if (board[i][j] == 0 && count == 3) {
				board[i][j] = 3;
			}
			else if (board[i][j] == 1 && (count < 2 || count > 3)) {
				board[i][j] = 2;
			}
		}
	}
	for (i = 0; i < row; i++) {
		for (j = 0; j < *col; j++) {
			if (board[i][j] == 2) {
				board[i][j] = 0;
			}
			else if (board[i][j] == 3) {
				board[i][j] = 1;
			}
		}
	}
}


int main()
{
	int a[][3] = {
		{ 0,1,0 },
		{ 0,0,1 },
		{ 1,1,1 },
		{ 0,0,0 }
	};
	int row = sizeof(a) / sizeof(a[0]), col = sizeof(a[0]) / sizeof(int);
	gameOfLife(a, row, &col);
	int i, j;
	for (i = 0; i < row; i++) {
		for (j = 0; j < col; j++) {
			printf("%d ", a[i][j]);
		}
		printf("\n");
	}
	return 0;
}

