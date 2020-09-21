package robinhood;

public class MoveDiagonally {
    public static int movingDiagonally(int n, int m, int x1, int y1, int x2, int y2) {
        if(x1 == x2 && y1 == y2) return 0;
        return movingDiagonallyHelper(n, m, x1, y1, x2, y2, 1, 1, 0);
    }

    public static int movingDiagonallyHelper(int n, int m, int x1, int y1, int x2, int y2, int dir1, int dir2, int res) {
        System.out.println("x1  " + x1 + "  y1  " + y1);
        if(x1 == x2 && y1 == y2) return res;
        int flag = isVaild(m, n, x1 + dir1, y1 + dir2);
        if(flag == 0) return movingDiagonallyHelper(n, m, x1 + dir1, y1 + dir2, x2, y2, dir1, dir2, res+1);
        else if(flag == 1) return movingDiagonallyHelper(n, m, x1 - dir1, y1 - dir2, x2, y2, dir1 * -1, dir2, res); // x out
        else if(flag == 3) return movingDiagonallyHelper(n, m, x1 - dir1, y1 - dir2, x2, y2, dir1, dir2 * -1, res); // y out
        else if(flag == 2) return movingDiagonallyHelper(n, m, x1 - dir1, y1 - dir2, x2, y2,dir1 * -1, dir2 * -1, res); // corner
        return res;
    }

    public static int isVaild(int n, int m, int x, int y) {
        if(x > n || x < 0) { // x out
            if(y >= 0 && y < m) {
                return 1;
            } else return 2;
        }
        if(y < 0 || y > m) {
            if(x >= 0 && y < n) {
                return 3;
            }
            else return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(movingDiagonally(5, 5, 2, 1, 1, 0));

        System.out.println(isVaild(5,5,-1,-1));
    }
}
