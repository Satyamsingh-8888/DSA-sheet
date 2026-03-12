class Solution {

    class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int i, int val) {
            i++;
            while (i <= n) {
                tree[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            i++;
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {

        int n = nums1.length;

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = pos[nums1[i]];
        }

        Fenwick fenwick = new Fenwick(n);

        long ans = 0;

        for (int i = 0; i < n; i++) {

            int current = arr[i];

            long left = fenwick.query(current - 1);

            long totalProcessed = i;
            long greaterLeft = fenwick.query(n - 1) - fenwick.query(current);
            long right = (n - current - 1) - greaterLeft;

            ans += left * right;

            fenwick.update(current, 1);
        }

        return ans;
    }
}