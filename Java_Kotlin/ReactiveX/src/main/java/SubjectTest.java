import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;

public class SubjectTest {
    static void asyncSubjectTest(){
        AsyncSubject<String> asyncSubject = AsyncSubject.create();
        asyncSubject.subscribe(System.out::println);
        asyncSubject.onNext("a");
        asyncSubject.onNext("b");
        asyncSubject.subscribe(System.out::println);
        asyncSubject.onComplete();
        asyncSubject.onNext("c");
        asyncSubject.subscribe(System.out::println);
    }

    static void behaviorSubjectTest(){
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.createDefault("first");
        behaviorSubject.subscribe(d -> System.out.println("1 subscribe : "+ d));// first
        behaviorSubject.onNext("second");
        behaviorSubject.onNext("third");
        behaviorSubject.subscribe(d -> System.out.println("2 subscribe : "+ d));
        behaviorSubject.onNext("fourth");
        behaviorSubject.subscribe(d -> System.out.println("3 subscribe : "+ d));
        behaviorSubject.onComplete();
    }

    public static void main(String[] a){
        asyncSubjectTest();
        behaviorSubjectTest();
    }
}