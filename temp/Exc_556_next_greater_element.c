#include<stdio.h>
#include<stdlib.h>

int arrayToInt(int a[], int n) {
	int i, ans = 0, base = 1;
	long long temp;
	for (i = 0; i < n; i++) {
		temp = ans + (long long)a[i] * base;
		if (temp > INT_MAX) return -1;
		ans = temp;
		base *= 10;
	}
	return ans;
}

void swap(int nums[], int i, int j) {
	int t = nums[i];
	nums[i] = nums[j];
	nums[j] = t;
}

void reverse(int nums[], int left, int right) {
	int t, i, mid = (left + right) / 2;
	for (i = 0; i <= mid; i++) {
		t = nums[right - i];
		nums[right - i] = nums[i];
		nums[i] = t;
	}
}

int nextGreaterElement(int n) {
	int nums[32], x = n, i, j, count = 0;
	while (x > 0) {
		nums[count++] = x % 10;
		x /= 10;
	}
	for (i = 1; i < count; i++) {
		if (nums[i] < nums[i - 1]) {
			for (j = 0; j < i; j++) {
				if (nums[j] > nums[i]) {
					swap(nums, j, i);
					reverse(nums, 0, i - 1);
					return arrayToInt(nums, count);
				}
			}
		}		
	}
	return -1;
}

int main()
{
	printf("%d\n", nextGreaterElement(12222333));
    return 0;
}

