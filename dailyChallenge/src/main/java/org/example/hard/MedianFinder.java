package org.example.hard;

import java.util.PriorityQueue;

import static java.lang.System.out;


//295. Find Median from Data Stream
class MedianFinder {
    private PriorityQueue<Integer> minQ;
    private PriorityQueue<Integer> maxQ;

    public static void main(String[] args){
        MedianFinder m=new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        out.println(m.findMedian());
        m.addNum(3);
        m.addNum(2);
        m.addNum(7);
        m.addNum(5);
        out.println(m.findMedian());
    }
    public MedianFinder() {
        minQ=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        maxQ=new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(minQ.isEmpty()) {
            minQ.add(num);
            return;
        }
        minQ.add(num);
        if(maxQ.isEmpty()){
            maxQ.add(minQ.poll());
            return;
        }
        if(maxQ.peek()<minQ.peek())
            minQ.add(maxQ.poll());
        while(minQ.size()-maxQ.size()>1)
            maxQ.add(minQ.poll());
    }

    public double findMedian() {
        if(minQ.isEmpty())
            return 0;
        if(minQ.size()== maxQ.size())
            return (minQ.peek()+maxQ.peek()+0.0d)/2d;
        return minQ.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */