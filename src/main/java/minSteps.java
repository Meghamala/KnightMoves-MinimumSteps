import java.util.Arrays;

public class minSteps {
    public static int minStepsToReachTarget(int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, 1000);

        dp[1] = 0;

        for (int i = 2; i <= T; i++) {
            if (i%2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // Multiply by 2
            }
            if (i - 5 >= 1) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1); // Increment by 5
            }
            if (i - 7 >= 1) {
                dp[i] = Math.min(dp[i], dp[i - 7] + 1); // Increment by 7
            }
            if (i + 1 <= T) {
                dp[i] = Math.min(dp[i], dp[i + 1] + 1); // Decrement by 1
            }
        }

        return dp[T];
    }

    public static void main(String[] args) {
        int target = 11; // Change this to the desired target value
        int minSteps = minStepsToReachTarget(target);
        System.out.println("Minimum steps to reach " + target + " from x=1: " + minSteps);
    }
}
