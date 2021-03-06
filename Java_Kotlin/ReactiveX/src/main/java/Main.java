import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Main {
    static int a = 5;
    public static void main(String[] args){
        baseTest();

        fromArrayTest();

        iteratorTest();

        callableTest();

        futureTest();

        Flowable<Integer> flow = Flowable.range(1, 10);
        flow.subscribe(System.out::println);

        multipleTable();

        dataQuery();
    }
    static void baseTest(){
        Observable<Integer> observable = Observable.create((ObservableEmitter<Integer> emitter) -> {
            emitter.onNext(a+=5);
            emitter.onNext(a+=5);
            emitter.onNext(a+=5);
            emitter.onComplete();
        });
        observable.subscribe(System.out::println);                          // 메소드 레퍼런스
        observable.subscribe(data -> System.out.println("getA : " + data)); // 람다 표현식
        observable.subscribe(new Consumer<Integer>(){                        // 익명 구현 객체
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("result : " + integer);
            }
        });
    }

    static void fromArrayTest(){
        System.out.println("fromArrayTest");
        Integer[] arr = new Integer[]{1,2,3,4,5};
        Observable<Integer> observable1 = Observable.fromArray(arr);
        observable1.subscribe(System.out::println);
    }

    static void iteratorTest(){
        System.out.println("iteratorTest");
        ArrayList<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("s");
        arr.add("d");

        Observable<String> observable = Observable.fromIterable(arr);
        observable.subscribe(System.out::println);

        Set<String> set = new HashSet<>();
        set.add("s");
        set.add("e");
        set.add("t");
        observable = Observable.fromIterable(set);
        observable.subscribe(System.out::print);

        System.out.println();

        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
        queue.add("q");
        queue.add("ue");
        queue.add("ue");
        observable = Observable.fromIterable(queue);
        observable.subscribe(System.out::print);
        System.out.println();
    }

    static void callableTest(){
        Callable<String> callable = () -> {
            Thread.sleep(1000);
            return "Callable";
        };

        Observable<String> observable = Observable.fromCallable(callable);
        observable.subscribe(System.out::println);


    }

    static void futureTest(){
        Future<String> future = Executors.newSingleThreadExecutor().submit(() ->{
            Thread.sleep(1000);
            return "future";
        });
        Observable<String> observable = Observable.fromFuture(future);
        observable.subscribe(System.out::println);
    }

    static void multipleTable(){
        Function<Integer, Observable<String>> function = i -> Observable.range(1,9)
                .map(j -> i + " * " + j + " = " + j*i);

        Observable<String> observable = Observable.range(1,9)
                .flatMap(function);
        observable.subscribe(System.out::println);

        Observable<String> source = Observable.range(1,9)
                .flatMap(num -> Observable.range(1,9)
                .map(row -> num + " * " + row + " = " + num*row));
        source.subscribe(System.out::println);
    }

    static void dataQuery(){
        List<Pair<String, Integer>> arr = new ArrayList<>();
        arr.add(new Pair<>("TV", 1000));
        arr.add(new Pair<>("TV", 2500));
        arr.add(new Pair<>("ETC", 2000));

        Maybe<Integer> observable = Observable.fromIterable(arr)
                .filter(item -> item.getName().equals("TV"))
                .map(item2 -> item2.getPrice())
                .reduce((i1, i2) -> i1 + i2);
        observable.subscribe(System.out::println);
    }
}

class Pair<T,E>{
    T name;
    E price;
    Pair(T name, E price){
        this.name = name;
        this.price = price;
    }

    public T getName() {
        return name;
    }

    public E getPrice() {
        return price;
    }
}