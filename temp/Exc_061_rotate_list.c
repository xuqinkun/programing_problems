#include<stdio.h>
#include<stdlib.h>

struct ListNode {
	int val;
	struct ListNode *next;
};

int count(struct ListNode* head) {
	int n = 0;
	struct ListNode* p;
	for (p = head; p != NULL; p = p->next) n++;
	return n;
}

struct ListNode* rotateRight(struct ListNode* head, int k) {
	if (NULL == head) return head;
	int n = count(head);
	k = k % n;
	if (0 == k) return head;
	struct ListNode *p = head, *q = head;
	while (k-- > 0 && q != NULL) q = q->next;
	while (q->next != NULL) {
		p = p->next;
		q = q->next;
	}
	q = p->next;
	p->next = NULL;
	for (p = q; p->next != NULL; p = p->next) 
		;
	p->next = head;
	return q;
}
int main()
{
    return 0;
}

