package algorithmsForJob;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1,5,6,3,9,8,6,7};
        System.out.println(binarySearch(a,0,a.length,6));
    }
    static int binarySearch(int[] a, int low, int high, int value){
        //查找区间[low, high)，左闭右开
        while (low < high){
            int mid = low + (high - low)/2;
            if (a[mid] < value)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
