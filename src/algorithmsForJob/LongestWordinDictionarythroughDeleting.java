package algorithmsForJob;

import java.util.List;

/**
 * @Description
 * LeetCode 524. Longest Word in Dictionary through Deleting (Medium)
 * 题目描述：
 * 删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个
 * 相同长度的结果，返回字典序的最小字符串。
 * example:
 *Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output:
 * "apple"
 *思路简析：
 *若通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列，可以使用双指针来判断一个字符串
 * 是否为另一个字符串的子序列。
 * @Author EricGao
 */
public class LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }
    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
