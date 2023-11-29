package org.example;

import java.util.ArrayList;
import java.util.List;

public class HardPractice {
    public static void main(String[] args){
        HardPractice hp=new HardPractice();
        int[] test={1,2,3};
        hp.findPeakElement(test);
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> sol=new ArrayList<>();
        helperNQueen(n,1,new int[n],sol);
        return sol;
    }
    private void helperNQueen(int n, int i, int[] state, List<List<String>> sol){
        if(i>n)
            sol.add(constructNQueen(state));
        for(int j=1;j<=n;j++){
            if(checkNQueen(state,i,j,n))
            {
                state[i-1]=j;
                helperNQueen(n,i+1,state,sol);
                state[i-1]=0;
            }
        }
    }

    private boolean checkNQueen(int[] state, int i, int j, int n) {
        //vertical
        for(int x:state)
            if(x==j)
                return false;
        //diagonal top left
        for(int x=i-1,y=j-1;x!=0 && y!=0;x--,y--)
            if(state[x-1]==y)
                return false;
        //diagonal top right
        for(int x=i-1,y=j+1;x!=0 && y<=n;x--,y++)
            if(state[x-1]==y)
                return false;
        return true;
    }

    private List<String> constructNQueen(int[] state) {
        List<String> sol=new ArrayList<>();
        for(int j:state){
            StringBuilder sb=new StringBuilder();
            for(int i=1;i<=state.length;i++){
                if(i==j)
                    sb.append('Q');
                else
                    sb.append('.');
            }
            sol.add(sb.toString());
        }
        return sol;
    }
    public int totalNQueens(int n) {
        int[] sol=new int[1];
        helperNQueen2(n,1,new int[n],sol);
        return sol[0];
    }
    private void helperNQueen2(int n, int i, int[] state, int[] sol){
        if(i>n)
            sol[0]++;
        for(int j=1;j<=n;j++){
            if(checkNQueen(state,i,j,n))
            {
                state[i-1]=j;
                helperNQueen2(n,i+1,state,sol);
                state[i-1]=0;
            }
        }
    }

    //76. Minimum Window Substring
    public String minWindow(String s, String t) {
        int[] mem=new int[1+'z'-'A'];
        for(char c:t.toCharArray())
            mem[c-'A']++;
        int i=0,j=0;
        int[] cur=new int[1+'z'-'A'];
        int min=Integer.MAX_VALUE;
        int low=0,high=0;
        while(j!=s.length()+1){
            if(match(cur,mem)) {
                if(j-i<min){
                    min=j-i;
                    low=i;
                    high=j;
                }
                cur[s.charAt(i++) - 'A']--;
            }
            else {
                if(j==s.length())
                    break;
                cur[s.charAt(j++) - 'A']++;
            }
        }
        return s.substring(low,high);
    }

    private boolean match(int[] cur, int[] mem) {
        for(int i=0;i<cur.length;i++)
            if(cur[i]<mem[i])
                return false;
        return true;
    }

    //162. Find Peak Element
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+((high-low)/2);
            if(mid==0)
                return nums[0]<nums[1]?1:0;
            if(mid==n-1)
                return nums[n-1]<nums[n-2]?n-2:n-1;
            if(nums[mid]<nums[mid+1])
                low=mid+1;
            else{
                if(nums[mid-1]<nums[mid])
                    return mid;
                else{
                    high=mid-1;
                }
            }
        }
        return 0;
    }
}
