import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci {

    public static void main (String[] args) {
        long startTime = System.nanoTime();
        System.out.println(findNthElementFibonacci(36));
        long endTime = System.nanoTime();
        System.out.println(String.format("Recursion took %d milliseconds", (endTime - startTime)/1000000));

        startTime = System.nanoTime();
        System.out.println(findNthElementIterate(46));
        endTime = System.nanoTime();
        System.out.println(String.format("Iteration took %d milliseconds", (endTime - startTime)/1000000));

        printAllFibs(10);
    }
    //Complexity O(n)
    public static int findNthElementIterate(int n) {
        ArrayList<Integer> fibArr = new ArrayList<>(Arrays.asList(0,1));
        for (int i = 2; i < n+1; i++) {
            fibArr.add(fibArr.get(i-1) + fibArr.get(i-2));
        }
        return fibArr.get(n);
    }
    //Complexity O(2^n)
    public static int findNthElementFibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return findNthElementFibonacci(n-1) + findNthElementFibonacci(n-2);
    }

    //Complexity O(2^n)
    public static void printAllFibs(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(findNthElementFibonacci(i));
        }
    }
}
