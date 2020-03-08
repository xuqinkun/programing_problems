#include<stdio.h>
#include<stdlib.h>
struct TreeNode* preorder(struct TreeNode* root) {
	if (NULL == root || (NULL == root->left && NULL == root->right)) {
		return root;
	}
	struct TreeNode *right = root->right, *curr = root;
	root->right = preorder(root->left);
	root->left = NULL;
	while (curr->right != NULL) {
		curr = curr->right;
	}
	curr->right = preorder(right);
	return root;
}

void flatten(struct TreeNode* root) {
	if (NULL == root) return;
	preorder(root);
}
int main()
{
    return 0;
}

