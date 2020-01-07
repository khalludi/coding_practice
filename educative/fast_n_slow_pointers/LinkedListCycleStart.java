class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class LinkedListCycleStart {

  public static ListNode findCycleStart(ListNode head) {
    ListNode slowPtr = head;
    ListNode fastPtr = head;
    int len = 0;

    while (fastPtr != null && fastPtr.next != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;

      if (slowPtr == fastPtr) {
        len = findLength(head, slowPtr);
        break;
      }
    }

    return findCycle(head, len);
  }

  private static int findLength(ListNode head, ListNode slowPtr) {
    int ret = 0;

    while (head != slowPtr) {
      head = head.next;
      ret++;
    }

    return ret;
  }

  private static ListNode findCycle(ListNode head, int len) {
    ListNode slowPtr = head;
    ListNode fastPtr = head;
    
    int i = len;
    while (i > 0) {
      fastPtr = fastPtr.next;
      i--;
    }

    while (slowPtr != fastPtr) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next;
    }

    return slowPtr;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
  }
}
