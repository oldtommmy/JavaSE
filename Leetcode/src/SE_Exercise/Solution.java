package SE_Exercise;

public class Solution {
    public static void main(String[] args) {

        long n = 600851475143L;
        long i = 2;
        long result = 0;

        while (i<n) {
            if (isPrime(i)&&n%i==0) {
                result = i;
            }
            i++;
        }
        System.out.println(result);
    }

    static boolean isPrime(long num) {
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num%i==0) {
                return false;
            }
        }
        return true;
    }
}