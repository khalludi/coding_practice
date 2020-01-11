
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class PalindromicLinkedList {

  public static boolean isPalindrome(ListNode head) {
    
    // Find middle; 1 -> 2 -> 3 -> 4 -> 5 -> 6
    ListNode slowPtr = head;
    ListNode fastPtr = head;
    while(fastPtr != null && fastPtr.next != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
    }

    // Reverse half of it
    ListNode prev = null;
    slowPtr = slowPtr.next;
    while(slowPtr != null) {
      ListNode next = slowPtr.next;
      slowPtr.next = prev;
      prev = slowPtr;
      slowPtr = next;
    }
    
    ListNode copyHalf = prev; // Store extra copy

    // Check
    boolean ret = true;
    ListNode startPtr = head;
    while (prev != null) {
      if (startPtr.value != prev.value) {
        ret = false;
        break;
      }
      prev = prev.next;
      startPtr = startPtr.next;
    }

    // Reverse back
    prev = null;
    while (copyHalf != null) {
      ListNode next = copyHalf.next;
      copyHalf.next = prev;
      prev = copyHalf;
      copyHalf = next;
    }

    return ret;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

    head.next.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
  }
}
