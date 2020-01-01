package FastHand;

import java.util.*;

public class One {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.print(minNumber(str1,str2));
    }
    public static int minNumber(String str1,String str2){
        if(str1 == null || str2 == null){
            return 0;
        }
        int m = str1.length();
        int n = str2.length();
        int [][] dp = new int [m+1][n+1];

        for(int i = 1;i<=m;i++)
            dp[i][0] = i;

        for(int j =1;j<=n;j++)
            dp[0][j] = j;

        for(int i = 1;i<=m;i++){
            for(int j =1;j<=n;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{

                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[m][n];
    }
}
