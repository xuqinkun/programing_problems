#include<stdio.h>
#include<stdlib.h>
#include <math.h>

int sum(int **mat, int startRow, int startCol, int endRow, int endCol) {
	int i, j, sum = 0;
	for (i = startRow; i <= endRow; i++) {
		for (j = startCol; j <= endCol; j++) {
			sum += mat[i][j];
		}
	}
	return sum;
}

int** matrixBlockSum(int** mat, int row, int* col, int K, int* returnSize, int** returnColumnSizes) {
	int  i, j, **ans;
	int startRow, startCol, endRow, endCol;

	*returnSize = row;
	*returnColumnSizes = (int*)malloc(sizeof(int) * row);
	ans = (int**)malloc(sizeof(int*) * row);
	for (i = 0; i < row; i++) {
		ans[i] = (int*)malloc(sizeof(int) * (*col));
	}
	for (i = 0; i < row; i++) {
		(*returnColumnSizes)[i] = *col;
	}

	for (i = 0; i < row; i++) {
		for (j = 0; j < *col; j++) {
			startRow = fmax(0, i - K);
			startCol = fmax(0, j - K);
			endRow = fmin(row - 1, i + K);
			endCol = fmin(*col - 1, j + K);
			ans[i][j] = sum(mat, startRow, startCol, endRow, endCol);
		}
	}
	return ans;
}
int main()
{
    return 0;
}

