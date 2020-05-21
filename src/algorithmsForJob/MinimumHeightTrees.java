package algorithmsForJob;

import java.util.*;

/**
 * @Description
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，
 * 具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 *
 * 格式
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
 *
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 * Example 1 :
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * Output: [1]
 *
 * Example 2 :
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 *
 * Output: [3, 4]
 *
 * 解法描述：
 * 这道题虽说是树但其实本质是想考察图的知识，这道题刚开始在拿到的时候，最先想到的解法是遍历的点，
 * 以每个点都当做根节点，算出高度，然后找出最小的，推崇的方法是一个类似剥洋葱的方法，就是一层一层的褪去叶节点，
 * 最后剩下的一个或两个节点就是
 * 要求的最小高度树的根节点，这种思路非常的巧妙，而且实现起来也不难，跟之前那到课程清单的题一样，
 * 需要建立一个图g，是一个二维数组，其中g[i]是一个一维数组，保存了i节点可以到达的所有节点。
 * 开始将所有只有一个连接边的节点(叶节点)都存入到一个队列queue中，然后遍历每一个叶节点，
 * 通过图来找到和其相连的节点，并且在其相连节点的集合中将该叶节点删去，如果删完后此节点也也变成一个叶节点了，
 * 加入队列中，再下一轮删除。那么删到什么时候呢，当节点数小于等于2时候停止，此时剩下的一个或两个节点就是
 * 要求的最小高度树的根节点啦，参见代码如下：
 * @Author EricGao
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        List<Integer> leaves = new ArrayList<>();
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; ++i) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int t = adj.get(i).iterator().next();
                adj.get(t).remove(i);
                if (adj.get(t).size() == 1) {
                    newLeaves.add(t);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
