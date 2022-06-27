package com.morle;

// leetcode given
 class ListNode {
    int val;
    ListNode next;
    // constructors
    ListNode() {

    }
    ListNode(int val)
    {
        this.val = val;
    }
    ListNode(int val, ListNode next)
    {
        this.val = val; this.next = next;
    }
}

public class kthgroupreverse {

    // utility function to insert node in the list
    static ListNode push(ListNode head, int val)
    {
        ListNode newNode = new ListNode(val);
        // base condition
        if (head == null) {
            head = newNode;
            return head;
        }

        ListNode temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        return head;
    }
    // utility function to print the list
    static void print(ListNode head)
    {
        ListNode temp = head;
        while(temp!= null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        // initialization for reversing
        ListNode prev = null;
        ListNode present = head;

        // base condition
        if (k <=1 && head == null)
        {
            return head;
        }

        // counting elements
        int count = 0;
        ListNode temp = head;
        while(temp!=null)
        {
            count++;
            temp = temp.next;
        }

        // infinite loop because we have to keep reversing till current become null
        while (true)
        {
            // like a temporary variable
            ListNode last = prev;  // so that last wont be gayab na ho jaye.
            ListNode new_end = present;  // so that last wont be gayab na ho jaye.

            // continuee reversing
            ListNode next = present.next;

                // keep checking if number of elements is equivalent to k
                if (count < k){
                    break;
                }

                // continue reversing upto k elements
                for (int i = 1; i < k; i++)
                {
                    present.next = prev;
                    prev = present;
                    present = next;
                    if (next != null){
                        next = next.next; // null pointer exection
                    }
                }
                count -= k; // keep substracting the elements for checking purpose

            if (last != null)
            {
                last.next = prev;
            }
            else{
                head = prev;
            }

            new_end.next = present; // thats how it helped in storing above


            if (present == null)
            {
                break;
            }

            prev = new_end; // so that after reversing it points to that element which if going to be reversed.
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head = null;
        int k = 4;
        head = push(head, 1);
        head = push(head, 2);
        head = push(head, 3);
        head = push(head, 4);
        head = push(head, 5);
        head = push(head, 6);
        head = push(head, 7);
        System.out.println("Given Linked List");
        print(head);
        System.out.println("Reversed list");
        ListNode newHead = reverseKGroup(head, k);
        print(newHead);

    }
}
