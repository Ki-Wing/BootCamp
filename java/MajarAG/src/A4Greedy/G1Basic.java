package A4Greedy;

public class G1Basic {
    public static void main(String[] args) {
        int totalAmount = 99;
        int[] coins = {20, 10, 5, 1};
        int count = 0;

        for (int coin : coins) {
            count += totalAmount / coin;
            totalAmount %= coin;
        }

        System.out.println("총: " + count);
    }
}
