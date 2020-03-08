#include<stdio.h>
#include<stdlib.h>

struct TreeNode* build(int* preorder, int* inorder, int preLeft, int preRight, int inLeft, int inRight) {
	if (preLeft > preRight) return NULL;
	struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
	int i, leftLen, rootVal = preorder[preLeft];	
	
	node->val = rootVal;

	for (i = inLeft; i <= inRight; i++) {
		if (inorder[i] == rootVal)
			break;
	}

	leftLen = i - inLeft;	
	node->left = build(preorder, inorder, preLeft + 1, preLeft + leftLen, inLeft, i - 1);
	node->right = build(preorder, inorder, preLeft + leftLen + 1, preRight, i + 1, inRight);

	return node;
}

struct TreeNode* buildTree(int* preorder, int preorderSize, int* inorder, int inorderSize) {
	return build(preorder, inorder, 0, preorderSize - 1, 0, inorderSize - 1);
}

int main()
{
    return 0;
}

