package com.data.dataDatail.solutions;

import java.util.*;

/**
 * @Auther: ljh
 * @Date: 2018/11/30 16:21
 * @Description:   插入区间
 */
public class solution30 {

    public static void main(String[] args) {
        Interval interval1 = new Interval(1,5);
        Interval interval2 = new Interval(7,8);
        Interval interval4 = new Interval(10,13);
        List<Interval> interva = new ArrayList<>();
        interva.add(interval1);
        interva.add(interval2);
        interva.add(interval4);
        Interval interval3 = new Interval(6,6);
       // List<Interval> list =  insert(interva,interval3);
        List<Interval> list =  insert2(interva,interval3);
        for (Interval inter:list
             ) {
            System.out.println(inter);
        }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        List<Interval> intervalList= new ArrayList<>();
        // Insert (1, 2) into [(3,4), (5,9)], we get [(1, 2) ,(3,4), (5,9)]

       // Insert (2, 5) into [(1,2), (5,9)], we get [(1,9)].

      //  Insert (3, 4) into [(1,2), (5,9)], we get [(1,2), (3,4), (5,9)].
        if(intervals.size()==0)
            return Arrays.asList(newInterval);
        Interval pre = newInterval;
        Interval after = intervals.get(0);
        int i = 0;
        while (i<intervals.size()){
            List<Interval> merger = mergeInterval(pre,after);
            if(merger.size()==1){
                pre.start = merger.get(0).start;
                pre.end = merger.get(0).end;
                if(i+1 == intervals.size()) {
                    intervalList.add(pre);
                    break;
                }
               after = intervals.get(++i);

            }
            else if(merger.size()==2){
                intervalList.add(merger.get(0));
                pre = merger.get(1);
                if(i+1 == intervals.size()) {
                    intervalList.add(merger.get(1));
                    break;
                }
               after = intervals.get(++i);

            }

        }
        return  intervalList;
    }




    public static List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        // write your code here
        List<Interval> intervalList= new ArrayList<>();
        if(intervals!=null){
            for (Interval interval:intervals) {
                if(newInterval ==null || interval.end <newInterval.start){
                    intervalList.add(interval);
                }
                else if(interval.start>newInterval.end){
                    intervalList.add(newInterval);
                    intervalList.add(interval);
                    newInterval =null;
                }
                else{
                    newInterval.start = Math.min(newInterval.start, interval.start);
                    newInterval.end = Math.max(newInterval.end, interval.end);
                }
            }
            if(newInterval!=null){
                intervalList.add(newInterval);
            }
            return  intervalList;
        }







        return  intervalList;
    }








    public static List<Interval> mergeInterval(Interval pre,Interval after){
    //没有交集
    if(pre.start>after.end)
        return Arrays.asList(after,pre);
    if(pre.end<after.start)
        return Arrays.asList(pre,after);
    //有交集  (2, 5) into [(1,2), (5,9)  ->[(1,9)]
    int min  = pre.start >=after.start ? after.start:pre.start;
    int max  = pre.end >=after.end ? pre.end:after.end;
    return Arrays.asList(new Interval(min,max));
}

    public static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "("+start+","+end+")";
        }
    }

}

