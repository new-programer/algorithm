package WrittenExamination;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description TODO
 * @Author EricGao
 * @Date 10:12 2020/5/12
 */
public class MeiTuan2020 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] tempChars =input.split(" ");
        int n = Integer.parseInt(tempChars[0]);
        int m = Integer.parseInt(tempChars[1]);

        int[][] scoreArray = new int[n][m];//
        /*初始化*/
        init(scoreArray, n, m);
        for (int i =0; i<n; i++){
            for (int j=0;j<m; j++){
                System.out.print(scoreArray[i][j]+" ");
            }
            System.out.println();
        }
        /*获得单科成绩优秀奖的人数，非人次*/
        Set<Integer> bestSet =  findBest(scoreArray, n, m);
        System.out.println(bestSet.size());
    }

    private static Set<Integer> findBest(int[][] scoreArray, int n, int m) {
        Set<Integer> bestStuSet = new HashSet<>();

        for (int i =0; i<n; i++){
            int maxScore=0;
            int tempBest =0;

            for (int j=0;j<m; j++){
                if (maxScore < scoreArray[j][i]){
                    maxScore = scoreArray[j][i];
                    tempBest = j;
                }
            }

            bestStuSet.add(tempBest);//利用集合的唯一性
        }

        return bestStuSet;
    }

    private static void init(int[][] scoreArray, int n, int m){
        Random random = new Random();

        for (int i =0; i<n; i++){
            for (int j=0;j<m; j++){
                scoreArray[i][j] = random.nextInt(100);
            }
        }
    }
}
