package com.zyj.bean.reactive;

import reactor.core.publisher.Flux;

public class FluxAndMono {
    public static void main(String[] args) {
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);
        
        System.out.println(numbers.getPrefetch());
        System.out.println(numbers.blockFirst());
        System.out.println("numbers===="+numbers);
    }
}
