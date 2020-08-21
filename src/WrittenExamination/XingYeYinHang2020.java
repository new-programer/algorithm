package WrittenExamination;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author EricGao
 * @Date 7:43 2020/8/21
 */
public class XingYeYinHang2020 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] temp = input.nextLine().split(",");
        int len = temp.length;
        int[] a = new int[len];

        for (int i = 0; i < len; i++) {
            a[i] = Integer.parseInt(temp[i]);
        }

        Map<String, Integer> result = printDublicates(a);

        for (Entry<String, Integer> entry : result.entrySet()){
            if (entry.getValue() == 2){
                System.out.print(entry.getKey() + " ");
            }
        }

        input.close();
    }

    private static Map<String, Integer> printDublicates(int[] a) {
        Map<String, Integer> result = new HashMap<>();

        for (int item : a) {
            String temp = String.valueOf(item);
            int value = 0;
            if (result.containsKey(temp)) {
                value = result.get(temp);
                result.replace(temp, value + 1);
            } else {
                result.put(temp, 1);
            }
        }
        return result;
    }
}
