
struct ListNode* swapPairs(struct ListNode* head) {
    struct ListNode dummy;
    dummy.next = head;
    struct ListNode* prev = &dummy;

    while (prev->next != NULL && prev->next->next != NULL) {
        struct ListNode* first = prev->next;
        struct ListNode* second = prev->next->next;

        // Perform the swap
        first->next = second->next;
        second->next = first;
        prev->next = second;

        // Move prev to the end of the swapped pair
        prev = first;
    }

    return dummy.next;
}