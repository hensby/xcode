public class getMinDiff {
    public static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int getMaxDiff(Point[] points) {
        int minIndex = 0, maxDiff = 0;
        for(int i = 0; i < points.length; i++) {
            if(points[i].y < points[minIndex].y) {
                minIndex = i;
            }
            maxDiff = Math.max(maxDiff, points[i].y - points[minIndex].y);
        }
        return maxDiff;
    }
}
