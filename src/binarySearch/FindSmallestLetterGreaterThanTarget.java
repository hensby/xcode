package binarySearch;

public class FindSmallestLetterGreaterThanTarget {

    public static char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] - 'a' <= target - 'a') {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left <= len - 1? letters[left]: letters[0];
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c','f','j'};
        System.out.println(nextGreatestLetter(letters, 'a'));
    }

}
//744. Find Smallest Letter Greater Than Target
//        Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.
//
//        Note that the letters wrap around.
//
//        For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
//
//
//        Example 1:
//
//        Input: letters = ["c","f","j"], target = "a"
//        Output: "c"
//        Example 2:
//
//        Input: letters = ["c","f","j"], target = "c"
//        Output: "f"
//        Example 3:
//
//        Input: letters = ["c","f","j"], target = "d"
//        Output: "f"
//        Example 4:
//
//        Input: letters = ["c","f","j"], target = "g"
//        Output: "j"
//        Example 5:
//
//        Input: letters = ["c","f","j"], target = "j"
//        Output: "c"
//
//
//        Constraints:
//
//        2 <= letters.length <= 104
//        letters[i] is a lowercase English letter.
//        letters is sorted in non-decreasing order.
//        letters contains at least two different characters.
//        target is a lowercase English letter.