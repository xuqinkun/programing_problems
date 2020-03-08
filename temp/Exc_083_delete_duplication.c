#include<stdio.h>
#include<stdlib.h>

struct ListNode {
	int val;
	struct ListNode *next;
};

struct ListNode* deleteDuplicates(struct ListNode* head) {
	if (NULL == head) return head;
	struct ListNode *pre = head, *p = head->next;
	int last = head->val;
	while (p != NULL) {
		if (last == p->val) {
			pre->next = p->next;
		}
		else {
			last = p->val;
			pre = p;
		}
		p = p->next;
	}
	return head;
}

int main()
{
    return 0;
}

