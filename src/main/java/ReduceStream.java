import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ReduceStream {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Integer reduce1 = Stream.of(1, 2, 3, 4, 5).filter(x -> x % 2 == 0).reduce(0, Integer::sum);
//        System.out.println(reduce1);
        String reduce1 = Stream.of(1, 2, 3, 4, 5).reduce("", (a,b) -> a +b.toString(), String::concat);
        System.out.println(reduce1);

        long count = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallelStream()
                .peek(x -> System.out.println(Thread.currentThread().getName() + "<---"))
                .count();
//                        .reduce(0, Integer::sum);
//                .collect(Collectors.toList());
        System.out.println(count);

        ExecutorService service = Executors.newFixedThreadPool(2);
        long actualTotal = service.submit(
                () -> List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallelStream()
                        .peek(x -> System.out.println(Thread.currentThread().getName() + "<---"))
                        .reduce(0, Integer::sum)
        ).get();
        System.out.println(actualTotal);

        Thread.sleep(10000);
    }
}
