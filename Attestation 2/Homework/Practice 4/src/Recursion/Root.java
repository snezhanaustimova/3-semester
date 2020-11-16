package Recursion;
import static java.lang.Math.pow;
import static java.lang.Math.cos;

public class Root {

    // метод, к которому мы будем обращаться для решения уравнения
    public static double equation(double x) {
        double result = cos(pow(x, 5)) + pow(x, 4) - 345.3 * x - 23;
        return result;
    }

    // я выполняла задание по информации из википедии
    // для решения нужна фунция sign, которую я не нашла в обычной библиотеке Math,
    // либо просто плохо искала. Поэтому написала ее сама
    private static int sign(double x) {
        if (x > 0) {
            return 1;
        } else if (x < 0) {
            return -1;
        }
        return 0;
    }

    // сам процесс рекурсии
    public static double recursion(double start, double end, double eps) {

        if (end - start <= eps) {
            return start;
        } else {
            double dx = (end - start) / 2;
            double i = start + dx;
            if (sign(equation(start)) != sign(equation(i))) {
                end = i;
            } else {
                start = i;
            }
            return recursion(start, end, eps);
        }
    }

    public static void main(String[] args) {
        double start = 0;
        double end = 10;
        double eps = 0.001;

        if(equation(start) == 0) {
            System.out.println(start);
        }
        if(equation(end) == 0) {
            System.out.println(end);
        } else {
            System.out.println(recursion(start, end, eps));
        }
    }
}
