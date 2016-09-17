package leetcode;

/**
 * Created by heifrank on 16/9/17.
 */
public class P4 {
    private int[] nums1;
    private int[] nums2;

    private double findk(int x1, int l1, int x2, int l2, int k) {
        if(l1 == 0) return nums2[x2 + k - 1];
        if(l2 == 0) return nums1[x1 + k - 1];
        if(l1 + l2 == k) {
            return Math.max(nums1[x1 + l1 - 1], nums2[x2 + l2 - 1]);
        }
        int p1 = x1 + l1 / 2, p2 = x2 + l2 / 2;
        int cnt = p1 - x1 + p2 - x2 + 1;
        if(cnt < k) {
            if(nums1[p1] < nums2[p2]) return findk(p1 + 1, l1 - p1 + x1 - 1, x2, l2, k - p1 + x1 - 1);
            else return findk(x1, l1, p2 + 1, l2 - p2 + x2 - 1, k - p2 + x2 - 1);
        } else {
            if(nums1[p1] < nums2[p2]) return findk(x1, l1, x2, p2 - x2, k);
            else return findk(x1, p1 - x1, x2, l2, k);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        int s1 = nums1.length, s2 = nums2.length;
        int sz = s1 + s2;
        if(sz == 0) {
            return 0.0;
        } else if((sz & 1) == 1) {
            return findk(0, s1, 0, s2, (sz + 1) / 2);
        } else {
            return (findk(0, s1, 0, s2, sz / 2)
                    + findk(0, s1, 0, s2, sz / 2 + 1)) / 2;
        }
    }

//    public static void main(String[] args) {
//        int[] nums1 = {1, 2};
//        int[] nums2 = {3, 4};
//        P4 p4 = new P4();
//        System.out.println(p4.findMedianSortedArrays(nums1, nums2));
//    }
}
