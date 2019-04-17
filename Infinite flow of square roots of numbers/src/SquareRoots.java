import java.util.Scanner;
import java.util.stream.DoubleStream;


public class SquareRoots {
    public static void main(String[] args) {
        System.out.println("Сколько элементов необходимо вычислить? ");

        Scanner scanner = new Scanner(System.in);
        long y = scanner.nextLong();

        DoubleStream squareRoots = DoubleStream.iterate(0, x -> x + 1).map(Math::sqrt).limit(y);
        squareRoots.forEach(System.out::println);
    }
}
