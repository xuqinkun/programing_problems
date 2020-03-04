#include<stdio.h>
#include<stdlib.h>

struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
};

typedef struct TreeNode TreeNode;

int size(struct TreeNode* root) {
	if (root == NULL) {
		return 0;
	}
	return 1 + size(root->left) + size(root->right);
}

int* inorderTraversal(struct TreeNode* root, int* returnSize) {
	int i = 0, n = size(root);
	int *elems = (int*)malloc(sizeof(int) * n);

	*returnSize = n;
	if (0 != n) {
		struct TreeNode* p = root;
		struct TreeNode **stack = (TreeNode**)malloc(sizeof(TreeNode*) * n);

		int j, top = -1;
		for (j = 0; j < n; j++)
			stack[j] = (TreeNode*)malloc(sizeof(TreeNode));

		while (NULL != p || -1 != top) {
			while (NULL != p) {
				stack[++top] = p;
				p = p->left;
			}
			p = stack[top--];
			elems[i++] = p->val;
			p = p->right;
		}
	}

	return elems;
}

int main()
{
	struct TreeNode* root = (TreeNode*)malloc(sizeof(TreeNode));
	root->val = 1;
	root->left = NULL;
	root->right = (TreeNode*)malloc(sizeof(TreeNode));
	root->right->val = 2;
	root->right->left = (TreeNode*)malloc(sizeof(TreeNode));
	root->right->left->val = 3;
	root->right->right = NULL;
	root->right->left->left = NULL;
	root->right->left->right = NULL;

	int i, size, *a;
	a = inorderTraversal(root, &size);
	for (i = 0; i < size; i++) {
		printf("%d ", a[i]);
	}
	return 0;
}

