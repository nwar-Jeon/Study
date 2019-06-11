import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetMain {
    public static void main(String[] a){
        Set<String> set = new HashSet();
        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java");
        set.add("iBATIS");
        int size = set.size();
        System.out.println("객체 수 : " + size);
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
        }
        set.remove("JDBC");
        set.remove("iBATIS");
        System.out.println("총 객체 수 : " + set.size());
        for(String e : set){
            System.out.println(e);
        }
        set.clear();
        if(set.isEmpty()) {
            System.out.println("set is Empty");
        }
    }
}
