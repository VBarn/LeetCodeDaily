package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] mat={{0,0,1},{1,1,1},{1,0,1}};
        Main m=new Main();
        m.numberOfWays("SSPPSPSPPPSPPS");
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

    //935. Knight Dialer
    public int knightDialer(int n) {
        int[][] hm={{4,6},{8,6},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        int[] start={0,1,2,3,4,5,6,7,8,9};
        int[][] memo=new int[n][10];
        return getPossibilities(hm,start,n,0,memo);
    }

    private int getPossibilities(int[][] hm, int[] start, int n, int i,int[][] memo) {
        if(i==n)
            return 1;
        long sum=0l;
        for(int x:start){
            if(memo[i][x]!=0){
                sum+=memo[i][x];
            }
            else{
                memo[i][x]=getPossibilities(hm,hm[x],n,i+1,memo);
                sum+=memo[i][x];
            }
            sum=sum%1000000007;
        }
        return (int)sum;
    }

    //2147. Number of ways to Divide a Long Corridor
    public int numberOfWays(String cor) {
        int n=cor.length();
        long sol=1;
        int plant=0,s=1;
        int i=0;
        while(i<n && cor.charAt(i)!='S')
            i++;
        if(i==n)
            return 0;
        i++;
        plant++;
        for(;i<cor.length();i++){
            char cur=cor.charAt(i);
            if(cur=='S') {
                plant++;
                if (plant % 2 != 0) {
                    sol *= s;
                    sol = sol % 1000000007;
                }
                s=1;
            }
            else{
                s++;
            }
        }
        if(plant%2==0)
            return (int)sol;
        return 0;
    }
}