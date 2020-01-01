package FastHand;

import java.util.*;

public class Two {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n==0||n==1){
            System.out.print(n);
            return;
        }
        int [] dp = new int [n+1];
        dp[1] = 1;
        for(int i =2;i<=n;i++){
            dp[i] = dp[i-1]*i;
            if(dp[i]%10!=0)
                dp[i] =dp[i]%10;
            else{

                while(dp[i]>10){
                    dp[i]/=10;
                    if(dp[i]%10!=0){
                        dp[i]%=10;
                        break;
                    }
                }
                if(dp[i]==10)
                    dp[i] =1;
            }

        }
            System.out.print(dp[n]);



    }
}
