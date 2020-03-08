#include<stdio.h>
#include<stdlib.h>
int** zigzagLevelOrder(struct TreeNode* root, int* returnSize, int** returnColumnSizes) {
	*returnSize = height(root);
	if (NULL == root) return NULL;

	int **a = (int**)malloc(sizeof(int*) * (*returnSize)), n = count(root);
	*returnColumnSizes = (int*)malloc(sizeof(int) * (*returnSize));

	struct TreeNode** queue = (struct TreeNode**)malloc(sizeof(struct TreeNode*) * n);
	int i, front = -1, rear = -1, countLevel, tmp, level = 0;
	struct TreeNode* p;

	countLevel = 1;
	queue[++rear] = root;
	while (front != rear && countLevel != 0) {
		tmp = 0;
		(*returnColumnSizes)[level] = countLevel;

		while (countLevel-- != 0) {
			p = queue[++front];
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
		level++;
	}
	level = 0;	
	int leftToRight = 1, start = 0, j, end;

	while (start <= rear) {
		i = 0;
		countLevel = (*returnColumnSizes)[level];
		end = start + countLevel;
		a[level] = (int*)malloc(sizeof(int) * countLevel);
		if (leftToRight) {
			for (j = start; j < end; j++)
				a[level][i++] = queue[j]->val;
		}
		else {
			for (j = end - 1; j >= start; j--)
				a[level][i++] = queue[j]->val;
		}
		leftToRight = !leftToRight;
		level++;
		start += countLevel;
	}
	return a;
}

int main()
{
    return 0;
}

