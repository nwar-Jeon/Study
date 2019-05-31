import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class Main {
    public static void main(String[] args){
        Function<String, Integer> function = str -> Integer.parseInt(str);
        Integer integer = 5;
        try {
            integer = function.apply("10");
        } catch (Exception e){
            System.out.println("exception!");
        }
        Observable.just(integer.toString()).subscribe(System.out::println);

        Observable<Integer> observable = Observable.create((ObservableEmitter<Integer> emitter) -> {
            emitter.onNext(5);
            emitter.onNext(10);
            emitter.onNext(15);
            emitter.onComplete();
        });
        observable.subscribe(System.out::println);
        observable.subscribe(new Consumer<Integer>(){
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("result : " + integer);
            }
        });
    }
}
