
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] squares = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);
        long score = 0;
        int n = nums.length;
        int half = n / 2;
        for (int i = half; i < n; i++) {
            score += squares[i];
        }
        for (int i = 0; i < half; i++) {
            score -= squares[i];
        }
        return score;
    }
}
