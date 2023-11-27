package org.example;

import java.util.ArrayList;
import java.util.List;

public class HardPractice {
    public static void main(String[] args){
        HardPractice hp=new HardPractice();
        hp.solveNQueens(4);
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
}
