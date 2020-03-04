#include<stdio.h>
#include<stdlib.h>
struct TreeNode* insert(int *a, int n, int left, int right) {
	if (left > right) return NULL;

	int i, indexOfMax = left, max = a[left];
	for (i = left + 1; i <= right; i++) {
		if (max < a[i]) {
			max = a[i];
			indexOfMax = i;
		}
	}
	struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
	node->val = max;
	node->left = insert(a, n, left, indexOfMax - 1);
	node->right = insert(a, n, indexOfMax + 1, right);
	return node;
}

struct TreeNode* constructMaximumBinaryTree(int* a, int n) {
	return insert(a, n, 0, n - 1);
}

int main()
{
    return 0;
}

