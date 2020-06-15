import java.util.ArrayList;
import java.util.List;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
            System.out.println(peak + " " + valley);
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] stocks = new int[] {1, 7, 5, 3, 6, 4};
        BestTimetoBuyandSellStock stock = new BestTimetoBuyandSellStock();
        System.out.println(stock.maxProfit(stocks));
    }
}
//  [7,1,5,3,6,4]
