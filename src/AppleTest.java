import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//
public class AppleTest {
    public String reserveWordsInSentence(String input) {
        if(input == null || input.length() == 0) return ""; // conner case;
        input = input.trim(); //
        Boolean flag = false;
        if(input.charAt(input.length() - 1) == '.') {
            flag = true;
            input = input.substring(0, input.length() - 1);
        }
        System.out.println(input);
        List<String> wordList = Arrays.asList(input.split("\\s+"));
        List<String> wordListRes = reverse(wordList);
        return flag? String.join(" ", wordListRes) + ".": String.join(" ", wordListRes);
    }

    public List<String> reverse(List<String> wordlist) {
        List<String> reverseList = new ArrayList<String>();
        System.out.println(wordlist.size() - 1); // 4
        for(int i = wordlist.size() - 1; i >= 0; i--) {
            reverseList.add(wordlist.get(i));
        }
        return reverseList;
    }

    public static void main(String[] args) {
        String input = "The dog runs REALLY fast.";
//        String input = "The dog runs REALLY fast";
        AppleTest at = new AppleTest();
        System.out.println(at.reserveWordsInSentence(input));
    }


}
