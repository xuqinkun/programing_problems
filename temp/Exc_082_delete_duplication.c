#include<stdio.h>
#include<stdlib.h>

struct ListNode {
	int val;
	struct ListNode *next;
};

struct ListNode* deleteDuplicates(struct ListNode* head) {
	if (NULL == head) return head;	
	struct ListNode pre;
	pre.next = head;
	struct ListNode *p = &pre, *tmp;
	while (p->next && p->next->next) {
		if (p->next && p->next->next && p->next->val == p->next->next->val) {
			tmp = p->next;
			while (tmp && tmp->next && tmp->val == tmp->next->val)
				tmp = tmp->next;
			p->next = tmp->next;
		}
		else
			p = p->next;
	}
	return pre.next;
}

int main()
{
    return 0;
}

