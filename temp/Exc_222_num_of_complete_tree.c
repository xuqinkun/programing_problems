#include<stdio.h>
#include<stdlib.h>
int height(struct TreeNode* root) {
	if (NULL == root) return -1;
	int d = 0;
	struct TreeNode* p = root;
	while (p->left != NULL) {
		p = p->left;
		d++;
	}
	return d;
}

int existNode(struct TreeNode* root, int d, int x) {
	struct TreeNode* p = root;
	int i, left = 1, right = pow(2, d), pivot;
	for (i = 0; i < d; i++) {
		pivot = left + (right - left) / 2;
		if (pivot < x) {
			p = p->right;
			left = pivot + 1;
		}
		else {
			p = p->left;
			right = pivot;
		}
	}
	return p != NULL;
}

int countNodes(struct TreeNode* root) {
	if (NULL == root) return 0;
	int d = height(root);
	if (0 == d) return 1;
	int n = pow(2, d), left = 1, right = n, mid;
	while (left <= right) {
		mid = left + (right - left) / 2;
		if (!existNode(root, d, mid)) {
			right = mid - 1;
		}
		else {
			left = mid + 1;
		}
	}
	return n - 1 + right;
}

int main()
{
	int a[] = {1,2,3}, n = sizeof(a) / sizeof(int);
	int b[] = {9,15,7,20,3}, inSize = sizeof(a) / sizeof(int);
	struct TreeNode* root = arrayToTree(a, n);
	
	printf("%d\n", countNodes(root));
	return 0;
}
