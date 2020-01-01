import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static final int a;
    public Main(){

    }
    static{
        a=1;

    }


    public static String getNChar(String str){
        char [] ch = str.toCharArray();
        int cnt=1;
        StringBuffer sb = new StringBuffer("");
        for(int i  = 0;i<ch.length;i++){
            if(i+1<ch.length){
                if(ch[i]==ch[i+1]){
                    cnt++;
                }else {
                    sb.append(cnt).append(ch[i]);
                    cnt=1;
                }
            }else{
                sb.append(cnt).append(ch[i]);
            }
        }
        return sb.toString();
    }
    public static String  sum(String str){
        char [] ch = str.toCharArray();
        int sum = 0;
        if(ch[0]=='-'){
            sum+=-1*(ch[1]-'0');
        }
        int neg =1;

            if(sum<0){
                    sum=0;
                    for(int i = 0;i<ch.length;i++){
                        if(i%2!=0){
                            sum+=neg*(ch[i]-'0');
                        }else {
                            if(ch[i] =='-')
                                neg= -1;
                            else
                                neg=1;
                        }
                    }

            }else {
                for(int i = 0;i<ch.length;i++){
                    if(i%2==0){
                           sum+=neg*(ch[i]-'0');
                    }else {
                        if(ch[i] =='-')
                            neg= -1;
                        else

                            neg=1;
                    }
                }
            }
            return  Integer.toString(sum);

    }

    public static int NumberOf1(int n) {
        int flag = 1;
        Queue<Integer> queue = new LinkedList<>();

        int cnt = 0;
        while(flag <= n ){
            if((flag&n)!=0 )
                cnt++;
            flag=flag*2;
        }
        String [] str = new String [3];
        Arrays.sort(str,(o1,o2)->(o1+o2).compareTo(o2+o1));
        return cnt;
    }
    public static boolean checkSam(String stringA, String stringB) {
        // write code here
        String [] strA = stringA.split(" ");
        String [] strB= stringB.split(" ");
        Arrays.sort(strA);
        Arrays.sort(strB);
        for(int i = 0;i<strA.length;i++){
            if(!strA[i].equals(strB[i]))
                return false;
        }
        String str="";
        str.lastIndexOf("-1");
        return true;
    }
    static class Fruit{

    }
    static class  Apple extends Fruit{

    }
    public static void get(List<Fruit> list){

    }
    public static void find(Fruit fruit){

    }
    //大数相乘



    public static String reverseVowels(String s) {
        if(s.equals(""))
            return "";
        HashSet<Character > set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char [] chs = s.toCharArray();
        swapVowel(chs,0,s.length()-1,set);
        return new String(chs);
    }
    public static void swap(char [] num ,int l,int r){
        char temp = num[l];
        num[l] =num[r];
        num[r] = temp;
    }
    public static void swapVowel(char [] ch,int l,int r,HashSet set){
        while(l<=r){
            int inr = 0;
            int inl = 0;
            while(l<=r&&!set.contains(ch[r])){

                r--;
            }
            while(l<=r&&!set.contains(ch[l])){

                 l++;
            }
            if(l<r)
            swap(ch,l++,r--);

        }
    }
    public static boolean isSubsequence(String s, String t) {

        char [] str = s.toCharArray();
        char [] tr = t.toCharArray();
        int i =0,j=0;
        while(i<str.length&&j<tr.length){
            if(str[i] == tr[j]){
                i++;j++;
            }
            else
                i++;

        }
        return j==tr.length;
    }
    public static void bigDataComput(int[] num1, int[] num2, int[] result)
    {

        int carry = 0;

        for(int i = 0;i<num1.length;i++){
            carry = 0;
            for(int j = 0;j<num2.length;j++){
                int temp = num1[i]*num2[j]+result[i+j]+carry;
                result[i+j] = temp%10;
                carry = temp/10;
            }
            result[i+num2.length] = carry;

        }
        boolean begin = true;
        for(int i = result.length-1;i>=0;i--){
            if(begin&&result[i]==0)
                    continue;
            else{
                begin = false;
                System.out.print(result[i]);
            }

        }

    }
    public static void getSque(int n ){
        int first = 1;
        int dif = 3;
        ArrayList<Integer> list = new ArrayList<>();
        while(first<=n){
            list.add(first);
            first+=dif;
            dif+=2;
        }
        for(int val:list)
            System.out.print(" "+ val);
    }

    public static void main(String[] args) {
        Num num = new Num();

        //线程1-奇数线程
        new Thread(() -> {
            while (num.number < 100){
                synchronized (num){
                    //奇数
                    if (num.number%2 == 1){
                        System.out.println(Thread.currentThread().getName() + "\t奇数线程：" + num.number);
                        num.number++;
                        num.notifyAll();
                    } else {
                        try {
                            num.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        //线程2-偶数线程
        new Thread(() -> {
            while (num.number < 100){
                synchronized (num){
                    //奇数
                    if (num.number%2 == 1){
                        try {
                            num.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "\t偶数线程：" + num.number);
                        num.number++;
                        num.notifyAll();
                    }
                }
            }
        }).start();
    }


    static class Num {
        public int number = 1;
    }
}
