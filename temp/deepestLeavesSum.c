#include<stdio.h>
#include<stdlib.h>
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
};

int max(int a, int b) {
	return a > b ? a : b;
}

int height(struct TreeNode* root) {
	if (NULL == root) return 0;
	return 1 + max(height(root->left), height(root->right));
}

int sumLeaves(struct TreeNode* root, int h) {
	if (NULL == root) return 0;
	if (NULL == root->left && NULL == root->right && h == 1) {
		return root->val;
	}
	return sumLeaves(root->left, h - 1) + sumLeaves(root->right, h - 1);
}

int deepestLeavesSum(struct TreeNode* root) {
	int sum, h = height(root);
	sum = sumLeaves(root, h);
	return sum;
}

struct TreeNode* insert(const int a[], int n) {
	struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
	struct TreeNode **nodes = (struct TreeNode**)malloc(sizeof(struct TreeNode*) * n), *p;
	int front = -1, rear = -1, i = 0;

	root->val = a[i++];
	root->left = NULL; root->right = NULL;
	nodes[++rear] = root;

	while (i < n) {
		p = nodes[++front];
		if (i < n && a[i] != -1) {
			struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
			node->val = a[i];
			node->left = NULL; node->right = NULL;
			p->left = node;
			nodes[++rear] = node;
		}
		i++;
		if (i < n && a[i] != -1) {
			struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
			node->val = a[i];
			node->left = NULL; node->right = NULL;
			p->right = node;
			nodes[++rear] = node;
		}
		i++;
	}
	free(nodes);
	return root;
}

int main()
{
	int a[] = {1,2,3,4,5,-1,6,7,-1,-1,-1,-1,8}, n = sizeof(a) / sizeof(int);

	struct TreeNode *root = insert(a, n);

	printf("%d\n", deepestLeavesSum(root));
	return 0;
}

