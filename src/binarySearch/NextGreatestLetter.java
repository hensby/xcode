package binarySearch;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h) {

            int m = l + (h - l) / 2;
            System.out.println(l + " " + h + " " + letters[m]);
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }

    public char nextGreatestLetter1(char[] letters, char target) {
        if (letters == null || letters.length == 0) return ' ';
        int len = letters.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            System.out.println(left + " " + right + " " + letters[mid]);
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return letters[left];
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'g', 'h', 'j'};
        char target = 'd';
        NextGreatestLetter n = new NextGreatestLetter();
        System.out.println(n.nextGreatestLetter1(letters, target));
        System.out.println(n.nextGreatestLetter(letters, target));
    }
}
