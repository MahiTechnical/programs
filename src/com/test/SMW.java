package com.test;


import java.util.Arrays;

class SMWindow {
    /****
     *
     * Complexity Analysis
     *
     * Time complexity : \mathcal{O}(N k)O(Nk), where N is number of elements in the array.
     *
     * Space complexity : \mathcal{O}(N - k + 1)O(N−k+1) for an output array.
     *
     * @param args
     */
    public static void main(String[] args) {
        SMWindow swm = new SMWindow();
        int []x = new int[]{1,3,-1,-3,5,3,6,7};
        int[] output = swm.getMaxWindow( x,3);
        System.out.println(Arrays.toString(Arrays.stream(output).toArray()));

    }

    private int[] getMaxWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new  int[n-k+1];

        if(n*k ==0) return new int[0];

        for (int i=0;i<n-k+1;i++){
            int max= Integer.MIN_VALUE;
            for (int j=i;j<i+k;j++){
               max = Math.max(max,nums[j]);
               output[i] = max;
            }
        }



        return output;
    }
}
