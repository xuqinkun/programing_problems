#include<stdio.h>
#include<stdlib.h>
int mark(int** grid, int gridSize, int* gridColSize) {
	int i, j, tmp = 0;
	for (i = 0; i < gridSize; i++) {
		for (j = 0; j < gridColSize[i]; j++) {
			if (2 == grid[i][j]) {
				if (i > 0 && 1 == grid[i - 1][j]) { // up
					grid[i - 1][j] = 3;
					tmp++;
				}
				if (j > 0 && 1 == grid[i][j - 1]) { // left
					grid[i][j - 1] = 3;
					tmp++;
				}
				if (i + 1 < gridSize && 1 == grid[i + 1][j]) { // bottom
					grid[i + 1][j] = 3;
					tmp++;
				}
				if (j + 1 < gridColSize[i] && 1 == grid[i][j + 1]) { // right
					grid[i][j + 1] = 3;
					tmp++;
				}
			}
		}
	}
	return tmp;
}

void rotting(int** grid, int gridSize, int* gridColSize) {
	int i, j;
	for (i = 0; i < gridSize; i++) {
		for (j = 0; j < gridColSize[i]; j++) {
			if (3 == grid[i][j]) {
				grid[i][j] = 2;
			}
		}
	}
}

int orangesRotting(int** grid, int gridSize, int* gridColSize) {
	int i, j, goodOranges = 0, minutes = 0, count = 0, tmp;
	for (i = 0; i < gridSize; i++) {
		for (j = 0; j < gridColSize[i]; j++) {
			if (1 == grid[i][j]) goodOranges++;
		}
	}
   	while (count < goodOranges) {
		tmp = mark(grid, gridSize, gridColSize);
		if (0 == tmp) return -1;
		rotting(grid, gridSize, gridColSize);
 		count += tmp;
		minutes++;
	}
	return minutes;
}
int main()
{
    return 0;
}

