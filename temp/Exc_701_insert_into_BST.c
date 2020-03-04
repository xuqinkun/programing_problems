#include<stdio.h>
#include<stdlib.h>
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
};
struct TreeNode* insertIntoBST(struct TreeNode* root, int val) {
	struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
	node->val = val;
	node->left = NULL; node->right = NULL;
	if (NULL == root) {
		return node;
	}
	struct TreeNode* p = root;
	while (NULL != p) {
		if (val < p->val) {
			if (NULL != p->left) p = p->left;
			else {
				p->left = node;
				break;
			}
		}
		else {
			if (NULL != p->right) p = p->right;
			else {
				p->right = node;
				break;
			}		
		}
	}
	return root;
}
int main()
{
    return 0;
}

