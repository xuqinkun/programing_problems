#include<stdio.h>
#include<stdlib.h>

int** findContinuousSequence(int target, int* returnSize, int** returnColumnSizes) {
	int i, temp, len,
		left = 1, right = 2, mid = target / 2;
	int **ans = (int**)malloc(sizeof(int*) * mid);
	*returnColumnSizes = (int*)malloc(sizeof(int) * mid);
	*returnSize = 0;

	while (left <= mid) {
		temp = 0;
		for (i = left; i <= right; i++) {
			temp += i;
		}
		if (target == temp) {
			len = right - left + 1;
			ans[*returnSize] = (int*)malloc(sizeof(int) * (len));
			(*returnColumnSizes)[*returnSize] = len;
			for (i = left; i <= right; i++) {
				ans[*returnSize][i - left] = i;
			}
			(*returnSize)++;
			right++;
		}
		else if (target > temp) right++;
		else left++; 
	}
	return ans;
}

int main()
{
    return 0;
}

