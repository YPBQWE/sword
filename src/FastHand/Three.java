package FastHand;

import  java.util.*;
public class Three {
    public static  int cnt =0;
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if(x<0&&y<0){
            x=Math.abs(x);
            y=Math.abs(y);
        }
        else if(x<0){
            cnt+=-1*x+1;
            x=1;
        }else if(y<0){
            cnt+=(x-y);
            System.out.print(cnt);
            return ;
        }

        System.out.print( Math.abs(binarySearch(x,y)));
    }
    public static int binarySearch(int x, int y) {
        int l =x, h = y;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m >= y) {
                h = m;
            } else {
                l = m + 1;
            }
            cnt++;
        }
        return cnt;
    }
}
