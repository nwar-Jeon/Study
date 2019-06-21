import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReactiveOperatorTest {
    static void mapTest(){
        Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
        Observable<Integer> observable = Observable.fromArray(arr)
                .map(i -> i+5);
        observable.subscribe(System.out::println);
    }

    static void funtionInterfaceTest(){
        Function<String, String> function = d -> d + "+";  // 제네릭 : <매개변수타입, 반환타입>
        String[] arr = {"1","2","3","4"};
        Observable<String> observable = Observable.fromArray(arr)
                .map(function);
        observable.subscribe(System.out::println);
    }

    static void flatMapTest(int a){
        Observable.just(a)
                .flatMap(item -> Observable.range(1,9)
                .map(item2 -> item + " * " + item2 + " = " + item*item2))
                .subscribe(System.out::println);
    }

    static void etcTest(){
        Observable<Integer> observable = Observable.range(0,10);
        observable.subscribe(data -> System.out.println("default : " + data));
        observable.first(11)
                .subscribe(data -> System.out.println("first : " + data));
        observable.last(-1)
                .subscribe(data -> System.out.println("last : " + data));
        observable.take(5)
                .subscribe(data -> System.out.println("take : " + data));
        observable.takeLast(5)
                .subscribe(data -> System.out.println("takeLast : " + data));
        observable.skip(5)
                .subscribe(data -> System.out.println("skip : " + data));
        observable.skipLast(5)
                .subscribe(data -> System.out.println("skipLast : " + data));
    }

    static void reduceTest(){
        String[] arr = {"1","2","3","4"};
        Maybe<String> observable = Observable.fromArray(arr)
                .reduce((item1, item2) -> item2 + "(" + item1 + ")" + item2);
        observable.subscribe(System.out::println);
    }

    static void intervalTest(){
        Observable<Long> observable = Observable.interval(0L,100L, TimeUnit.MILLISECONDS)
                .map(i -> i * 100)
                .take(10);
        CommonUtils.start();
        observable.subscribe(data -> System.out.println((System.currentTimeMillis() - CommonUtils.startTime) + " | value = " + data));
        CommonUtils.sleep(10000);
    }

    static void timerTest(){
        Observable<String> observable = Observable.timer(100L, TimeUnit.MILLISECONDS)
                .map(notUsed ->{
                    return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                            .format(new Date());
                });
        CommonUtils.start();
        observable.subscribe(data -> System.out.println((System.currentTimeMillis() - CommonUtils.startTime) + " | value = " + data));
        CommonUtils.sleep(1000);
    }

    static void rangeTest(int range){
        Observable<Integer> observable = Observable.range(1,range)
                .filter(data -> data % 2 == 0)
                .map(i -> i+1);
        observable.subscribe(data -> System.out.println(data));
    }

    static void intervalRangeTest(int start, int count, int initDelay, int delay){
        Observable<Long> observable = Observable.intervalRange(start, count,initDelay, delay, TimeUnit.MILLISECONDS);
        observable.subscribe(data -> System.out.println(data));
        CommonUtils.sleep(initDelay + delay * count + 100);
    }

    static Observable<String> getObservable(Iterator<String> iterator){
        class Shape {
            String getString(String num, String name) { return num + " "  + name; }
        }
        if(iterator.hasNext()){
            String item = iterator.next();
            Shape shape = new Shape();
            return Observable.just(
                    shape.getString(item,"B"),
                    shape.getString(item,"R"),
                    shape.getString(item,"P")
            );
        }
        return Observable.empty();
    }

    static void deferTest(){
        Iterator<String> iterator = Arrays.asList("1","2","3","4").iterator();
        Callable<Observable<String>> callable = () -> getObservable(iterator);
        Observable<String> observable = Observable.defer(callable);
        observable.subscribe(data -> System.out.println("1 : " + data));
        observable.subscribe(data -> System.out.println("2 : " + data));
        observable.subscribe(data -> System.out.println("3 : " + data));
    }

    static void repeatTest(){
        List<Integer> iterator = new ArrayList<>();
        for(int i=0; i<10; i++){
        iterator.add(new Integer(i));
        }
        Observable<Integer> observable = Observable.fromIterable(iterator)
                .repeat(3);
        observable.subscribe(System.out::println);
    }

    public static void concatMapFlatMap(){
        String[] balls = {"1","2","3"};
        Observable<String> observable = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(idx -> balls[idx])
                .take(balls.length);

        System.out.println("flatMap");
        CommonUtils.start();
        observable.flatMap(ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
            .map(non -> ball + "ㅁ")
            .take(2)).subscribe(data -> {
        System.out.println(System.currentTimeMillis() - CommonUtils.startTime + " | " + data);
        });
        CommonUtils.sleep(1000);

        System.out.println("concatMap");
        CommonUtils.start();
        observable.concatMap(ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
        .map(non -> ball + "ㅁ")
        .take(2)).subscribe(data -> {
            System.out.println(System.currentTimeMillis() - CommonUtils.startTime + " | " + data);
        });
        CommonUtils.sleep(1000);
    }

    public static void main(String[] agrs){
        //mapTest();
        //funtionInterfaceTest();
        //flatMapTest(5);
        //etcTest();
        //reduceTest();
        //intervalTest();
        //timerTest();
        //rangeTest(5);
        //intervalRangeTest(1,10,0,1000);
        //deferTest();
        //repeatTest();
        concatMapFlatMap();
    }
}

class CommonUtils{
    public static long startTime;
    public static void start(){
        startTime = System.currentTimeMillis();
    }
    public static void sleep(int milli){
        try{
            Thread.sleep(milli);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}