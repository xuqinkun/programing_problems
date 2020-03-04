#include<stdio.h>
#include<stdlib.h>
#include <string.h>

void swap(char *p, char *q) {
	char t;
	t = *p;
	*p = *q;
	*q = t;
}

void permu(char *s, char *start, char *ret[], int *row) {
	if (*start == 0) {
		strcpy(ret[*row], s);
		(*row)++;
		return;
	}
	char *p;
	for (p = start; *p != 0; p++) {
		swap(start, p);
		permu(s, start + 1, ret, row);
		swap(start, p);
	}
}

int factorial(int n) {
    if (n <= 0) return 0;
	int s = 1;
	while (n >= 1) {
		s *= n;
		n--;
	}
	return s;
}

char** permutation(char* S, int* returnSize) {
	char **ret;
	int i, len = strlen(S), row;
	
	*returnSize = factorial(len);
	if (0 == len) return NULL;
	ret = (char**)malloc((*returnSize) * sizeof(char*));
	
	for (i = 0; i < *returnSize; i++) {
 		ret[i] = (char*)malloc(sizeof(char) * (len + 1));
	}
	row = 0;
	permu(S, S, ret, &row);
	return ret;
}

int main()
{
	int size, i;
	char s[] = "abc", **ret;

	ret = permutation(s, &size);

	for (i = 0; i < size; i++) {
		printf("%s\n", ret[i]);
	}
	free(ret);
	return 0;
}

