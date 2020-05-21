package algorithmsForJob;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description 输入两个数字（用逗号割开），求两个数字之间的所有素数
 * @Author EricGao
 * @Date 13:14 2020/2/27
 */
public class IntervalPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a=0,b=0;
        try{
            String input = scanner.next();
            String[] inputVals = input.split(",");
            a = Integer.parseInt(inputVals[0]);
            b = Integer.parseInt(inputVals[1]);
        }catch (Exception e){
            System.out.println("ERROR");
        }
        long startTime = System.currentTimeMillis();//开始时间

        ArrayList<Integer> primes = findPrimes(a, b);
        if (primes.size() == 0){
            System.out.println("NO DATA");
        }else{
            for(Integer prime : primes){
                System.out.print(prime + "  ");
            }
        }

        long endTime = System.currentTimeMillis();//结束时间
        System.out.println("素数查找及遍历耗时：" + (endTime-startTime));
    }

    /**
     * 素数查找搜集函数
     * @param a 区间开始位置
     * @param b 区别结束位置
     * @return 返回a,b区间内（闭区间）的所有素数
     */
    static ArrayList<Integer> findPrimes(int a, int b){
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i=a; i<b+1; i++){
            boolean primeFlag = false;
//            primeFlag = isPrime(i); //使用该方法，程序耗时：25ms，(1，10000)
//            primeFlag = isPrime2(i);//使用该方法，程序耗时：36ms，(1，10000)
            primeFlag = isPrime3(i);//使用该方法，程序耗时：24ms，(1，10000)
            if (primeFlag){
                primes.add(i);
            }
        }
        return primes;
    }

    /**方法一 引入指数来缩小遍历范围
     * 素数/质数判断函数
     * @param number 为将要进行判断的数字
     * @return 若为素数返回true，否在返回false
     */
    static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**方法二 直观判断法
     * 素数判断，该方法要遍历区间内的每一个数，数据复杂的为n平方，性能低
     * @param number 为将要进行判断的数字
     * @return 若为素数返回true，否在返回false
     */
    static boolean isPrime2(int number){
        for (int i=2; i<number; i++){
            if (number%i == 0){
                /*说明：如果在1到number范围内存在能整除number的数字，则number不是素数；否则，number是素数*/
                return false;
            }
        }
        return true;
    }

    /**方法三 直观判断法改进-引入根号缩小遍历范围
     * 素数判断，<方法说明：sqrt()函数对素数判断的优化>
     * 素数是只有1和本身能整除的整数。所以在求素数的时候，要将素数与1到素数本身中间的所有整数都相除，看是否有整除的数，如果有，
     * 那肯定不是素数了。但是从算法上考虑，为了减少重复量，开平方后面的数就不用相除了，因为a/b（平方数）=c（小一点的数），
     * 同样a/c=b。举例说明：25，开平方以后是5,那么整除2~5就可以了，如果有满足条件的，就是素数。
     * 这样做可以减少循环次数，素数是因子为1和本身， 如果数c不是素数，则还有其他因子，其中的因子，假如为a,b.
     * 其中必有一个大于sqrt(c) ，一个小于sqrt(c) 。所以m必有一个小于或等于其平方根的因数，那么验证素数时就只需要
     * 验证到其平方根就可以了。即一个合数一定含有小于它平方根的质因子。
     * 再比如：24的因数有1、2、3、4、6、8、12、24
     * 按定义应该用2－23去除，但经过分析上面的数可以发现
     * 1×24、2×12、3×8、4×6
     * 如果2、3、4是某个数的因数，那么另外几个数也是，反之也一样
     * 所以为提高效率，可以只检查小于该数平方根的那些数，如24的平方根大于4小于5，检查2－4就可以了！
     * @param number 为将要进行判断的数字
     * @return 若为素数返回true，否在返回false
     */
    static boolean isPrime3(int number){
        for (int i=2; i<Math.sqrt(number); i++){
            if (number%i == 0){
                /*说明：如果在1到 Math.sqrt(number) 范围内存在能整除number的数字，则number不是素数；否则，number是素数*/
                return false;
            }
        }
        return true;
    }
}
