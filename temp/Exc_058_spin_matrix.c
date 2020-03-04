#include<stdio.h>
#include<stdlib.h>

int** generateMatrix(int n, int* returnSize, int** returnColumnSizes) {
	int step, i, j, counter = 1, total = n * n;
	*returnSize = n;

	*returnColumnSizes = (int*)malloc(sizeof(int) * n);
	int **ans = (int**)malloc(sizeof(int*) * n);

	for (i = 0; i < n; i++) {
		(*returnColumnSizes)[i] = n;
		ans[i] = (int*)malloc(sizeof(int) * n);
	}
	for (step = 0; step <= (n - 1) / 2; step++) {
		i = step;
		for (j = step; j < n - step; j++) {
			if (counter > total) break;
			ans[i][j] = counter++;
		}
		j--;
		for (i = step + 1; i < n - step; i++) {
			if (counter > total) break;
			ans[i][j] = counter++;
		}
		i--;
		for (j = n - step - 2; j >= step; j--) {
			if (counter > total) break;
			ans[i][j] = counter++;
		}
		j++;
		for (i = n - step - 2; i > step; i--) {
			if (counter > total) break;
			ans[i][j] = counter++;
		}
	}
	return ans;
}

int main()
{
	int n = 6, row, *cols, **ans;
	int i, j;

	ans = generateMatrix(n, &row, &cols);
		
	for (i = 0; i < row; i++) {
		for (j = 0; j < cols[i]; j++) {
			printf("%3d", ans[i][j]);
		}
		printf("\n");
	}

	free(cols);
	free(ans);
	return 0;
}

