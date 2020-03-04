#include<stdio.h>
#include<stdlib.h>
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
};
struct TreeNode* insert(int *nums, int left, int right) {
	if (left > right) return NULL;
	struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
	int mid = (left + right + 1) / 2;
	node->val = nums[mid];
	node->left = insert(nums, left, mid - 1);
	node->right = insert(nums, mid + 1, right);
	return node;
}

struct TreeNode* sortedArrayToBST(int* nums, int n) {
	return insert(nums, 0, n - 1);
}

int main()
{
    return 0;
}

