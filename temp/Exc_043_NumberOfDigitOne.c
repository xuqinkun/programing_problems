#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int numberOfDigitOne(char str[])
{
	if (*str < '0' || *str > '9')
		return 0;
	int firstNum, len;
	firstNum = *str - '0';
	len = strlen(str);

	if (len == 1 && firstNum > 0)
		return 1;
	if (len == 1 && firstNum == 0)
		return 0;

	int count = 0, numOfFirstDigit = 0;
	if (firstNum > 1)
		numOfFirstDigit = pow(10, len - 1);
	else if (firstNum == 1)
		numOfFirstDigit = atoi(str + 1) + 1;
	int p = pow(10, len - 2);
	count = firstNum * (len - 1) * p;
	return count + numOfFirstDigit + numberOfDigitOne(str + 1);
}

int countDigitOne(int n)
{
	if (n <= 0)
		return 0;
	char str[50];
	sprintf(str, "%d", n);
	return numberOfDigitOne(str);
}


int main()
{
	printf("%d->%d\n", 10000000, countDigitOne(10000000));
	printf("%d->%d\n", 1, countDigitOne(1));
	printf("%d->%d\n", 10000, countDigitOne(10000));
	printf("%d->%d\n", 0, countDigitOne(0));

	system("pause");
	return 0;
}
