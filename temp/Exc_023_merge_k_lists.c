#include<stdio.h>
#include<stdlib.h>

struct ListNode {
	int val;
	struct ListNode *next;
};

struct ListNode* mergeTwoLists(struct ListNode* p, struct ListNode* q) {
	struct ListNode *head = (struct ListNode*)malloc(sizeof(struct ListNode)), *curr = head;
	head->next = NULL;
	while (p != NULL && q != NULL) {
		if (p->val < q->val) {
			curr->next = p;
			p = p->next;
		}
		else {
			curr->next = q;
			q = q->next;
		}
		curr = curr->next;
	}
	if (NULL != p) {
		curr->next = p;
	}
	if (NULL != q) {
		curr->next = q;
	}
	curr = head;
	head = head->next;
	free(curr);
	return head;
}
struct ListNode* mergeKLists(struct ListNode** lists, int listsSize) {
	if (0 == listsSize) return NULL;
	int i, index;
	struct ListNode *p, *q;	
	while (listsSize != 1) {
		index = 0;
		for (i = 0; i < listsSize - 1; i += 2) {
			p = lists[i];
			q = lists[i + 1];
			lists[index++] = mergeTwoLists(p, q);
		}
		if (listsSize % 2 != 0) {
			lists[index] = lists[listsSize - 1];
		}
		listsSize = (listsSize + 1) / 2;
	}	
	return lists[0];
}
int main()
{
    return 0;
}

