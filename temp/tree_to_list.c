#include<stdio.h>
#include<stdlib.h>


struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
};

struct ListNode {
	int val;
	struct ListNode *next;
};

int max(int a, int b) {
	return a > b ? a : b;
}

int height(struct TreeNode* tree) {
	if (NULL == tree) return 0;
	return 1 + max(height(tree->left), height(tree->right));
}

int size(struct TreeNode* tree) {
	if (NULL == tree) return 0;
	return 1 + size(tree->left) + size(tree->right);
}

struct ListNode** listOfDepth(struct TreeNode* tree, int* returnSize) {
	int h = height(tree), n = size(tree), i;
	*returnSize = h;
	struct ListNode** lists = (struct ListNode**)malloc(sizeof(struct ListNode*) * h);
	struct TreeNode **nodes = (struct TreeNode**)malloc(sizeof(struct TreeNode*) * n), *p = NULL;

	for (i = 0; i < h; i++) {
		lists[i] = (struct ListNode*)malloc(sizeof(struct ListNode));
		lists[i]->next = NULL;
	}

	int front = -1, rear = -1, countLevel = 0, tmp = 0, level = 0;
	nodes[++rear] = tree;
	countLevel++;

	while (front != rear) {
		struct ListNode* curr = lists[level++];
		tmp = 0;
		while (countLevel-- > 0) {
			p = nodes[++front];
			struct ListNode* node = (struct ListNode*)malloc(sizeof(struct ListNode));
			node->val = p->val;
			curr->next = node;
			curr = curr->next;
			if (NULL != p->left) {
				nodes[++rear] = p->left;
				tmp++;
			}
			if (NULL != p->right) {
				nodes[++rear] = p->right;
				tmp++;
			}
		}
		curr->next = NULL;
		countLevel = tmp;
	}
	for (i = 0; i < h; i++) {
		lists[i] = lists[i]->next;
	}
	free(nodes);
	return lists;
}

struct TreeNode* insert(const int a[], int n) {
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

void print(struct ListNode *head) {
	struct ListNode *p = head;
	while (NULL != p) {
		printf("%d", p->val);
		if (NULL != p->next) {
			printf("->");
		}
		p = p->next;
	}
	printf("\n");
}

int main()
{
	int a[] = { 1,2,3,4,5,-1,7,8 }, n = sizeof(a) / sizeof(int);
	struct TreeNode *root = insert(a, n);
	
	int i, num;
	struct ListNode ** lists = listOfDepth(root, &num);

	for (i = 0; i < num; i++) {
		print(lists[i]);
	}
	return 0;
}

