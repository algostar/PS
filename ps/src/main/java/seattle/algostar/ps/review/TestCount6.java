package seattle.algostar.ps.review;

import java.util.Scanner;

/**
 * Created by maclock on 17. 3. 23.
 */
public class TestCount6 {
    public static void main(String[] args) {
        new TestCount6().run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int findDigit = s.nextInt();
        int totalCnt = 0;
        int totalCntRec = 0;
        for (int n = 1; n <= num; n++) {
            totalCnt += getCount(n, findDigit);
            totalCntRec += getCountRec(n, findDigit);
        }
        System.out.println(totalCnt);
        System.out.println(totalCntRec);
    }

    private int getCount(int n, int findDigit) {
        int cnt = 0;
        int num = n;
        while (num != 0) {
            if (num % 10 == findDigit) cnt++;
            num /= 10;
        }
        return cnt;
    }

    private int getCountRec(int n, int findDigit) {
        if (n == 0) return 0;
        if (n == findDigit) return 1;

        int cnt = getCountRec(n/10, findDigit);
        if (n%10 == findDigit) cnt++;
        return  cnt;
    }
}
