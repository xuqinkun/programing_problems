#include<stdio.h>
#include<stdlib.h>

struct ListNode {
	int val;
	struct ListNode *next;
};

struct ListNode* swapPairs(struct ListNode* head) {
	if (NULL == head) return NULL;
	struct ListNode *node = (struct ListNode*)malloc(sizeof(struct ListNode)), *p, *q, *x;
	node->next = head;
	head = node;
	p = head; q = head->next;
	while (q->next != NULL) {
		x = q->next;
		q->next = x->next;
		x->next = q;
		p->next = x;
		p = q;
		if (q->next != NULL) {
			q = q->next;
		}
	}
	x = head;
	head = head->next;
	x->next = NULL;
	free(x);
	return head;
}

int main()
{
    return 0;
}

