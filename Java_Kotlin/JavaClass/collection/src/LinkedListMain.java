import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListMain {
    public static void main(String[] a){
        List<String> list = new ArrayList<>();
        List<String> lList = new LinkedList<>();
        long startTime;
        long endTime;
        startTime = System.nanoTime();
        for(int i=0; i<100000; i++){
            list.add(0,String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("arrayList 걸린시간 : " + (endTime-startTime));
        startTime = System.nanoTime();
        for(int i=0; i<100000; i++){
            lList.add(0,String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("linkedList 걸린시간 : " + (endTime-startTime));
    }
}
