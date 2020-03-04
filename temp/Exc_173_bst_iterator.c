#include<stdio.h>
#include<stdlib.h>
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


typedef struct {
	int index;
	int size;
	int *vals;
} BSTIterator;

int count(struct TreeNode* root) {
	if (NULL == root) return 0;
	return 1 + count(root->left) + count(root->right);
}

BSTIterator* bSTIteratorCreate(struct TreeNode* root) {
    int n = count(root), top = -1;
	
	struct TreeNode **stack = (struct TreeNode**)malloc(sizeof(struct TreeNode*) * n), *p = root;
	BSTIterator *iter = (BSTIterator*)malloc(sizeof(BSTIterator));
	iter->vals = (int*)malloc(sizeof(int) * n);
	iter->index = 0;
	iter->size = n;

	while (-1 != top || NULL != p) {		
		while (NULL != p) {
			stack[++top] = p;
			p = p->left;
		}
		p = stack[top--];
		iter->vals[iter->index] = p->val;
		(iter->index)++;
		p = p->right;
	}
	iter->index = 0;
	return iter;
}

/** @return the next smallest number */
int bSTIteratorNext(BSTIterator* obj) {
    int val = obj->vals[obj->index];
	(obj->index)++;
	return val;
}

/** @return whether we have a next smallest number */
bool bSTIteratorHasNext(BSTIterator* obj) {
	return obj->index < obj->size;
}

void bSTIteratorFree(BSTIterator* obj) {
    free(obj->vals);
}

/**
 * Your BSTIterator struct will be instantiated and called as such:
 * BSTIterator* obj = bSTIteratorCreate(root);
 * int param_1 = bSTIteratorNext(obj);
 
 * bool param_2 = bSTIteratorHasNext(obj);
 
 * bSTIteratorFree(obj);
*/
int main()
{
    return 0;
}

