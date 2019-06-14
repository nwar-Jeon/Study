import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class ConnectableObservableTest {
    public static void main(String[] args){
        String[] dt = {"1","3","5"};
        Observable<String> observable = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(integer -> dt[integer])
                .take(dt.length);
        ConnectableObservable<String> cObservable = observable.publish();
        cObservable.subscribe(d -> System.out.println("1 : " + d));
        cObservable.subscribe(d -> System.out.println("2 : " + d));
        cObservable.connect();

        cObservable.subscribe(d -> System.out.println("3 : " + d));
    }
}
