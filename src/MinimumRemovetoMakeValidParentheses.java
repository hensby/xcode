import java.util.Stack;
// 1249
public class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> bracketIndex = new Stack<>();
        boolean[] invalidIndex = new boolean[s.length()];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            System.out.println(bracketIndex);
            if (s.charAt(i) == '(') {
                bracketIndex.push(i);
                invalidIndex[i] = true;
            }
            if (s.charAt(i) == ')') {
                if (bracketIndex.empty()) {
                    invalidIndex[i] = true;
                } else {
                    invalidIndex[bracketIndex.pop()] = false;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndex[i]) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MinimumRemovetoMakeValidParentheses minRemoveToMakeValid = new MinimumRemovetoMakeValidParentheses();
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid.minRemoveToMakeValid(s));
    }
}
