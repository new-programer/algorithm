package algorithmsForJob;

import java.io.IOException;
import java.util.ArrayList;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(){};
    ListNode(int x) { val = x; }
}
/*

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] a1 = new int[3];
        int[] a2 = new int[3];

        ListNode p = l1;
        ListNode q = l2;
        int i = 0;
        while((p!=null)&&(q!=null)){
            a1[i] = p.val;
            a2[i] = q.val;

            p = p.next;
            q = q.next;

            i++;
        }
        int temp = 0;
        int sum = 0;
        for (i = a1.length-1; i>=0; i--){
            sum = a1[i] + a2[i] + temp;
            temp = 0;
            if(sum >= 10){
                a1[i] = sum % 10;
                temp = sum / 10;
            }else{
                a1[i] = sum;
            }
        }
        p = l1;
        i = a1.length-1;
        while((p != null) && (i >= 0)){
            p.val = a1[i];
            p = p.next;
            i--;
        }

        return l1;
    }
}
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();

        ListNode p = l1;
        ListNode q = l2;
        int i = 0;
        while((p!=null)&&(q!=null)){

            al1.add((Integer)p.val);
            al2.add((Integer)q.val);

            p = p.next;
            q = q.next;

            i++;
        }

        int temp = 0;
        int sum = 0;

        System.out.println("al1.size():   " + al1.size());
        System.out.println("al1.get(0):   " + al1.get(0));
        System.out.println("al1.get(1):   " + al1.get(1));
        System.out.println("al1.get(2):   " + al1.get(2));
        for (i = (al1.size()-1); i >= 0; i--){
            sum = al1.get(i) +  al2.get(i) + temp;
            sum = al1.get(i) +  al2.get(i) + temp;
            temp = 0;
            if(sum >= 10){
                al1.set(i, (sum % 10));
                temp = sum / 10;
            }else{
                al1.set(i, sum);
            }
        }

        p = l1;
        i =  (al1.size()-1);
        while((p != null) && (i >= 0)){
            p.val = al1.get(i);
            p = p.next;
            i--;
        }

        return l1;
    }
}

public class AddTwoNum {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        ListNode p = l1;
        for (int i = 0; i < 2; i++) {
            ListNode temp = new ListNode();
            p.next = temp;
            p = p.next;
        }

        l1.next.val = 4;
        l1.next.next.val = 3;

        ListNode l2 = new ListNode(5);
        ListNode q = l2;
        for (int i = 0; i < 2; i++) {
            ListNode temp = new ListNode();
            q.next = temp;
            q = q.next;
        }

        l2.next.val = 6;
        l2.next.next.val = 4;

        ListNode test = solution.addTwoNumbers(l1, l2);

        System.out.println(test.val+ "，" + test.next.val + "，" + test.next.next.val);
    }
}