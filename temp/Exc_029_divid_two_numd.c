#include<stdio.h>
#include<stdlib.h>
int divi(long long a, long long b) {
	if (a < b) return 0;
	int divid = 1;
	long long tb = b;
	while ((tb + tb) <= a) {
		tb = tb + tb;
		divid = divid + divid;
	}
	return divid + divi(a - tb, b);
}

int divide(int dividend, int divisor) {
	if (dividend == 0) return 0;
	if (divisor == 1) return dividend;
	if (-1 == divisor) {
		if (dividend > INT_MIN) return -dividend;
		else 
			return INT_MAX;
	}
	long long a = dividend, b = divisor;
	bool isNegative = false;
	if (a < 0) {
		a = -a;
		isNegative = !isNegative;
	}
	if (b < 0) {
		b = -b;
		isNegative = !isNegative;
	}
	int divid = divi(a, b);
	return isNegative ? -divid : divid;
}

int main()
{
	printf("%d\n", divide(1<<31, -2));
	
	system("pause");

	return 0;
}
