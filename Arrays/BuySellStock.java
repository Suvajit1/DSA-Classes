package Arrays;

public class BuySellStock {
    public static int stock(int []prices){
        int buyingPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++){
            // profit
            if(prices[i] > buyingPrice){ // today's profit > 0
                maxProfit = Math.max(maxProfit, prices[i]-buyingPrice);
            }else{ // today's profit < 0
                buyingPrice = prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[] = {7, 6, 5, 4, 3, 4};
        System.out.println(stock(prices)); // 0
    }
}
