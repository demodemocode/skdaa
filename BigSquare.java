import java.math.BigInteger;
import java.util.Scanner;

public class BigSquare {
    public static BigInteger multiply(BigInteger x) {
        if (x.toString().length() <= 10) {
            return x.multiply(x);
        }

        int n = x.toString().length();
        int half = n/2;
        BigInteger a = x.divide(BigInteger.TEN.pow(half));
        BigInteger b = x.mod(BigInteger.TEN.pow(half));

        BigInteger ac = multiply(a);
        BigInteger bd = multiply(b);
        BigInteger adPlusBc = multiply(a.add(b)).subtract(ac).subtract(bd);

        return ac.multiply(BigInteger.TEN.pow(2 * half)).add(adPlusBc.multiply(BigInteger.TEN.pow(half))).add(bd);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number");
        BigInteger num = scanner.nextBigInteger();


        BigInteger square = multiply(num);
        System.out.println("The square is : " + square);
    }
}



//TC=O(n^log2^3)=O(n^1.5)    3 mult of n/2 digits
//SC=O(logn)                 ht of tree