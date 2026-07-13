class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        solve(1, n, k, new ArrayList<>());
        return res;
    }

    public void solve(int start, int n, int k, List<Integer> temp) {

        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n; i++) {
            temp.add(i);

            solve(i + 1, n, k - 1, temp);

            temp.remove(temp.size() - 1);
        }
    }
}