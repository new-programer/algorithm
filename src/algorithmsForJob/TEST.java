package algorithmsForJob;

import java.util.*;

public class TEST{
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNodeT TT = new ListNodeT(24);
        ListNodeT TT2 = new ListNodeT(25);

        TT.next = TT2;
        arrayList.add(TT.val);
        System.out.println(arrayList.size());

        System.out.println("new Date():"+new Date());
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNodeT listNode) {

        return new ArrayList<>();
    }
}
class ListNodeT{
    protected int val = 0;
    protected ListNodeT next;

    ListNodeT(){}
    ListNodeT(int val){
        this.val = val;
    }
}