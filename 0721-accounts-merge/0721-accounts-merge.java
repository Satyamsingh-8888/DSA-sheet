class Solution {

    int[] parent;

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Integer> map = new HashMap<>();
        Map<String, String> nameMap = new HashMap<>();

        int id = 0;

        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                if (!map.containsKey(email)) {
                    map.put(email, id++);
                    nameMap.put(email, name);
                }
            }
        }

        parent = new int[id];
        for (int i = 0; i < id; i++) parent[i] = i;

        for (List<String> acc : accounts) {
            int first = map.get(acc.get(1));
            for (int i = 2; i < acc.size(); i++) {
                union(first, map.get(acc.get(i)));
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();

        for (String email : map.keySet()) {
            int root = find(map.get(email));
            groups.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> emails : groups.values()) {
            Collections.sort(emails);
            List<String> temp = new ArrayList<>();
            temp.add(nameMap.get(emails.get(0)));
            temp.addAll(emails);
            result.add(temp);
        }

        return result;
    }
}