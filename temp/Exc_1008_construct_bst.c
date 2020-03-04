#include<stdio.h>
#include<stdlib.h>

struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
};

struct TreeNode* insert(int* preorder, int left, int right) {
 	if (left > right) return NULL;
	struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
	int rootVal = preorder[left], i = left + 1;
	root->val = rootVal;
	while (i <= right && preorder[i] < rootVal) i++;
	root->left = insert(preorder, left + 1, i - 1);
	root->right = insert(preorder, i, right);
	return root;
}


struct TreeNode* bstFromPreorder(int* preorder, int preorderSize) {
	return insert(preorder, 0, preorderSize - 1);
}
int main()
{
    return 0;
}

