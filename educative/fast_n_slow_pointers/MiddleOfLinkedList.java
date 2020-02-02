class MiddleOfLinkedList {

  public static ListNode findMiddle(ListNode head) {
    ListNode slowPtr = head;
    ListNode fastPtr = head;
    while (fastPtr.next != null && fastPtr.next.next != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
    }
    
    return fastPtr.next == null ? slowPtr : slowPtr.next;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

    head.next.next.next.next.next = new ListNode(6);
    System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

    head.next.next.next.next.next.next = new ListNode(7);
    System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
  }
}
