package stringAndBucket;

public class CompressMassages {
    public static String compress(String input) {
        if(input == null || input.length() == 0) return "";
        int len = input.length();
        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        while(right <= len) {
            System.out.println(left);
            if(right == len || input.charAt(right) != input.charAt(left)) {
                if(right - left > 2) {
                    sb.append(right - left);
                    sb.append("x");
                    sb.append(input.charAt(left));
                } else {
                    for (int j = left; j < right; j++) {
                        sb.append(input.charAt(left));
                    }
                }
                left = right;
            }
            right++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress(""));
    }
//6.	You need to compress a message. The message is in the form of "AAABBCCCCAAAA". A
//    condensed message can be in the form of 5xA where 5 denotes the frequency and A
//    denotes the letter. Write the compressor method.
//    AAAABBBBCCCCAAAA -> 4xA4xB4xC4xA
//    AAABBCCCCAAAA -> 3xABB4xC4xA

}


