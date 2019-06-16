import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

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

    public static void main(String[] agrs){
        mapTest();
        funtionInterfaceTest();
        flatMapTest(5);
        etcTest();
        reduceTest();
    }
}