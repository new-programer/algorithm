package algorithmsForJob.meituan20200512.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author EricGao
 * @Date 10:12 2020/5/12
 */
public class Main {
    public int HM_distance(int x, int y){
        int diffBits = x ^ y;
        int result = 0;
        while (diffBits != 0){
            diffBits = diffBits & (diffBits-1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = sc.nextInt();

        int[] array = new int[n];//
        /*初始化*/
        for (int i =0; i<n; i++){
            array[i] = i+1;
        }
        /*计算汉明距离*/
        List<Integer> temp = new ArrayList<>();
        for (int i =1; i<n; i++){
            int hmDistance = new Main().HM_distance(array[i-1], array[i]);
            temp.add(hmDistance);
        }

        int maxHM = 0;
        for (Integer integer : temp ){

            if (maxHM < integer){
                maxHM = integer;
            }
        }
        System.out.println(maxHM);
    }
}
