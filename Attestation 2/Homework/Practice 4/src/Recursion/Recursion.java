package Recursion;

public class Recursion {

    static String sequence(int x) {
        if (x == 1) {
            return "1";
        }
        return sequence(x - 1) + " " + x;
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(sequence(n));
    }
}
