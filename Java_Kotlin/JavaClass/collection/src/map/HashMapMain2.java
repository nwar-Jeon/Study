package map;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain2 {
    public static void main(String[] a){
        Map<Student, Integer> map = new HashMap<>();
        map.put(new Student("name1",30),30);
        map.put(new Student("name1",30),30);
        System.out.println(map.size());

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("asdf",40);
        map1.put("asdf",50);
        System.out.println(map1.size());
    }
}
