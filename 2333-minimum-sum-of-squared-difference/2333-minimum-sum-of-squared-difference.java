
import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        int[] freq = new int[100001];

        int max = 0;

        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
            max = Math.max(max, d);
        }

        long k = (long) k1 + k2;

        for (int d = max; d > 0 && k > 0; d--) {
            int count = freq[d];
            long use = Math.min(k, (long) count);

            freq[d] -= (int) use;
            freq[d - 1] += (int) use;
            k -= use;
        }

        long ans = 0;

        for (int d = 1; d <= 100000; d++) {
            ans += (long) d * d * freq[d];
        }

        return ans;
    }
}
