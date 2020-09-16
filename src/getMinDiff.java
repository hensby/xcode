public class getMinDiff {
    public static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int getMaxDiff(Point[] points) {
        int minIndex = 0, maxDiff = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i].y < points[minIndex].y) {
                minIndex = i;
            }
            maxDiff = Math.max(maxDiff, points[i].y - points[minIndex].y);
        }
        return maxDiff;
    }
}



//Point i1234 int. x
//
//int yi
//
//5输入 Points[],ⅹ严格单调递增排序。求 Points中的两个点 PointMan和 PointMan,满足如下条件6如 PoTntMax PointMin. y=. MAX(Point_my- Point_n y)I. Point_mx>Point_nx;
//
//8例子:输入
//
//9A={0,1},B=[1,2},C={2,3}
//
//10
//
//11
//
//12这组输入中符合条件的减法
//
//13
//
//14 Cy-A.y, C.y-B y, B y-A.y
//
//15
//
//16其中C.y-A.y的值最大,所以 PointMan=C, PoIntMan=A
//
//17
//
//18时间复杂度要小于0(NA2)