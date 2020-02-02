class RearrangeList {

  public static void reorder(ListNode head) {

    ListNode slowPtr = head, fastPtr = head;
    while (fastPtr != null && fastPtr.next != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
    }

    ListNode prev = null;
    while(slowPtr != null) {
      ListNode next = slowPtr.next;
      slowPtr.next = prev;
      prev = slowPtr;
      slowPtr = next;
    }

    ListNode copyHead = head;
    while(prev != null && copyHead != null) {
      ListNode next = copyHead.next;
      copyHead.next = prev;
      copyHead = next;

      next = prev.next;
      prev.next = copyHead;
      prev = next;
    }

    if (copyHead != null && copyHead.next != null) {
      copyHead.next = null;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);
    //head.next.next.next.next.next = new ListNode(12);
    RearrangeList.reorder(head);
    while (head != null) {
      System.out.print(head.value + " ");
      head = head.next;
    }
  }
}

