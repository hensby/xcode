package Amazon_onsite;

public class CompareVersionNumbers {

    public int compareVersion(String v1, String v2) {
        int i = 0, j = 0;
        int n = v1.length(), m = v2.length();
        while(i < n || j < m)
        {
            int num1 = 0, num2 = 0;
            while(i < n && v1.charAt(i) != '.') num1 = num1 * 10 + v1.charAt(i++) - '0';
            while(j < m && v2.charAt(j) != '.') num2 = num2 * 10 + v2.charAt(j++) - '0';
            if(num1 > num2) return 1;
            else if( num1 < num2) return -1;
            i++; j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.01", version2 = "1.001";
        CompareVersionNumbers c = new CompareVersionNumbers();
        System.out.println(c.compareVersion(version1, version2));
    }
}
