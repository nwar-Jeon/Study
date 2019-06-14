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

    public static void main(String[] agrs){
        mapTest();
        funtionInterfaceTest();
    }
}