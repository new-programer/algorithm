package algorithmsForJob;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        * 输入：3
        *输出：10
        */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(todayVal(1,n));
    }

    public static int todayVal(int value, int n){
        if (n == 1){
            return 1;
        }else {
            return (todayVal(value+1,n-1)+1)* 2;
        }
    }
}