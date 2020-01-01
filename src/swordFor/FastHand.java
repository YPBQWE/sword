package swordFor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FastHand {
    // 除法
    public static void printcycle(int a,int b){
       if(a%b == 0)
           System.out.print(a/b);
       else{
           int c = a;
           ArrayList<Integer> list = new ArrayList<>();
           HashMap<Integer,Integer> map = new HashMap<>();
           c= c%b;
           int pos = -1;
           while(c!=0){
               if(map.containsKey(c)){
                   pos = map.get(c);
                   break;
               }else{
                   list.add(c*10/b);
                   map.put(c,map.size());
               }
               c= c*10%b;
           }
           if(pos == -1){
               System.out.print(a/b+".");
               for(int val:list)
                   System.out.print(val);
           }else{
               System.out.print(a/b+".");
               for(int i = 0;i<pos;i++){
                   System.out.print(list.get(i));
               }
               System.out.print("(");
               for(int i = pos;i<list.size();i++){
                   System.out.print(list.get(i));
               }
               System.out.print(")");
           }
       }
    }
    static abstract  class A{

    }
    //回文子串数目
    private static int cnt = 0;

    public static  int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i);     // 奇数长度
            extendSubstrings(s, i, i + 1); // 偶数长度
        }
        return cnt;
    }

    private static void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }

    //善变的同伴
    public class Main {

        public  void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m =  in.nextInt();
            int[][] dp = new int[2][n+1];//只保存上一行和当前行
            int[] sc = new int[n];
            for(int i=0;i<n;i++){
                sc[i]=in.nextInt();
                dp[0][i]=0;
                dp[1][i]=0;
            }
            int rs=0;
            if(m>=n){
                for(int i=0;i<n;i++){
                    if(sc[i]>0){
                        rs+=sc[i];
                    }
                }
                System.out.println(rs);
            }else{
                for(int i=1;i<=m;i++){
                    int pre = dp[i & 1][i - 1] = -999999999;
                    for(int j=i;j<=(i+n-m);j++){
                        pre=Math.max(pre,dp[(i-1)&1][j-1]);
                        dp[i & 1][j]= Math.max(pre,dp[i&1][j-1])+sc[j-1];
                    }
                }
                rs =-999999999;
                int index=m&1;
                for(int i=m;i<=n;i++){
                    rs=Math.max(rs,dp[index][i]);
                }
                System.out.println(rs);
            }
            in.close();
        }
    }

    //爬台阶
    public class Up {
        public  void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();

            String[] nums = s.split(",");
            int len = nums.length;
            int[] cost = new int[len];
            for (int i = 0; i < len; i++) {
                cost[i] = Integer.parseInt(nums[i]);
            }
            int n = minCostClimbingStairs(cost);
            System.out.println(n);
        }

        public  int minCostClimbingStairs(int[] cost) {
            int len = cost.length;
            if (len == 2) {
                return Math.min(cost[0], cost[1]);
            }
            for (int i = 2; i < cost.length; i++) {
                cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
            }
            return Math.min(cost[len - 1], cost[len - 2]);
        }
    }

//魔法深渊
public   class mofa {

    public  void main( ) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] sc = new int[n];
        for(int i=0;i<n;i++){
            sc[i]=in.nextInt();
        }
        int[] dp=new int[1001];
        for(int i=1;i<1001;i++){
            dp[i]=0;
        }
        dp[0]=1;
        int[] byteArray={1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
        for(int i=0;i<1000;i++){
            for(int j=0;j<10 && i>= byteArray[j];j++){
                dp[i]+=dp[i-byteArray[j]];
                dp[i]%=(1000000000 + 3);
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(dp[sc[i]]);
        }
        in.close();
    }
    //最大回文串长度
    private   int maxLen = 0;

    private   String sub = "";
    public   String longestPalindrome(String s) {
         if(s.length() <= 1)
                return s;

            for(int i = 0;i < s.length()-1;i++){

                     findLongestPalindrome(s,i,i);//单核回文

                 findLongestPalindrome(s,i,i+1);//双核回文
          }
         return sub;
  }

    public  void findLongestPalindrome(String s,int low,int high){
        while (low >= 0 && high <= s.length()-1){
           if(s.charAt(low) == s.charAt(high)){
             if(high - low + 1 > maxLen){
                    maxLen = high - low + 1;
                    sub = s.substring(low , high+1);
                }
                    low --;//向两边扩散找当前字符为中心的最大回文子串
                    high ++;
           }
             else
               break;
      }
}

//最长子字符串
public String longestPalindromes(String s)
{
    if (s.equals("")) return "";
    int len = s.length();
    if (len == 1)return s;
    int longest = 1;
    int start=0;
    int [][] dp = new int[len][len];
    for (int i = 0; i < len; i++)
    {
        dp[i][i] = 1;
        if(i<len-1)
        {
            if (s.charAt(i) == s.charAt(i + 1))
            {
                dp[i][i + 1] = 1;
                start=i;
                longest=2;
            }
        }
    }
    for (int l = 3; l <= len; l++)//子串长度
    {
        for (int i = 0; i+l-1 < len; i++)//枚举子串的起始点
        {
            int j=l+i-1;//终点
            if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]==1)
            {
                dp[i][j] = 1;
                start=i;
                longest = l;
            }
        }
    }
    return s.substring(start,longest);
}
//字符串归一
public class StringtoOne {

    public  void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        Map map=new HashMap();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.get(ch)==null){
                map.put(ch,1);
            }else{
                int cnt= (int) map.get(ch);
                map.put(ch,cnt+1);
            }
        }
        for(Object obj : map.entrySet()){
            Map.Entry<String,Integer> entry= (Map.Entry<String, Integer>) obj;
            System.out.print(String.valueOf(entry.getKey())+ entry.getValue());
        }
        in.close();
    }
}

// 数字转成字符串
    public void change(int a){
        if(a<0 || a>99999)
           return ;
        if(a == 0)
        {
           System.out.print("L");

        }
        char arr[] = {'L', 'S', 'B', 'Q', 'W'};
        String res = "";
        boolean flag = false;//判断位上为0的前面是否有值
        //比如101，十位上的0前面有值(即个位上的1) flag = true
        //比如100，十位上的0前面没有值 flag = false
        int i = 0;
        while(a != 0)
        {
            int temp = a%10;
            if(temp != 0)
            {
                flag = true;
                if(i != 0)
                    res = arr[i] + res;
                char c =  (char)temp;
                res = c + res;
            }
            else if(temp == 0 && i!=0 && flag)
            {
                res = arr[0] + res;
                flag = false;
            }
            i++;
            a /= 10;
        }
    }
// 二分法
/*    n,p,h,w = map(int,raw_input().split())
    nums = map(int,raw_input().split())

    def getRowNum(nums,w,s):
    rowNum = 0
            for num in nums:
    rowNum+=num*s/w
    return rowNum

            s = 1
while getRowNum(nums,w,s)<=p*h/s:
    s += 1
    print s-1*/
       /* public int max_people = 5
        int maxGold[max_people][max_n];

         int GetMaxGold(int people, int mineNum){
            int retMaxGold;                            //声明返回的最大金矿数量
            //如果这个问题曾经计算过
           if(maxGold[people][mineNum] != -1){
                    retMaxGold = maxGold[people][mineNum]; //获得保存起来的值
                }else if(mineNum == 0) {                   //如果仅有一个金矿时 [ 对应动态规划中的"边界"]
                    if(people >= peopleNeed[mineNum])      //当给出的人数足够开采这座金矿
                            retMaxGold = gold[mineNum];        //得到的最大值就是这座金矿的金子数
                    else                                   //否则这唯一的一座金矿也不能开采
                        retMaxGold = 0;                    //得到的最大值为 0 个金子
                }else if(people >= peopleNeed[mineNum])    // 如果人够开采这座金矿[对应动态规划中的"最优子结构"]
                {
                    //考虑开采与不开采两种情况，取最大值
                    retMaxGold = max(
                                             GetMaxGold(people - peopleNeed[mineNum],mineNum - 1) + gold[mineNum],
                                             GetMaxGold(people,mineNum - 1)
                                             );
                }else//否则给出的人不够开采这座金矿 [ 对应动态规划中的"最优子结构"]
            {
                    retMaxGold = GetMaxGold(people,mineNum - 1);     //仅考虑不开采的情况
                    maxGold[people][mineNum] = retMaxGold;
                }
            return retMaxGold;
        }*/


    public  void main(String [] args) {
        //读取字符串并转化成转换成数组
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine().toString();
            String[] stringArr = input.split(" ");// 空格拆分
            int[] num = new int[stringArr.length];// 创建整型数组，存储数字
            for (int i = 0; i < num.length; i++) {
                num[i] = Integer.parseInt(stringArr[i]);
            }
            int key = sc.nextInt();// 目标数字
        }
    }


    }
}
