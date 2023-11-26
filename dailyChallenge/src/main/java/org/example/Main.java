package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] mat={{0,0,1},{1,1,1},{1,0,1}};
        Main m=new Main();
        m.largestSubmatrix(mat);
    }
    //1727. Largest Submatrix With Rearrangements
    public int largestSubmatrix(int[][] m) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int[] cur=new int[m[0].length];
        int max=0;
        for(int i=0;i<m.length;i++){
            hm=new HashMap<>();
            for(int j=0;j<m[0].length;j++){
                if(m[i][j]==1){
                    cur[j]++;
                    int temp=hm.getOrDefault(cur[j],0)+1;
                    hm.put(cur[j],temp);
                }
                else{
                    cur[j]=0;
                }
            }
            max=Math.max(max,getMaxPossible(hm));
        }
        return max;
    }
    private int getMaxPossible(HashMap<Integer,Integer> hm){
        ArrayList<Integer> temp = new ArrayList( hm.keySet());
        temp.sort((a, b) -> Integer.compare(b, a));
        int sum=0,max=0;
        for(int i:temp){
            sum+=hm.get(i);
            max=Math.max(sum*i,max);
        }
        return max;
    }
}