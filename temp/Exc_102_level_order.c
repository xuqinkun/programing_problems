#include<stdio.h>
#include<stdlib.h>

struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
};

int count(struct TreeNode* root) {
	if (NULL == root) return 0;
	return 1 + count(root->left) + count(root->right);
}

int max(int a, int b) {
	return a > b ? a : b;
}

int height(struct TreeNode* root) {
	if (NULL == root) return 0;
	return 1 + max(height(root->left), height(root->right));
}

int** levelOrder(struct TreeNode* root, int* returnSize, int** returnColumnSizes) {
	*returnSize = height(root);
	if (NULL == root) return NULL;

	int **a = (int**)malloc(sizeof(int*) * (*returnSize)), n = count(root);
	*returnColumnSizes = (int*)malloc(sizeof(int) * (*returnSize));

	struct TreeNode** queue = (struct TreeNode**)malloc(sizeof(struct TreeNode*) * n);
	int i, front = -1, rear = -1, countLevel, tmp, level = 0, num = 1;
	struct TreeNode* p;

	countLevel = 1;
	queue[++rear] = root;
	while (front != rear) {
		i = 0;  tmp = 0;
		a[level] = (int*)malloc(sizeof(int) * num);
		(*returnColumnSizes)[level] = countLevel;

		while (countLevel-- != 0) {
			p = queue[++front];
			a[level][i++] = p->val;
			if (NULL != p->left) {
				queue[++rear] = p->left;
				tmp++;
			}
			if (NULL != p->right) {
				queue[++rear] = p->right;
				tmp++;
			}
		}
		countLevel = tmp;		
		num *= 2;
		level++;
	}
	free(queue);
	return a;
}
struct TreeNode* arrayToTree(int a[], int n) {
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

void printArrays(int **a, int row, int *cols) {
	int i, j;
	for (i = 0; i < row; i++) {
		for (j = 0; j < cols[i]; j++) {
			printf("%3d", a[i][j]);
		}
		printf("\n");
	}
}

int main()
{
	int a[] = { 3,9,20,-1,-1,15,7 },n = sizeof(a)/sizeof(int);
	struct TreeNode* root = arrayToTree(a, n);
	int row, *cols;
	int **ans = levelOrder(root, &row, &cols);
	printArrays(ans, row, cols);
	system("pause");

	return 0;
}
