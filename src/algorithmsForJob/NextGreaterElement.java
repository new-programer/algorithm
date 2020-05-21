package algorithmsForJob;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description 题目：
 *
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * 示例 1:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
 *     对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 注意:
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 *
 * 思路：
 * 利用栈将nums2中下一个更大的元素建立一个映射关系，然后 遍历nums1就可以得到结果了
 * 利用栈找到下一个更大元素模拟过程:开始进入一个4，入栈，然后再进入一个2，比4小，所以不是更的元素，还要入栈，在进入一个5,比栈顶的2大，
 * 所以 2M的下一个更大的元素是5，继续判断5比栈顶的4大，所以4的下一个更大的元素是5，栈为空，执行下面，5入栈，重复之前的操作，
 * 最后栈中会剩下一些没有下一个更大元素的，置定为-1即可。
 * @Author EricGao
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] result=new int[nums1.length];
        //找到下一个最大的元素，建立映射关系
        for(int x:nums2) {
            while(!stack.empty()&&stack.peek()<x) {
                map.put(stack.pop(),x);
            }
            stack.push(x);
        }
        //栈中剩余的内容是没有下一个最大元素的，将他们的值置定为题目要求的-1
        while(!stack.empty()) {
            map.put(stack.pop(),-1);
        }
        //根据映射关系计算结果
        for(int i=0;i<nums1.length;i++) {
            result[i]=map.get(nums1[i]);
        }
        return result;
    }
}
