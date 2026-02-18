import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        
        long MOD = 1_000_000_007;
        
        List<List<long[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            
            adj.get(u).add(new long[]{v, w});
            adj.get(v).add(new long[]{u, w});
        }
        
        long[] dist = new long[n];
        long[] ways = new long[n];
        
        Arrays.fill(dist, Long.MAX_VALUE);
        
        dist[0] = 0;
        ways[0] = 1;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );
        
        pq.add(new long[]{0, 0});
        
        while(!pq.isEmpty()) {
            
            long[] curr = pq.poll();
            long currDist = curr[0];
            int node = (int) curr[1];
            
            if(currDist > dist[node]) continue;
            
            for(long[] neighbor : adj.get(node)) {
                
                int nextNode = (int) neighbor[0];
                long weight = neighbor[1];
                
                long newDist = currDist + weight;
                
                if(newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    ways[nextNode] = ways[node];
                    pq.add(new long[]{newDist, nextNode});
                }
                
                else if(newDist == dist[nextNode]) {
                    ways[nextNode] = 
                        (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        
        return (int)(ways[n - 1] % MOD);
    }
}
