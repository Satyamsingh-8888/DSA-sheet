class Solution {
    static class Pair{
        int node;
        int cost;
        int stops;
        Pair(int node, int cost, int stops){
            this.node=node;
            this.cost=cost;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int [] f: flights){
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->a.cost-b.cost);
        pq.offer(new Pair(src, 0, 0));
        int bestdist[]=new int[n];
        Arrays.fill(bestdist, Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.node;
            int cost=curr.cost;
            int stops=curr.stops;
            if(node==dst) return cost;
            if(stops>k) continue;
            if(stops>=bestdist[node]) continue;
            bestdist[node]=stops;

            for(int []nei: graph.get(node)){
                int v=nei[0];
                int w=nei[1];
                pq.offer(new Pair(v, cost+w, stops+1));
            }
        }
        return -1;
    }
}