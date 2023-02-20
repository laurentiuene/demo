package com.example.demo;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Reactive {
    public static void main(String[] args) {
        Flux<Integer> just1 = Flux.just(1, 2, 3, 4);
        List<Integer> just2 = new ArrayList<>();
        just1.log().subscribe(just2::add);
        System.out.println(just2);

//        ----

        List<String> elements = new ArrayList<>();
        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> i * 2)
                .zipWith(Flux.range(0, Integer.MAX_VALUE),
                        (one, two) -> {
                            System.out.println("First Flux: " + one +" Second Flux: " + two);
                    return String.format("First Flux: %d, Second Flux: %d", one, two);})
                .subscribe(elements::add);

    }
}
