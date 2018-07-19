package com.data.dataDatail.solutions;

import java.util.*;

public class Solution {

    //这个算法最少枪打是最多的气球
    public int findMinArrowsShot(int[][] point) {
        if (point == null || point.length == 0)
            return 0;
        Arrays.sort(point, new InterValComparetor());
        int ans = 0;
        int lastEnd = point[0][1];
        for (int i = 0; i < point.length; i++) {
            if (point[i][0] > lastEnd) {
                ans++;
                lastEnd = point[i][0];
            }
        }
        return ans;
    }

    public class InterValComparetor implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    }

    //找出数组中长度为k最大平均值
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double l = Integer.MAX_VALUE;
        double r = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            l = Math.min(l, nums[i]);
            r = Math.max(r, nums[i]);
        }
        double[] sumNums = new double[n + 1];
        sumNums[0] = 0;
        while (r - l > 1e-6) {
            double mid = (l + r) / 2;
            for (int i = 0; i < n; i++) {
                sumNums[i + 1] = sumNums[i] + nums[i] - mid;
            }
            double preMin = 0;
            double sumMax = Integer.MIN_VALUE;
            for (int i = k; i <= n; i++) {
                sumMax = Math.max(sumMax, sumNums[i] - preMin);
                preMin = Math.min(preMin, sumNums[i - k + 1]);
            }
            if (sumMax > 0) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }


    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        Map<Integer, Integer>[] map = new Map[A.length];
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                if (Math.abs(A[i] - A[j]) > Integer.MAX_VALUE)
                    continue;
                int d = A[i] - A[j];
                int map_i_d = map[i].getOrDefault(d, 0);
                int map_j_d = map[j].getOrDefault(d, 0);
                map_i_d += map_j_d + 1;
                map[i].put(d, map_i_d);
                System.out.println(d + "---" + map_i_d + "----" + map_j_d);
                ans += map_j_d;
            }
        }

        return ans;
    }

    public int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }

    public int numberOfBoomerangs(int[][] point) {
        if (point == null) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < point.length; i++) {
            Map<Integer, Integer> disCount = new HashMap<>();
            for (int j = 0; i < point.length; i++) {
                if (i == j) continue;
                int distance = getDistance(point[i], point[j]);
                int count = disCount.getOrDefault(distance, 0);
                disCount.put(distance, count + 1);
            }
            for (int count : disCount.values()) {
                ans += count * (count - 1);
            }
        }
        return ans;
    }

    //两个数相加不能用运算符
    public int AaddB(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;

    }

    //计算阶乘尾数有多少人零
    public int trailingZeros(int n) {
        int count = 0;
        int temp = n / 5;
        while (temp != 0) {
            count += temp;
            temp /= 5;
        }
        return count;
    }

    //计算数字n内出现k的次数 （穷举法）
    public int countNum1(int n, int k) {

        int count  = 0 ;
        for(int i = 0;i<=n ; i++){
            int j =i ;
            if(j<10){
                if(j==k)
                    count ++;
            }
            else{
                while (j>0)
                {
                    if(j%10==k) count++;
                j=j/10;
            }
            }

        }
        return count;
    }

    public int countNum2(int n ,int k)
    {
        if(n <10){
            if(k>n)
                return  0 ;
            else
                return  1 ;
        }
        else{
            int flag = 10;
            int flagCount =1 ;
            while (flag <= n/10)
            {
                flag *=10;
                flagCount++;
            }
            int mod = n % flag;  //余数
            int quo = n / flag ; //商 更高位
           int count = quo * (flag/10) * flagCount;
            count += countNum2(mod,k);
            if(k>0)
            {
                if(mod==k) count+=mod+1;
                else if (quo >k ) count +=flag;
            }
            return count;
        }

    }

    public int countNum3(int n,int k)
    {
      int count = 0;
      int x;
      if(k==0 && n ==0 )
          count =  1;
      for(int i =1; (x = n/i)>=1;i*=10)
      {
          int high = x /10;
          if(k==0)
              if(high>0) high --;
          else {
            count ++ ;
            break;
              }
              count +=high*i;
              int current = x%10;
              if(current > k) count +=i;
              if(current == k ) count += n -x*i +1 ;
      }
      return  count ;
    }

    //得到2、3、5、的丑数
   public int  GetUglyNumber_Solution2(int index)
   {
       if(index ==0) return  0;
       int []puglyNumbers = new int[index];
       puglyNumbers[0]=1;
       int nextUglyIndex =1;
       int p2=0,p3=0,p5=0;
       for(int i =1;i<index;i++)
       {
           puglyNumbers[i]=min(min(puglyNumbers[p2]*2,puglyNumbers[p3]*3),min(puglyNumbers[p2]*2,puglyNumbers[p5]*5));
           if(puglyNumbers[i]==puglyNumbers[p2]*2)
               ++p2;
           if(puglyNumbers[i]==puglyNumbers[p3]*3)
               ++p3;
           if(puglyNumbers[i]==puglyNumbers[p5]*5)
               ++p5;
       }
       return puglyNumbers[index-1];

   }

    int min(int a,int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    //快速排序

    public void quickSort(int s[],int l ,int r){
       if(l<r)
       {
           int i = l ; int j =r; int x = s[l];
           while (i<j){
               while (i<j && s[j]>=x)
                   j--;
               if(i<j)
                   s[i++]=s[j];
               while (i<j && s[i]<x)
                   i++;
               if(i<j)
                   s[j--]=s[i];
           }
           s[i]=x;
           quickSort(s,l,i-1);
           quickSort(s,i+1,r);
       }
    }




    public int[] mergeSortedArray(int[] A, int[] B) {

        int a = A.length;
        int b = B.length;
        int C[] = new int[a+b] ;
       for(int i =0;i<b;i++)
       {
           C[i]=B[i];

       }
        for(int i =0;i<a;i++)
        {
            C[b+i]=A[i];

        }

        return C ;
    }

    //字符串的偏移量
    public void rotateString (char [] str , int offset)
    {
        char temp;
     if(str.length==0) return;
     if(offset==0)return;
     int len = str.length;
     for (int i =1;i<=offset%len;i++)
     {
         temp = str[len-1];
         int j  =len-2;
         while (j>=0){
             str[j+1]=str[j];
             j--;
         }
         str[0]=temp;
     }
    }

    public void fizzBuzz (int n )
    {
        for(int i =1;i<=n;i++)
        {
            if(i%3==0&&i%5!=0)
                System.out.println("Fizz");
            else if(i%3!=0 &&i%5==0)
                System.out.println("Buzz");
            else if(i%3==0&&i%5==0)
                System.out.println("Fizz Buzz");
            else
                System.out.println(i);
        }
    }

    //kmp算法的next 数组

    public  void getNext (char [] P ,int [] next){
        int q,k;//q:模版字符串下标；k:最大前后缀长度
        int m = P.length;//模版字符串长度
        next[0] = 0;//模版字符串的第一个字符的最大前后缀长度为0
        for (q = 1,k = 0; q < m; ++q)//for循环，从第二个字符开始，依次计算每一个字符对应的next值
        {
            while(k > 0 && P[q] != P[k])//递归的求出P[0]···P[q]的最大的相同的前后缀长度k
                k = next[k-1];          //不理解没关系看下面的分析，这个while循环是整段代码的精髓所在，确实不好理解
            if (P[q] == P[k])//如果相等，那么最大相同前后缀长度加1
            {
                k++;
            }
            next[q] = k;
            System.out.println(next[q]);
        }
    }

    //二分查找
    public int  binarySearch(int[] nums, int target){
        int pos = -1;
        if (nums == null || nums.length == 0){
            return pos;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low+1<high){
            int mid = (low+high)/2;
            if(target<=nums[mid]){
                high=mid;
            }else{
                low=mid;
            }
        }
        if(nums[low]==target){
            return low;
        }
        else if(nums[high]==target)
            return high;
        else
            return  -1;
    }
 //数组的全排列

    public  void permute(int [] array ,int start){
        if(start==array.length){  // 输出
            System.out.println(Arrays.toString(array));
        }
        else{
            for(int i=start;i<array.length;++i){
              //  if(i==start||array[i]!=array[start])
                if(IsSwap(array, start, i))
                {
                    swap(array,start,i);  //  交换元素
                    permute(array,start+1);  //交换后，再进行全排列算法
                    swap(array,start,i);  //还原成原来的数组，便于下一次的全排列
                }

            }
        }
    }
    private boolean IsSwap(int[] array,int begin,int end){
        for (int i = begin; i < end; i++){
            if(array[i]==array[end])
                return false;
        }
        return true ;
    }


    private void swap(int[] array, int start, int i) {
            int t=array[start];
            array[start]=array[i];
            array[i]=t;
        }

      //求骰子的和
    public List<Map.Entry<Integer,Double>> dicesSum(int n)
    {
        TreeMap<Integer, Double> M = new TreeMap<>();
        double p = 1d/6;
        for(int i = 1; i <= 6; i++) M.put(i, p);
        for(int i =2;i<=n;i++)
            M = helper(M);
        List<Map.Entry<Integer, Double>> ans = new ArrayList<>();
        for(Map.Entry<Integer, Double> e : M.entrySet()) ans.add(e);
        return ans;
    }

    private TreeMap<Integer,Double> helper(TreeMap<Integer,Double> m) {
        TreeMap<Integer, Double> newM = new TreeMap<>();
        double p = 1d / 6;
        for (int i = 1; i <= 6; i++) {
            for (int num : m.keySet()) {
                int key = num + i;

                if (newM.containsKey(key))

                    newM.put(key, newM.get(key) + m.get(num) * p);
                else
                    newM.put(key, m.get(num) * (1d / 6));
            }
        }
        return newM;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
  /*      int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double d = solution.findMaxAverage(nums, k);
        System.out.println(d);*/
        /*int[] A ={2, 4, 6, 8, 10};
        System.out.println(solution.numberOfArithmeticSlices(A));*/
//        int a = 5;
//        int b = 14;
//        System.out.println(solution.AaddB(a, b));
//
//        int n = 1000;
//        System.out.println(solution.trailingZeros(n));
     /*   int n =19;
        System.out.println(solution.countNum1(n,1));
        System.out.println(solution.countNum3(n,0));
*/
       /* int index =9;
        System.out.println(solution.GetUglyNumber_Solution2(index));*/

     /*  int s[]={5,7,6,8,4,3,9};
        solution.quickSort(s,0,6);
        for(int i =0;i<s.length;i++)
        System.out.println(s[i]);*/

    /*    int A[] ={ 1,2,3,4} ; int B[]= {2,4,5,6 };
        int C[] =solution.mergeSortedArray(A,B);
        solution.quickSort(C,0,C.length-1);
        for(int i =0;i<C.length;i++)
            System.out.println(C[i]);*/
       /*  String  a  = "abcdefg"; int offset = 4;
         char[] B = a.toCharArray();
        solution.rotateString(B,offset);
        System.out.println(B);*/
       /* int n =15;
        solution.fizzBuzz(n);*/

        String  a  = "ABCDFABFE" ; int [] next = new int[10];
        char[] B = a.toCharArray();
        solution.getNext(B,next);

        /*int A[] ={1, 2, 2} ; int b =3;
        //System.out.println( solution.binarySearch(A,b));
        solution.permute(A,0);*/

        /*int a =2;
        System.out.println(solution.dicesSum(a));*/
    }
}
