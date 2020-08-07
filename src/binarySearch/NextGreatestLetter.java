package binarySearch;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h) {

            int m = l + (h - l) / 2;
            System.out.println(l + " " + h + " " + m);
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'g','h','j'};
        char target = 'd';
        NextGreatestLetter n = new NextGreatestLetter();
        System.out.println(n.nextGreatestLetter(letters,target));
    }
}
