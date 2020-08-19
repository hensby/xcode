package Baidu;

import java.util.ArrayList;
import java.util.List;

public class Baidu_code_2 {

//    String s  cn char en word

    public List<String> splitString(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res; //con case
        char[] sCharList = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c: sCharList) {
            if(c - 'a' > 0 && c - 'a' < 52) {
                sb.append(c);
            } else if(c == ' ') {
                res.add(sb.toString());
                sb = new StringBuilder();
            } else {
                res.add(String.valueOf(c));
                sb = new StringBuilder();
            }
        }
        return res;
    }

    public void quickSort(int[] array, int l, int r) {
        int i = l, j = r, stand = array[i];
        if(l < r) {
            while(l < r) {
                while(l < r && array[r] > stand) {
                    r--;
                }
                swap(array, l, r);
                while(l < r && array[r] < stand) {
                    l++;
                }
                swap(array,l,r);
            }
            quickSort(array, i, l - 1);
            quickSort(array,l + 1, j);
        }
    }

    public void swap(int[] array, int l, int r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }
}
