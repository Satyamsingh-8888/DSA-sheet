class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int cx=center[0];
        int cy=center[1];
        int maxquality=-1;
        int bestx=-1;
        int besty=-1;

        for(int i=0; i<towers.length; i++){
            int x=towers[i][0];
            int y=towers[i][1];
            int quality=towers[i][2];

            int dist=Math.abs(x-cx)+Math.abs(y-cy);
            if(dist<=radius){
                if(quality>maxquality||
                  (quality==maxquality && 
                  (x<bestx||(x==bestx && y<besty)))){

                    maxquality=quality;
                    bestx=x;
                    besty=y;
                  }
            }
        }
        if(maxquality==-1){
            return new int[]{-1, -1};
        }
        return new int[]{bestx, besty};
    }
}