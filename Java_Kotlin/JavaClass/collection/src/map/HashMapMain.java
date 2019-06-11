package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapMain {
    public static void main(String []a){
        Map<String, Integer> map = new HashMap<>();
        int[] arr = new int[]{85,90,80,95};
        for(int i=3; i>=0; i--){
            map.put((i+1) + "번", arr[i]);
        }
        map.put("1번",10);
        System.out.println("총 entry : " + map.size());
        System.out.println("1번 : "+ map.get("1번"));
        System.out.println();

        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()){
            String key = keyIterator.next();
            Integer value = map.get(key);
            System.out.println(key + " : " + value);
        }
        System.out.println();
        map.remove("1번");
        System.out.println("총 entry 수 : " + map.size());
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while(entryIterator.hasNext()){
            Map.Entry<String, Integer> entry = entryIterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " +value);
        }
        System.out.println();
        map.clear();
        System.out.println("총 entry 수 : " + map.size());
    }
}
