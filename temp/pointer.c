#include<stdio.h>
#include<stdlib.h>

int func(int *p) {
	int *q = p;
	p++;
	printf("%d\n", p);
	return *q;
}

int main()
{
	int a[] = {1,2,3};
	int *p = &a[0];
	func(p);
	printf("%d\n", p);
	return 0;
}
