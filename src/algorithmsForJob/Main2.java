package algorithmsForJob;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        int aUpper = (int)Math.pow(10.0, Math.pow(10.0, 5.0));
        int bUpper = (int)Math.pow(10.0, 18.0);

        while( (a<1 && a>aUpper) || (b<1 && b>bUpper)) {
            a = in.nextInt();
            b = in.nextInt();
        }

        int maxValueIn_ab = (a > b? a:b);
        int rev = 0; //保存余数

        boolean flag = true;
        while(flag) {
            if(a <= b) {
                if(b % a == 0) {
                    System.out.println(a);
                    flag = false;
                }else {
                    rev = b % a;
                    b = a;
                    b = rev;
                }
            }else {
                if (a % b == 0) {
                    System.out.print(b);
                    flag = false;
                }else {
                    rev = a % b;
                    a = b;
                    b = rev;
                }
            }
        }

    }
}