package algorithmsForJob;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class duplicationArray
{
    public static void main(String[] args) {
        duplicationArray dupArr = new duplicationArray();
        int[] numbers = {1,3,4,5,5,3,2,3,2,2,2};
        int[] dup = new int[numbers.length/2+1];

        System.out.println("原numbers数组：");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers["+i+"]:"+numbers[i]);
        }

        if(dupArr.duplicate(numbers,numbers.length,dup))
        {
            System.out.println("含有重复元素dup：");
            for (int i = 0; i < dup.length; i++) {
                System.out.println("dup["+i+"]:"+dup[i]);
            }
        }

    }
    public boolean duplicate(int[] numbers,int length,int[] duplication) {
        if (numbers == null || length==0) {
            return false;
        }
/*        System.out.println("numbers数组排序前：");
        for (int i = 0; i < length; i++) {
            System.out.println(numbers[i]);
        }*/
        Arrays.sort(numbers);
/*        System.out.println("numbers数组排序后：");
        for (int i = 0; i < length; i++) {
            System.out.println(numbers[i]);
        }*/
        int temp=0,j = 0,duplen=0;
        Set<Integer> set = new HashSet();//此处必须标明Integer
        for(int i=0;i<length-1;i++){

            //1.利用Set集合的唯一性
            if (numbers[i] == numbers[i+1] && !set.contains(numbers[i])){
                set.add(numbers[i]);
            }
            //借助变量记录比较次数
//            if (numbers[i] == numbers[i+1]){
//                temp++;
//                /*
//                * 当且仅当两个相邻的值相同一次(temp == 1)便积累重复数组duplication中去，
//                * 如接连有三个以上的相邻值相同如四个2{2,2,2,2}共有三次比较，
//                * 第一次{2,2}比较时候，temp++==1,可存入duplication数组，{2,2,2}后两次比较temp++==2,temp++==3
//                * temp的值均不满足条件if (temp == 1)，故duplication不会之前已存的数据
//                * */
//                if (temp == 1){
//                    duplication[j++] = numbers[i];
//                    duplen++;
//                }
//            }else{
//                temp = 0;
//            }
        }
        Iterator<Integer> iterator = set.iterator();
        int tempdup = 0;
        while (iterator.hasNext()){
            tempdup = iterator.next();
            System.out.println("set:"+tempdup);
            duplication[j++] = tempdup;
            duplen++;
        }
        return duplen != 0;
    }
}
