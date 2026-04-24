class Solution {
    static class Pair{
        int node;
        int time;
        Pair(int node, int time){
            this.node=node;
            this.time=time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int t[]: times){
            int u=t[0];
            int v=t[1];
            int w=t[2];
            graph.get(u).add(new Pair(v, w));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->a.time-b.time);
        int dist[]=new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;
        pq.offer(new Pair(k, 0));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.node;
            int time=curr.time;
            if(time>dist[node]) continue;

            for(Pair nei: graph.get(node)){
                int v=nei.node;
                int w=nei.time;
                if(dist[v]>time+w){
                    dist[v]=time+w;
                }
                    pq.offer(new Pair(v, dist[v]));
                
            }
        }

        int ans=0;
        for(int i=1; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans, dist[i]); 

        }
        return ans;
    }
}