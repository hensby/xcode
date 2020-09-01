public class MinimumSwapsforBracketBalancing {
    // Java Program to count swaps required to balance string

        public static int minSwap(String s) {
            int left = 0, right = 0, count = 0 ,isBalance = 0;
            // left ,right are the count of [ and ]
            // count is result, isBalance is the different between left and right.
            char[] chars = s.toCharArray();
            for(int i =0; i< chars.length; i++) {
                if(chars[i] == '[') {
                    left++;
                    System.out.println(isBalance);
                    if(isBalance > 0) {  // means ] is more than [
                        count += isBalance;
                        isBalance--;
                    }
                } else if(chars[i] == ']' ) {
                    right++;
                    isBalance = (right-left);
                }
            }
            return count;
        }

        // Driver code
        public static void main(String args[])
        {
            String s = "[]][][";
//            System.out.println(minSwap(s) );
//
//            s = "[[][]]";
//            System.out.println(minSwap(s) );

            s = "]]][[[";
            System.out.println(minSwap(s) );


        }
    }
// This code is contributed by Janmejaya Das.

