import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class DisposableTest {
    public static void main(String[] a){
        Observable<Integer> observable = Observable.just(1,2,3,4,5);

        Disposable disposable = observable.subscribe(
                value -> System.out.println("onNext() : " + value),
                err -> System.out.println("onError(): " + err.getMessage()),
                () -> System.out.println("onComplete()")
        );

        System.out.println(disposable.isDisposed());
    }
}
