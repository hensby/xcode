import java.util.*;

public class ReorganizeString {
    public String reorganizeString1(String S) {
        int N = S.length();
        int[] counts = new int[26];
        for (char c: S.toCharArray()) counts[c-'a'] += 100;
        for (int i = 0; i < 26; ++i) counts[i] += i;
        System.out.println(Arrays.toString(counts));
        //Encoded counts[i] = 100*(actual count) + (i)
        Arrays.sort(counts);
        System.out.println(Arrays.toString(counts));
        char[] ans = new char[N];
        int t = 1;
        for (int code: counts) {
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (N+1) / 2) return "";
            for (int i = 0; i < ct; ++i) {
                if (t >= N) t = 0;
                ans[t] = ch;
                t += 2;
            }
        }
        return String.valueOf(ans);
    }

    public String reorganizeString(String S) {
        if(S.isEmpty()) return "";
        HashMap<Character, Integer> hm=new HashMap<>();
        for(int i=0;i<S.length();i++){
            hm.put(S.charAt(i), hm.getOrDefault(S.charAt(i),0)+1);
        }
        List<Character> list=new ArrayList<>(hm.keySet());
        System.out.println(list);
        Collections.sort(list,(c1, c2)->hm.get(c2)-hm.get(c1));
        System.out.println(list);
        char[] res=new char[S.length()];
        int index=0;
        for(int i=0;i<list.size();i++){
            if(i==0 && hm.get(list.get(i))>(S.length()+1)/2) return "";
            int num=hm.get(list.get(i));
            while(num-->0){
                System.out.println(res);
                if(index>=S.length()) index=1;
                res[index]=list.get(i);
                index+=2;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:res){
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "aab";
        ReorganizeString r = new ReorganizeString();
        System.out.println(r.reorganizeString(S));
    }
}
