import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

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

    static void publishSubjectTest(){
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(s -> System.out.println("publish 1 : " + s));
        subject.onNext("a");
        subject.subscribe(s -> System.out.println("publish 2 : " + s));
        subject.onNext("b");
        subject.onNext("c");
        subject.onComplete();
    }

    static void replaySubjectTest(){
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.onNext("a");
        subject.onNext("b");
        subject.subscribe(s -> System.out.println("replay 1 : " + s));
        subject.onNext("c");
        subject.subscribe(s -> System.out.println("replay 2 : " + s));
        subject.onComplete();
    }

    public static void main(String[] a){
        asyncSubjectTest();
        behaviorSubjectTest();
        publishSubjectTest();
        replaySubjectTest();
    }
}