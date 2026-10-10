import java.util.Arrays;

class Solution {
public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
int n = nums1.length;
long k = (long) k1 + k2;

    int[] diff = new int[n];
    int max = 0;

    for (int i = 0; i < n; i++) {
        diff[i] = Math.abs(nums1[i] - nums2[i]);
        max = Math.max(max, diff[i]);
    }

    if (k == 0) {
        return sumSquares(diff);
    }

    long total = 0;
    for (int d : diff) {
        total += d;
    }

    if (k >= total) {
        return 0;
    }

    int left = 0;
    int right = max;

    while (left < right) {
        int mid = left + (right - left) / 2;
        long required = 0;

        for (int d : diff) {
            if (d > mid) {
                required += d - mid;
            }
        }

        if (required <= k) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    int level = left;
    long remaining = k;

    for (int i = 0; i < n; i++) {
        if (diff[i] > level) {
            remaining -= diff[i] - level;
            diff[i] = level;
        }
    }

    for (int i = 0; i < n && remaining > 0; i++) {
        if (diff[i] == level && level > 0) {
            diff[i]--;
            remaining--;
        }
    }

    return sumSquares(diff);
}

private long sumSquares(int[] diff) {
    long sum = 0;

    for (int d : diff) {
        sum += (long) d * d;
    }

    return sum;
}

}
