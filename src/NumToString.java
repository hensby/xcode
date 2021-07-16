public class NumToString {
//    145215678914    450
//    one billion four hundred fifty two million one hundred fifty six thousand seven hundred eighty nine
    public String numToString(Long input) {
        if(input == 0) return "zero";
        String result ="";
        if(input < 0) {
            result += "minus";
            input = input * -1;
        }
        int i = 0;
        while(0 < input) {
            if(0 != input % 1000) {
                result = numToStringHelper(input % 1000) + More1000[i] + " " + result;
            }
            input /= 1000;
            i++;
        }
        return result;
    }

    public String numToStringHelper(Long num) {
        if(num == 0) {
            return "";
        } else if(20 > num) {
            return Less20[Math.toIntExact(num)];
        } else if(100 > num) {
            return Ten[(int) (num / 10)] + " " + numToStringHelper(num % 10);
        } else {
            return Less20[(int) (num / 100)] + " hundred " + numToStringHelper(num % 100);
        }
    }

    public static final String[] Less20 = {"","one","two","three","four","five","six","seven","eight","night","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    public static final String[] Ten = {"","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    public static final String[] More1000 = {"","thousand","million","billion"};


    public static void main(String[] args) {
        Long input = 145215678914L;
        NumToString numToString = new NumToString();
        System.out.println(numToString.numToString(input));

    }
}
