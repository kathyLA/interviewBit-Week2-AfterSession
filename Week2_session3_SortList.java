/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode a) {
        if (a == null || a.next == null)
            return a;
        
        
        ListNode prev = null, slow = a, fast = a;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        
        ListNode la = sortList(a);
        ListNode lb = sortList(slow);
        
        return merge(la, lb);
    }
    
    ListNode merge(ListNode la, ListNode lb) {
        ListNode l = new ListNode(0), p = l;
        
        while (la != null && lb != null) {
            if (la.val < lb.val) {
                p.next = la;
                la = la.next;
            } else {
                p.next = lb;
                lb = lb.next;
            }
            p = p.next;
        }
        
        if (la != null)
            p.next = la;
        
        if (lb != null)
            p.next = lb;
        
        return l.next;
    }
    
}
