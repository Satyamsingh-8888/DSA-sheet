class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans=Integer.MAX_VALUE;
        for(int i=0; i <landStartTime.length; i++){
            int finishland=landStartTime[i]+landDuration[i];
            for(int j=0; j<waterStartTime.length; j++){
               int waters=Math.max(finishland, waterStartTime[j]);
               int totaltime=waters+waterDuration[j];
               ans=Math.min(ans, totaltime);
            }
        }

        for(int i=0; i<waterStartTime.length; i++){
            int finishwater=waterStartTime[i]+waterDuration[i];
            for(int j=0; j<landStartTime.length; j++){
                int lands=Math.max(finishwater, landStartTime[j]);
                int totaltime=lands+landDuration[j];
                ans=Math.min(ans, totaltime);
            }
        }

        return ans;
    }
}