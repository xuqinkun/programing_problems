#include<stdio.h>
#include<stdlib.h>
void swap(int **mat, int row1, int col1, int row2, int col2) {
	int t = mat[row1][col1];
	mat[row1][col1] = mat[row2][col2];
	mat[row2][col2] = t;
}

int** diagonalSort(int** mat, int row, int* col, int* returnSize, int** returnColumnSizes) {
	int  i, j, k, p, q, **ans;
	
	*returnSize = row;
	*returnColumnSizes = (int*)malloc(sizeof(int) * row);
	ans = (int**)malloc(sizeof(int*) * row);
	for (i = 0; i < row; i++) {
		ans[i] = (int*)malloc(sizeof(int) * (*col));
	}
	
	for (i = 0; i < row; i++) {
		(*returnColumnSizes)[i] = *col;
	}
	for (i = row - 1; i >= 0; i--) {
		ans[i][0] = mat[i][0];
		for (j = i + 1, k = 1; j < row && k < *col; j++, k++) {
			ans[j][k] = mat[j][k];
			p = j; q = k;
			while (p > 0 && q > 0) {
				if (ans[p][q] < ans[p - 1][q - 1]) {
					swap(ans, p, q, p - 1, q - 1);
				}
				p--; q--;
			}
		}
	}
	for (i = 1; i < *col; i++) {
		ans[0][i] = mat[0][i];
		for (j = 1, k = i + 1; j < row &&k < *col; j++, k++) {
			ans[j][k] = mat[j][k];
			p = j; q = k;
			while (p > 0 && q > 0) {
				if (ans[p][q] < ans[p - 1][q - 1]) {
					swap(ans, p, q, p - 1, q - 1);
				}
				p--; q--;
			}
		}
	}
	return ans;
}

int main()
{
	int a[3][4] = { 3,3,1,1,2,2,1,2,1,1,1,2};
	int *mat[3] = { a[0], a[1], a[2] };
	
	int i, j, row, col, returnRow, *returnCol, **ans;
	row = sizeof(a) / sizeof(a[0]), col = sizeof(a[0]) / sizeof(int);
	ans = diagonalSort(mat, row, &col, &returnRow, &returnCol);


	for (i = 0; i < row; i++) {
		for (j = 0; j < col; j++) {
			printf("%2d", ans[i][j]);
		}
		printf("\n");
	}

	return 0;
}

