#include<stdio.h>
#include<stdlib.h>

int* swapNumbers(int* nums, int numbersSize, int* returnSize){
	nums[0] = nums[0] ^ nums[1];
    nums[1] = nums[0] ^ nums[1];
    nums[0] = nums[0] ^ nums[1];
	*returnSize = numbersSize;
	return nums;
}

int main()
{
	int i, a[2] = {1 << 31,(1 << 31) + 3}, size;
	swapNumbers(a, 2, &size);
	for (i = 0; i < size; i++)
		printf("%d ", a[i]);
    return 0;
}

