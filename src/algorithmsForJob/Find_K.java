package algorithmsForJob;

import java.util.Arrays;

public class Find_K {
    public static void main(String[] args) {
        int[] a = {1,3,5,2,2};
        int n = 5;
        int K = 3;


        Arrays.sort(a);
        System.out.println("Arrays（序号）:" + a[a.length-K]);

        System.out.println("============================我是分割线================================");

        Finder f  = new Finder();
        System.out.println("Finder（序号）：" + f.findKth(a, n, K));


        System.out.println("============================我是分割线quickSort2================================");
        int[] b = {1,3,5,2,2};
        f.quickSort2(b,0,a.length-1);
        for (int i = 0; i <b.length; i++) {
            System.out.println("b[" + i+"]:"+b[i]);
        }
    }
}
class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here
        int[] result = quickSort(a, 0, a.length-1);
        return a[K-1];
    }
    int[] quickSort(int[] a, int low, int high){
        if (low < high){
            int temp;
            int i=low, j=high;
            while (i<j){
                temp = a[high];
                //find a number, which is smaller than temp
                while (i<j && a[i]>=temp){
                    i++;
                }
                if (i<j){
                    a[j] = a[i];
                    j--;
                }
                while (i<j && a[j] <= temp){
                    j--;
                }
                if (i<j){
                    a[i] = a[j];
                    i++;
                }
                a[high] = temp;
                quickSort(a, low, i-1);
                quickSort(a, i+1, high);
            }
        }
        return a;
    }

    void quickSort2(int[] a, int left, int right){
        if (left < right){
            int pivot = left;
            int i = left;
            int j = right;

            while (i<j){
                int temp = 0;

                while (i<j && a[j]>=a[pivot]){
                    j--;
                }
                if (i < j){
                    temp = a[j];
                    a[j] = a[pivot];
                    a[pivot] = temp;
                    pivot = j--;
                }

                while (i<j && a[i]<=a[pivot]){
                    i++;
                }
                if (i<j){
                    temp = a[i];
                    a[i] = a[pivot];
                    a[pivot] = temp;
                    pivot = i++;
                }
            }

            //递归遍历左右两边的数
            quickSort2(a, left, i-1);
            quickSort2(a,i+1, right);
        }
    }
}