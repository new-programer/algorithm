package algorithmsForPaper;

import static java.lang.Math.pow;

/**
 * @Description TODO
 * @Author EricGao
 * @Date 17:14 2020/3/27
 */
public class FitFunTest {
    public static void main(String[] args) {
        double x = -99.694;
        double y =  2 * pow(x, 4.0) + 4 * pow(x, 3.0) - 6 * pow(x, 2.0) +15 * (x - 12.0);

        System.out.println("y的值为：" + y);
    }
}
