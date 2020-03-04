#include<stdio.h>
#include<stdlib.h>

struct ListNode {
	int val;
	struct ListNode *next;
};

struct ListNode* reverseList(struct ListNode* head) {
	if (NULL == head) return NULL;
	struct ListNode* pre = NULL, *p = head, *next;
	while (NULL != p) {
		next = p->next;
		p->next = pre;
		pre = p;
		p = next;
	}
	return pre;
}

int main()
{
    return 0;
}

