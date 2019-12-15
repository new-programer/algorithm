/*
package algorithmsForJob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution1 {
    public int reverse(int x) {
        int sign = 1;
        if(x < 0) sign = -1;
        int n = x<0?-x:x;
        int m = n % 10;
        while(n >= 10){
            n /= 10;
            m  = m*10 + n%10;//此处m值的计算是绝妙之笔呀
        }
        return m*sign;
    }
}
class Solution2{
    public int reverse(int x){
        StringBuilder stringBuilder = new StringBuilder(x);
        System.out.println(stringBuilder);
        System.out.println("hello world!");
        System.out.println(stringBuilder.reverse());
        return 0;
    }
}
public class ReverseInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new Solutions2().reverse(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
*/
