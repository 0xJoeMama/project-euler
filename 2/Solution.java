// 
// Problem 2
//

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;
import java.util.stream.LongStream;

public class Solution {

    @Contract(pure = true)
    public static @NotNull Supplier<LongStream> createStream(long limit) {
        return () -> {
            LongStream.Builder stream = LongStream.builder();

            stream.add(1);

            long lastFib = 1;
            long temp;
            long fib = 2;
            while (fib <= limit) {
                stream.add(fib);
                temp = fib;
                fib = fib + lastFib;
                lastFib = temp;
            }

            return stream.build();
        };
    }

    public static void main(String[] args) {
        LongStream fibs = createStream(4_000_000).get();

        long sum = fibs.filter(i -> i % 2 == 0).sum();
        System.out.println(sum);
        fibs.close();
    }

}