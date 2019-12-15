package algorithmsForJob;

import java.util.Scanner;

import static java.lang.System.out;

public class revert_sort
{
    static void operateSort(int n, int[] a)
    {
        int[] b = new int[n];
        int b_length = 0;
        for(int i=0;i<n; i++)
        {
            b[i]=a[i];
            b_length += 1;
            if(b_length > 1)
            {
                for (int j=0,k=b_length; j<b_length; j++,k--)
                {
                    int temp = b[j];
                    b[j] = b[k-1];
                    b[k-1] = temp;
                }
            }
        }
        for (int i=0;i<b_length;i++)
        {
            out.println(b[i]+' ');
        }
    }

    public static void main(String[] args)
    {
        System.out.println("please a number!");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++)
        {
            a[i] = input.nextInt();
        }
        operateSort(n, a);
    }
}
