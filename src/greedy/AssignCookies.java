package greedy;

import java.util.Arrays;

public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        int res = 0;
        if (g == null || g.length == 0 || s == null || s.length == 0) return res;
        Arrays.sort(g);
        Arrays.sort(s);
        int index1 = 0, index2 = 0;
        while (index1 < g.length && index2 < s.length) {
            if (g[index1] <= s[index2]) {
                res++;
                index1++;
            }
            index2++;
        }
        return res;
    }

    public static int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, index = 0;
        for(int gi: g) {
            while(index < s.length) {
                if(s[index] >= gi) {
                    index++;
                    res++;
                    break;
                }
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1,2}, s = new int[] {1,2,3};
        System.out.println(findContentChildren(g, s));
    }
}
//455. Assign Cookies
//        Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
//
//        Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
//
//
//
//        Example 1:
//
//        Input: g = [1,2,3], s = [1,1]
//        Output: 1
//        Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
//        And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
//        You need to output 1.
//        Example 2:
//
//        Input: g = [1,2], s = [1,2,3]
//        Output: 2
//        Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
//        You have 3 cookies and their sizes are big enough to gratify all of the children,
//        You need to output 2.
//
//
//        Constraints:
//
//        1 <= g.length <= 3 * 104
//        0 <= s.length <= 3 * 104
//        1 <= g[i], s[j] <= 231 - 1
