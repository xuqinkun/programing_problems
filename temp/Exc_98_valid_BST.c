#include<stdio.h>
#include<stdlib.h>
bool isValid(struct TreeNode* root, long min, long max) {
	if (NULL == root) return true;
	int val = root->val;
	if (val <= min && val >= max) return false;
	return isValid(root->left, INT_MIN - 1, root->val) &&
		isValid(root->right, root->val, INT_MAX + 1);
}

bool isValidBST(struct TreeNode* root) {
	if (NULL == root) return true;
	return isValid(root->left, INT_MIN - 1, root->val) && 
		isValid(root->right, root->val, INT_MAX + 1);
}
int main()
{
    return 0;
}

