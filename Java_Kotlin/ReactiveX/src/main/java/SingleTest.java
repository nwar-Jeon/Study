import io.reactivex.Observable;
import io.reactivex.Single;

public class SingleTest {
    public static void main(String[] args){
        // 앞에서 공부한 Observable을 Single 객체로 변환하기
        Observable<String> observable = Observable.just("Single");
        Single.fromObservable(observable)
                .subscribe(System.out::println);

        // single()함수를 통해 Single 객체 생성하기
        Observable.just("Single")
                .single("default")
                .subscribe(System.out::println);

        // first()함수를 통해 Single 객체 생성하기
        String[] color = {"Red", "Blue", "Gold"};
        Observable.fromArray(color)
                .first("default1")
                .subscribe(System.out::println);

        // empty Observable에서 Single객체 생성하기
        Observable.empty()
                .single("default2")
                .subscribe(System.out::println);

        // take()함수에서 Single객체 생성하기
        Observable.just("string1", "string2")
                .take(1)
                .single("default")
                .subscribe(System.out::println);
    }
}