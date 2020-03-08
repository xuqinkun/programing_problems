#include<stdio.h>
#include<stdlib.h>

struct TreeNode* build(int* inorder, int* postorder, int inLeft, int inRight, int postLeft, int postRight) {
	if (inLeft > inRight) return NULL;
	struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
	int i, leftLen, rootVal = postorder[postRight];
	
	node->val = rootVal;
	if (inLeft == inRight) {
		node->left = NULL;
		node->right = NULL;
		return node;
	}

	for (i = inLeft; i <= inRight; i++) {
		if (inorder[i] == rootVal)
			break;
	}

	leftLen = i - inLeft;	
	node->left = build(inorder, postorder, inLeft, i - 1, postLeft, postLeft + leftLen - 1);
	node->right = build(inorder, postorder, i + 1, inRight, postLeft + leftLen, postRight - 1);

	return node;
}

struct TreeNode* buildTree(int* inorder, int inorderSize, int* postorder, int postorderSize) {
	return build(inorder, postorder, 0, inorderSize - 1, 0, postorderSize - 1);
}

int main()
{
    return 0;
}

