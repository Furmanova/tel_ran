import java.util.stream.IntStream;

public class Factorial {
    public static int getFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        else {
            return IntStream.rangeClosed(2, n).reduce((x, y) -> x * y).getAsInt();
        }
    }
    public static void main(String[] args){
        System.out.println(Factorial.getFactorial(6) - Factorial.getFactorial(4));

    }
}
