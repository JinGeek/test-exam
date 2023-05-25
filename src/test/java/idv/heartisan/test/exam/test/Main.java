package idv.heartisan.test.exam.test;

import java.util.*;

/**
 * @author Jin Qi
 * @date 2023/4/21
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(9 % 3);
    }

    public static int solution(int m, int n, List<Integer> fields, int limit) {
        if (n < m) return - 1;
        int k = 1;
        while (k <= limit) {
            int sum = 0;
            for (Integer field : fields) {
                sum += field / k;
                if (field % k > 0) sum += 1;
            }
            if (sum <= n) return k;
            k++;
        }
        return -1;
    }
}
