#include<stdio.h>
#include<stdlib.h>

int minSubArrayLen(int s, int* nums, int numsSize) {
	if (numsSize == 0) {
		return 0;
	}
	int sum = 0, min = numsSize + 1,i = 0, j = 0;
	while (i < numsSize && j <= i) {
		if (sum < s)  {
			sum += nums[i];
		} 
		if (sum >= s) {
			int tmp = i - j + 1;
			min = min > tmp ? tmp : min;
			sum -= nums[j];
			j++;		
		}
		if (i == numsSize - 1 && sum < s) {
			break;
		}
		if (i < numsSize - 1 && sum < s) {
			i++;
		}
	}
	if (min < numsSize + 1)
		return min;
	else 
		return 0;
}

int main()
{
	int a[] = {1,2,3,4,5};
	int size = sizeof(a)/sizeof(int);
	int l = minSubArrayLen(9, a, size);
	printf("%d\n", l);
    return 0;
}

